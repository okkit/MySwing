package gui;

import java.awt.HeadlessException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

import gui.formular.FormularPanel;

/**
 * Main class
 */
public class Reg extends JFrame {

	public static final int FRAME_X = 600;
	public static final int FRAME_Y = 200;
	public static final int FRAME_WIDTH = 1000;
	public static final int FRAME_HEIGHT = 420;

	
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
		Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.setLevel(Level.ALL);
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        logger.addHandler(handler);

        logger.severe("Schwerwiegender Fehler");
        logger.warning("Warnung");
        logger.info("Information");
        logger.config("Konfigurationshinweis");
        logger.fine("Fein");
        logger.finer("Feiner");
        logger.finest("Am feinsten");
		// TODO
//		SwingUtilities.invokeLater(Reg::new);
	}

}
