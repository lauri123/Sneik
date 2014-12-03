package Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {
	
//	private static final long serialVersionUID = -1285670934175365101L;
	public static final int WIDTH = 640, HEIGHT = WIDTH  / 16 * 10;	// set width and height (16x10)
	
	private Thread thread;
	private boolean running = false;									// running = true, false
	
	private Random r;													// random
	private Handler handler;											// create instance of handler
	private Overlay overlay;
	
	public Game() {
		handler = new Handler();										// create new handler
		this.addKeyListener(new KeyInput(handler));							// listen for keys
		
		new Window(WIDTH, HEIGHT, "Sneik!", this);			// create new Window class
		
		overlay = new Overlay();
		
		r = new Random();
		
		handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler));	// addObject to handler, create in the middle of the screen
		handler.addObject(new Player(WIDTH/2+32, HEIGHT/2+32, ID.Player2, handler));	// addObject to handler, create in the middle of the screen
		handler.addObject(new BasicEnemy((r.nextInt(WIDTH-16)),(r.nextInt(HEIGHT-16)), ID.BasicEnemy));	// addObject to handler, create in the middle of the screen
		handler.addObject(new BasicEnemy((r.nextInt(WIDTH-16)),(r.nextInt(HEIGHT-16)), ID.BasicEnemy));	// addObject to handler, create in the middle of the screen
		handler.addObject(new BasicEnemy((r.nextInt(WIDTH-16)),(r.nextInt(HEIGHT-16)), ID.BasicEnemy));	// addObject to handler, create in the middle of the screen
		
	}
	
	public synchronized void start() {									// is being called from Window.java
		thread = new Thread(this);										// initialize new thread
		thread.start();													// start thread
		running = true;													// say it's running
	}
	
	public synchronized void stop() {									// is being called from Game > run
		try {
			thread.join();
			running = false;											// say it's not running
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
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
				System.out.println("FPS: " + frames);					// prints out FPS to console
				FPS = frames;											// make FPS readable
				frames = 0;
			}
		}
		stop();
	}
	
	/**
	 * Tick method called from run. Makes handler and overlay tick!
	 */
	private void tick() {														// called from run
		handler.tick();
		overlay.tick();
	}
	
	/**
	 * Render method called from run. Includes render settings like BufferStrategy. 
	 * Draws background >> handler.render >> overlay.render > g.dispose > bs.show
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
		
		handler.render(g);
		overlay.render(g);
		
		g.dispose();
		bs.show();
		
	}
	
	
	/**
	 * Clamps variable between min and max.
	 * @param var
	 * @param min
	 * @param max
	 * @return clamped var
	 */
	public static int clamp(int var, int min, int max) {				// clamps value between min and max
		if (var >= max) {
			return var = max;
		}
		else if (var <= min) {
			return var = min;
		}
		else {
			return var;
		}
	}
	
	public static void main(String[] args) {							// main method
		new Game();														// new instance of Game class
	}

}


// ideas
// - show stats info in corner - kb shortcut i - fps, frames, etc