package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * Class for a sub panel. The purpose of this class is EXCLUSIVELY<br>
 * geometric distribution of child-components within a parent-form
 */
public class Subpanel extends JPanel {

	static int y = 5;

	/**
	 * Constructs a panel with grid layout.
	 * 
	 * @param rows number of rows in the grid
	 * @param cols number of columns in the grid
	 */
	public Subpanel(int rows, int cols) {
		super();
		setBackground(Color.WHITE);
		setLayout(new GridLayout(rows, cols));
	}

	/**
	 * Constructs a panel with grid layout. The panel height is calculated<br>
	 * based on the height of the whole frame
	 * 
	 * @param rows number of rows in the grid
	 * @param cols number of columns in the grid
	 */
	public Subpanel(int rows, int cols, int factor) {
		this(rows, cols);
		int height = Reg.FRAME_HEIGHT / factor;

		setBounds(20, y, Reg.FRAME_WIDTH - 40, height);
		y += height;
	}

}
