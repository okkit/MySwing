package gui;

import java.awt.Font;

import javax.swing.JTextField;

public class MyTextField extends JTextField {

	public static final Font FONT_TEXT = new Font("Helvetica", Font.PLAIN, 20);
	
	public MyTextField() {
		super();
		setFont(FONT_TEXT);
	}
	
}
