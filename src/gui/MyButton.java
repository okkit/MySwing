package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

/**
 * Superclass for ALL buttons within this project
 */
public class MyButton extends JButton {

	/**
	 * Constructs a button
	 * 
	 * @param text button title
	 */
	public MyButton(String text) {
		super(text);
		setFont(new Font("Helvetica", Font.ITALIC, 20));
		setForeground(new Color(34, 98, 134));
		setFocusable(false);
	}

}
