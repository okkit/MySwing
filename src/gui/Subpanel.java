package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Subpanel extends JPanel {

	static int y = 5;
	
	public Subpanel(int rows, int cols) {
		super();
		setBackground(Color.WHITE);
		setLayout(new GridLayout(rows, cols));
	}

	public Subpanel(int rows, int cols, int factor) {
		this(rows, cols);
		int height = Reg.FRAME_HEIGHT / factor;
		
		setBounds(20, y, Reg.FRAME_WIDTH - 40, height);
		y += height;
	}

}






