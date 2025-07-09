package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

/**
 * Superclass for ALL labels within this project
 */
public class MyLabel extends JLabel {

	public static final Font FONT_TITLE = new Font("Helvetica", Font.BOLD, 24);
	public static final Font FONT_LABEL = new Font("Helvetica", Font.ITALIC, 20);

	/**
	 * Constructs a label
	 * 
	 * @param text text to show
	 */
	public MyLabel(String text) {
		super(text);

		setFont(FONT_LABEL);
		setForeground(new Color(34, 98, 134));
	}

}
