package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class MyLabel extends JLabel{
	
	public static final Font FONT_TITLE = new Font("Helvetica", Font.BOLD, 24);
	public static final Font FONT_LABEL = new Font("Helvetica", Font.ITALIC, 20);
/**
	 * 
	 * @param text
	 */
	public MyLabel(String text) {
		super(text);
 
		setFont(FONT_LABEL);
		setForeground(new Color(34, 98, 134));
	}

}
