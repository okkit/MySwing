package gui;

import java.awt.Font;

import javax.swing.JTextField;

/**
 * Superclass for each input text field  within this project
 */
public class MyTextField extends JTextField {

	public static final Font FONT_TEXT = new Font("Helvetica", Font.PLAIN, 20);

	/**
	 * Construct a text field
	 */
	public MyTextField() {
		super();
		setFont(FONT_TEXT);
	}

	public MyTextField(String text) {
		this();
		setText(text);
	}
	
}










