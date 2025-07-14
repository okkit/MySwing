package gui;

import java.awt.Font;

import javax.swing.JCheckBox;

public class MyCheckBox extends JCheckBox {

	public MyCheckBox(String text) {
		super(text);
		setFont(new Font("Helvetica", Font.PLAIN, 20));
		setOpaque(false);
	}

}
