package gui.multi;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import gui.MyButton;
import gui.MyLabel;
import gui.MyTextField;

public class TiPanel extends JPanel implements ActionListener {

	private MyLabel tiLabel;
	private MyButton tiButton;
	private MyButton tiButton2;
	MyTextField tiTextField;

	public TiPanel() {

		super();
		setLayout(new GridLayout(0, 1));
		init();
	}

	private void init() {
		tiLabel = new MyLabel("Platzhalter");
		add(tiLabel);
		tiLabel.setText(think());

		tiTextField = new MyTextField();
		add(tiTextField);
		
		tiButton2 = new MyButton("Button2");
		tiButton2.addActionListener(this);
		add(tiButton2);
//
//		Runnable thinking = () -> addButton();;
//		SwingUtilities.invokeLater(thinking);
		
		addButton();
		
	}

	private void addButton() {
		tiButton = new MyButton("Speichern");
		tiButton.addActionListener(this);
		add(tiButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		test();
//		if (e.getSource() == tiButton)
////		withoutThreading();
//			makeResultInThread();
////			setResultInThread();
//		else
//			tiTextField.setText("Testtesttest");
	}
	
	void test() {
		final Runnable thinking = new Runnable() {
		     public void run() {
		         System.out.println("before think() " + Thread.currentThread());
		         think();
		     }
		 };

		 Thread aThread = new Thread() {
		     public void run() {
		         try {
		             SwingUtilities.invokeLater(thinking);
		         }
		         catch (Exception e) {
		             e.printStackTrace();
		         }
		         System.out.println("Finished on " + Thread.currentThread());
		     }
		 };
		 aThread.start();
	}

	void makeResultInThread() {

		String text = "I'm thinking";

		Runnable thinking = () -> tiLabel.setText(think());

		SwingUtilities.invokeLater(thinking);
		tiLabel.setText(text);

		tiLabel.setText("Ready");
	}

	void withoutThreading() {
		tiLabel.setText("I'm thinking");
		String text = think();
		tiLabel.setText(text);
		tiLabel.setText("Ready");
	}

	void setResultInThread() {

		tiLabel.setText("I'm thinking");
		final String text = think();
		tiLabel.setText(text);

		Runnable thinking = new Runnable() {
			public void run() {
				tiLabel.setText(text);
			}
		};
		SwingUtilities.invokeLater(thinking);
		tiLabel.setText("Ready");
	}

	private String think() {
		long time = System.currentTimeMillis();

		for (int i = 0; i < Integer.MAX_VALUE / 2; i++) {
			double a = i * 1.0;
			a = Math.log10(a);
		}

		time = System.currentTimeMillis() - time;
		return "Done " + time;

	}

}
