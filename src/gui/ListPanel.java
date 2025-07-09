package gui;

import javax.swing.JPanel;

public class ListPanel extends JPanel {
	
	TitleLabel label;
	
	public ListPanel() {
		
		super();
		init();
	}

	private void init() {
		label = new TitleLabel("Liste");
		add(label);
		
	}

}
