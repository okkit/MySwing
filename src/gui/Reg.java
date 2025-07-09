package gui;

import java.awt.HeadlessException;

import javax.swing.JFrame;

/**
 * Main class
 */
public class Reg extends JFrame {

	public static final int FRAME_X = 600;
	public static final int FRAME_Y = 200;
	public static final int FRAME_WIDTH = 600;
	public static final int FRAME_HEIGHT = 300;

	
	/**
	 * Constracs the application frame
	 * @throws HeadlessException
	 */
	public Reg() throws HeadlessException {
		super("MySwing");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);

		add(new FormularPanel());	
		setVisible(true); // Muss IMMER die LETZTE Zeile im Konstruktor sein.
	}



	/**
	 * starts the program
	 * @param args
	 */
	public static void main(String[] args) {
		
		new Reg();
		// TODO
//		SwingUtilities.invokeLater(Reg::new);
	}

}
