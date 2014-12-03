package ee.itcollege.llaidna;
//package Main;
//
//import java.awt.Dimension;
//import java.awt.Graphics2D;
//import java.awt.event.KeyListener;
//import java.awt.image.BufferedImage;
//
//import javax.swing.JPanel;
//
//import com.sun.prism.Graphics;
//import com.sun.prism.shader.DrawCircle_Color_Loader;
//
//public class GamePanel extends JPanel implements Runnable, KeyListener{
//	
//	// dimensions
//	public static final int WIDTH = 320;
//	public static final int HEIGHT = 240;
//	public static final int SCALE = 2;
//	
//	// game thread
//	private Thread thread; //??
//	private boolean running; // if running or not
//	private int FPS = 60; // set game desired FPS
//	private long targetTime = 1000 / FPS; //??
//	
//	// image canvas to draw on
//	private BufferedImage image;
//	private Graphics2D g;
//	
//	// Constructor -------------------------------------------------
//	public GamePanel() {
//		super();
//		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE)); // scales dimensions by constants
//		setFocusable(true); //??
//		requestFocus(); //??
//		
//	}
//	
//	
//	// is done loading or not
//	public void addNotify() {
//		super.addNotify();
//		if (thread == null) {
//			thread = new Thread(this);
//			addKeyListener(this);
//			thread.start();
//		}
//		
//	}
//	
//	// initializing
//	public void init() {
//		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
//		g = (Graphics2D) g;
//		
//		running = true; // set running true, defined above
//	}
//	
//	public void run() {
//			init();
//			
//			// timestamps
//			long start;
//			long elapsed;
//			long wait;
//			
//			//game loop
//			while(running) { // running set true in init() method
//				start = System.nanoTime(); // timestamp
//				
//				update(); // defined below
//				draw(); // defined below
//				drawToScreen(); // defined below
//				
//				elapsed = System.nanoTime() - start;
//				wait = targetTime - (elapsed / 1 000 000);
//				
//				Thread.sleep(wait); // needs try-catch ??
//				
//		}
//	}
//	
//	private void update() {
//		
//	}
//	
//	private void draw() {
//		
//	}
//	
//	private void drawToScreen() {
//		Graphics g2 = (Graphics) getGraphics();
//		((Graphics2D) g2).drawImage(image, 0, 0, null);
//		((java.awt.Graphics) g2).dispose();
//	}
//	public 
//	
//	
//}
