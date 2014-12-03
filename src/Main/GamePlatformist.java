package Main;

import javax.swing.JFrame;

public class GamePlatformist {
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame("Sneik"); //new window with title
//		window.setContentPane(new GamePanel()); //If you want to add visual elements to your frame, use setContentPane(component) (or add(component)). https://stackoverflow.com/questions/14174310/difference-between-setcontentpane-dolayout-setlayout-in-a-jframe-java
		window.setLayout(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit program when window closed
		window.setResizable(false); //resize not allowed
		window.pack(); //??
		window.setVisible(true); //?? make window visible
		
	}
}
