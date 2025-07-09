/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import bl.Formular;

/**
 * 
 */
public class FormularPanel extends JPanel implements ActionListener {

	private static final String ACTION_RESET = "reset";
	private static final String ACTION_SEND = "send";

	private MyTextField textFieldName;
	private DateTextField textFieldGeb;

	MyButton buttonReset;
	MyButton buttonSend;
	MessageView messageView;

	/**
	 * Constructs a panel for registry form This panel has null-Layout therefore by
	 * adding a component to the panel<br>
	 * the bounds of this component have to be set explicitly
	 */
	public FormularPanel() {
		super();
		setBackground(Color.WHITE);
		setLayout(null);
		init();
	}

	/**
	 * Initializes and add all components to this panel
	 */
	private void init() {

		MyLabel label = new TitleLabel("Hallo hier in meiner ersten Swing-Anwendung");

		Subpanel p = new Subpanel(1, 1, 5);
		p.add(label);
		add(p);

		p = new Subpanel(0, 2, 4);

		p.add(new MyLabel("Name*"));
		textFieldName = new MyTextField();
		p.add(textFieldName);
		add(p);

		p.add(new MyLabel("Geburtsdatum°"));
		textFieldGeb = new DateTextField();
		p.add(textFieldGeb);
		add(p);

		p = new Subpanel(1, 1, 6);
		messageView = new MessageView(null); // null weil am Anfang IMMER leer
		p.add(messageView);
		add(p);

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
			resetInputFields();
		} else if (e.getActionCommand().equals(ACTION_SEND)) {

			String err = checkInput(); // Check alle inputfelder
			if (err.isEmpty()) { // check erfolg
				send(); // sende
			} else {

				messageView.setText(err);
			}

		}
	}

	private void send() {
		
		Formular form = new Formular();
		form.setName(textFieldName.getText());

		form.setBirthday(textFieldGeb.getDate());
		
	}

	/**
	 * Validates all input
	 * 
	 * @return Message in case of error otherwise ""
	 */
	private String checkInput() {

		String msg = "";

		if (textFieldName.getText().trim().isEmpty()) {
			msg += "Name fehlt\n" + "";
		}

		msg += textFieldGeb.check(); // liefert "", wenn keine Fehler

		return msg;

	}

	/**
	 * Clears all input fields
	 */
	private void resetInputFields() {
		textFieldName.setText(null);
		textFieldGeb.setText(null);
	}

}
