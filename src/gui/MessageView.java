package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;

public class MessageView extends JTextArea {

	public MessageView(String text) {
		super(text);
		setForeground(Color.RED);
		setEditable(false);
		setFont(new Font("Helvetica", Font.PLAIN, 20));
	}

}
