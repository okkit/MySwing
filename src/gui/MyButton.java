package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class MyButton extends JButton {

	public MyButton(String text) {
		super(text);
		setFont(new Font("Helvetica", Font.ITALIC, 20));
		setForeground(new Color(34, 98, 134));
		setFocusable(false);
	}
	
	

}
