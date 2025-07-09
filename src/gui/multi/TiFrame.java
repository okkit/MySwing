package gui.multi;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TiFrame extends JFrame {
	
	public TiFrame() {
		super("Multithreading");
		add(new TiPanel());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(600, 200, 400, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
//		new TiFrame();
//		SwingUtilities.invokeLater(TiFrame::new);
//		System.out.println("Frame thread " + Thread.currentThread());
		
//		new Runnable() {
//		     public void run() {
//		         System.out.println("before think() " + Thread.currentThread());
//		         new TiFrame();
//		     }
//		 }.run();
		
		 SwingUtilities.invokeLater(TiFrame::new);
	}

}
