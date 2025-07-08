package gui;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public class Reg extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int FRAME_X = 600;
	private static final int FRAME_Y = 200;
	public static final int FRAME_WIDTH = 600;
	public static final int FRAME_HEIGHT = 300;

	
	/**
	 * 
	 * @throws HeadlessException
	 */
	public Reg() throws HeadlessException {
		super("MySwing");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
		

		add(new FormularPanel());

		setResizable(false);
		
		setVisible(true); // Muss IMMER die LETZTE Zeile im Konstruktor sein.
	}



	public static void main(String[] args) {
		
		new Reg();

	}

}
