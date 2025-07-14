package gui;

import java.awt.Color;

import javax.swing.JPanel;

/**
 * Abstract description of a panel in package gui.<br>
 * Because of design of the project, each panel in this package<br>
 * has to have this class as Superclass.<br>
 * The abstract method init() forces the design to be maintained.
 */
public abstract class MyPanel extends JPanel {

	/**
	 * Initializes and add all sub components, i. e. components,<br>
	 * whose parent this panel is.
	 */
	protected abstract void init();

	/**
	 * Constructs a JPanel, set appearance and call <br>
	 * the method init() for initialization of all sup components.
	 */
	public MyPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		init();
	}

}
