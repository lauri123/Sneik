package ee.itcollege.llaidna;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;
import java.util.Random;

import kuusisto.tinysound.TinySound;
import ee.itcollege.llaidna.audio.PlayMusic;
import ee.itcollege.llaidna.objects.Food;
import ee.itcollege.llaidna.objects.Player;

@SuppressWarnings("serial")
public class Main extends Canvas implements Runnable {
	
	public static final int WIDTH = 300, HEIGHT = WIDTH  / 16 * 30;		// set width and height (16x10). final sets values unchangeable
	private Thread thread;
	public static boolean running = false;									// running = true, false	
	private Random random;												// random
	private Handler handler;											// create instance of handler
	private Overlay overlay;
	private Help help;
	public static int timeri;
	
	/**
	 * @author someone
	 */
	public Main() {
		
		TinySound.init();												// initiates TinySound
		
		handler = new Handler();										// create new handler
		this.addKeyListener(new KeyInput(handler));						// listen for keys
		
		new Window(WIDTH, HEIGHT, "Sneik!", this);						// create new Window class
		
		overlay = new Overlay();		
		help = new Help();
		random = new Random();
		
		// Create Player1 ... with new & addObject to handler
		handler.addObject(new Player(
				clamp(
						(random.nextInt((WIDTH - 0)+ 0)),				// clamps stat X value so doesn't start at edge
						100, 											// min value allowed
						Main.WIDTH - 100), 								// max value allowed
				clamp(
						random.nextInt((HEIGHT - 0)+ 0), 				// clamps stat X value so doesn't start at edge
						100, 											// min value allowed
						Main.HEIGHT - 100),  							// max value allowed
				Id.PLAYER1, 
				handler
				));	
		
		// Create Player2 ... with new & addObject to handler
		handler.addObject(new Player(
				clamp(
						(random.nextInt(WIDTH)),						// clamps stat X value so doesn't start at edge >> random.nextInt((WIDTH - 0)+ 0)
						100, 											// min value allowed
						Main.WIDTH - 100), 								// max value allowed
				clamp(
						(random.nextInt(HEIGHT)), 						// clamps stat X value so doesn't start at edge
						100, 											// min value allowed
						Main.HEIGHT - 100),  							// max value allowed
				Id.PLAYER2, 
				handler
				));
		
		// Create Food ... with new & addObject to handler
		handler.addObject(new Food(
				clamp((random.nextInt(Main.WIDTH)), 100, Main.WIDTH - 100),
				clamp((random.nextInt(Main.HEIGHT)), 100, Main.HEIGHT - 100),
				Id.FOOD
				));
		
		// start music
		PlayMusic.music(true, 0.22);									// true makes loop, value sets volume
	}
	
	/**
	 * Starts a new Thread. Values running = true. Is started from Window.java
	 * "synchronized" is used for threads!
	 * @author someone
	 */
	public synchronized void start() {									// is being called from Window.java. Synchronized used for threads!
		thread = new Thread(this);										// initialize new thread
		thread.start();													// start thread
		running = true;													// set it's running
	}
	
	/**
	 * Stops the thread. Values running = false. Executed in the end of Game loop run().
	 * "synchronized" is used for threads!
	 * @author someone
	 */
	public synchronized void stop() {									// is being called from Game > run. Synchronized used for threads!
		try {
			thread.join();
			running = false;											// say it's not running
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Game loop
	 * @author someone
	 */
	static int FPS = 0;													// make new static variable FPS to be read from Overlay
	public void run() {													// popular game loop typed in here
		this.requestFocus();											// don't have to click on the windows!
		long lastTime = System.nanoTime();								// time with nanosecond precision
		double amountOfTicks = 60.0;									// game speed
		double ns = 1000000000 / amountOfTicks;							
		double delta = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();						// current time in ms
		while(running) {												// while running loop
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;

			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
//				System.out.println("FPS: " + frames);					// prints out FPS to console
				FPS = frames;											// make FPS readable
				frames = 0;
			}
		}
		stop();
	}
	
	/**
	 * Tick method called from run. Makes handler and overlay tick!
	 * @author someone
	 */
	private void tick() {														// called from run
		timeri += 1;
		handler.tick();
		overlay.tick();
		help.tick();
	}
	
	/**
	 * Render called from run. Includes render settings like BufferStrategy. 
	 * Draws background >> handler.render >> overlay.render >> g.dispose >> bs.show
	 * @author someone
	 */
	private void render() {														// called from run
		BufferStrategy bs = this.getBufferStrategy();							// bufferstrategy
		if (bs == null) {
			this.createBufferStrategy(3);										// 3 buffers within the game, must be >=1
			return;
		}

//		Graphics g = bs.getDrawGraphics();										// Graphics without aa
		
		// Graphics2D for with aa
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		RenderingHints hints = new RenderingHints(
		    RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHints(hints);

		// Background
		g.setColor(Color.blue);													// Background color
		g.fillRect(0, 0, WIDTH, HEIGHT);										// Background filled rectangle, size of frame, repaints!!!
		g.setColor(Color.white);
		g.drawRect(3, 3, WIDTH-6, HEIGHT-29);
		
		handler.render(g);
		overlay.render(g);
		help.render(g);
		
		g.dispose();
		bs.show();
		
	}
	
	/**
	 * Clamps variable between min and max.
	 * @param var	input variable to be clamped
	 * @param min	minimum allowed value, clamped down to this
	 * @param max	maximum allowed value, clamped up to this
	 * @return clamped var
	 * @author lauri
	 */
	public static int clamp(int var, int min, int max) {				// clamps value between min and max
		if (var >= max) return max;
		else if (var <= min) return min;
		else return var;
	}
	
	/**
	 * Main method creates new Game instance object
	 * @param args	Typical main-method with args input
	 * @author lauri
	 */
	public static void main(String[] args) {							// main method
		new Main();														// new instance of Game class
	}	
}


// ideas
// - show stats info in corner - kb shortcut i - fps, frames, etc