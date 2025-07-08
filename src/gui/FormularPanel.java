/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

/**
 * 
 */
public class FormularPanel extends JPanel implements ActionListener {

	private static final String ACTION_RESET = "reset";
	private static final String ACTION_SEND = "send";

	private MyTextField textFieldName;
	private MyTextField textFieldGeb;

	MyButton buttonReset;
	MyButton buttonSend;

	/**
	 * Constructs an Frame for gui
	 */
	public FormularPanel() {
		super();
		setBackground(Color.WHITE);
		setLayout(null);
		init();
	}

	/**
	 * 
	 */
	private void init() {

		MyLabel label = new TitleLabel("Hallo hier in meiner ersten Swing-Anwendung");

		Subpanel p = new Subpanel(1, 1, 4);
		p.add(label);
		add(p);

		p = new Subpanel(0, 2, 4);

		p.add(new MyLabel("Name"));
		textFieldName = new MyTextField();
		p.add(textFieldName);
		add(p);

		p.add(new MyLabel("Geburtsdatum"));
		textFieldGeb = new MyTextField();
		p.add(textFieldGeb);
		add(p);

		add (new Subpanel(1, 1, 8));
		
		p = new Subpanel(1, 2, 5);
		buttonReset = new MyButton("Reset");
		buttonReset.addActionListener(this);
		buttonReset.setActionCommand(ACTION_RESET);
		p.add(buttonReset);

		buttonSend = new MyButton("Send");
		buttonSend.addActionListener(this);
		buttonSend.setActionCommand(ACTION_SEND);
		p.add(buttonSend);
		add(p);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals(ACTION_RESET)) {
			textFieldName.setText(null);
			textFieldGeb.setText(null);
		}
	}

}
