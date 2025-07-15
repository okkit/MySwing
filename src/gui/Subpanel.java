package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * Class for a sub panel. The purpose of this class is EXCLUSIVELY<br>
 * geometric distribution of child-components within a parent-form
 */
public class Subpanel extends JPanel {

	static int carrent_x = 0;
	static int current_y = 0;
	static int current_width;

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
	 * 
	 * @param factor_x
	 */
	public Subpanel(int percentOfWidth) {
		super();
		setLayout(null);//new GridLayout(1, 1));
		setBackground(Color.WHITE);
		int width = (int) (percentOfWidth * Reg.FRAME_WIDTH / 100.);

		setBounds(carrent_x, 0, width, Reg.FRAME_HEIGHT - 60);
		carrent_x += width;
	}

	/**
	 * Constructs a panel with grid layout. The panel height is calculated<br>
	 * based on the height of the whole frame - 40 px of the over bar
	 * 
	 * @param rows number of rows in the grid
	 * @param cols number of columns in the grid
	 */
	public Subpanel(int rows, int cols, int factor) {
		this(rows, cols);
		int height = (Reg.FRAME_HEIGHT - 40) / factor;

		setBounds(20, current_y, current_width - 40, height);
		current_y += height;
	}

}
