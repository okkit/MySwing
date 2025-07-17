/**
 * 
 */
package gui.formular;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bl.Formular;
import gui.DateTextField;
import gui.MessageView;
import gui.MyButton;
import gui.MyCheckBox;
import gui.MyLabel;
import gui.MyPanel;
import gui.MyTextField;
import gui.Subpanel;
import gui.TitleLabel;

/**
 * Represents the form for registration data.<br>
 * The class holds (as fields) and manages all input components. The child
 * components are (geometricly) distributed on different<br>
 * panels (class Subpanel)
 */
public class FormularPanel extends MyPanel implements ActionListener {

	/**
	 * 
	 */
	private static final String ACTION_RESET = "reset";
	private static final String ACTION_SEND = "send";

	private MyTextField textFieldName;
	private DateTextField textFieldGeb;
	MyCheckBox agreementCheckbox; // Muss angeklickt sein.
	// Die Überprüfung, ob, findet in der bl statt. NICHT hier!
	MyButton buttonReset;
	MyButton buttonSend;
	MessageView messageView;
	private Formular form;

	/**
	 * Constructs a panel for registry form This panel has null-Layout therefore by
	 * adding a component to the panel<br>
	 * the bounds of this component have to be set explicitly
	 */
	public FormularPanel() {
		super();
		setLayout(null);
	}

	@Override
	protected void init() {

		Subpanel p = new Subpanel(60);
		initGastPanel(p);
		System.out.println(p);
		add(p);
		p = new Subpanel(40);
		p.setBackground(Color.BLUE);
//		initListPanel(p);
		add(p);
	}

	private void initListPanel(Subpanel panel) {
		panel.add(new Subpanel(0, 1));
	}

	private void initGastPanel(Subpanel panel) {
		panel.add(initTitlePanel( 6));
		panel.add(initInputPanel(3));
		panel.add(initAgreementPanel(8));
		panel.add(initMessagePanel(6));
		panel.add(initButtonPanel(6));
		double sum = 1. / 5. + 1. / 3. + 1. / 4. + 1. / 5.;
		System.out.println("Summe der Höhen: " + sum);
	}

	/**
	 * initializes the buttons.
	 * @param width 
	 * 
	 * @param factor Portion of the total frame height
	 */
	private Subpanel initButtonPanel(int factor) {
		Subpanel p = new Subpanel(1, 2, factor);
		buttonReset = new MyButton("Reset");
		buttonReset.addActionListener(this);
		buttonReset.setActionCommand(ACTION_RESET);
		p.add(buttonReset);

		buttonSend = new MyButton("Send");
		buttonSend.addActionListener(this);
		buttonSend.setActionCommand(ACTION_SEND);
		p.add(buttonSend);
		return p;

	}

	private Subpanel initMessagePanel(int factor) {
		Subpanel p = new Subpanel(1, 1, factor);
		messageView = new MessageView(null); // null weil am Anfang IMMER leer
		p.add(messageView);
		return p;

	}

	private Subpanel initInputPanel(int factor) {
		Subpanel p = new Subpanel(0, 2, factor);

		p.add(new MyLabel("Name*"));
		textFieldName = new MyTextField();
		p.add(textFieldName);

		p.add(new MyLabel("Geburtsdatum°"));
		textFieldGeb = new DateTextField();
		p.add(textFieldGeb);

		return p;
	}

	private Subpanel initAgreementPanel( int factor) {
		Subpanel p = new Subpanel(0, 1, factor);
		agreementCheckbox = new MyCheckBox("Bin mit den Regeln einverstanden");
		p.add(agreementCheckbox);
		return p;
	}

	private Subpanel initTitlePanel(int factor) {
		MyLabel label = new TitleLabel("Hallo hier in meiner ersten Swing-Anwendung");

		Subpanel p = new Subpanel(1, 1, factor);
		p.add(label);
		return p;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		messageView.setText(null);

		if (e.getActionCommand().equals(ACTION_RESET)) {
			resetInputFields();
		} else if (e.getActionCommand().equals(ACTION_SEND)) {

			send();
		}
	}

	private void send() {

		String err = checkInput();
		if (err.isEmpty()) {
			passOverToBL();
		} else {
			messageView.setText(err);
		}
	}

	private void passOverToBL() {
		form = new Formular();

		form.setName(textFieldName.getText());
		form.setBirthday(textFieldGeb.getDate());
		form.setAgree(agreementCheckbox.isSelected());

		form.save();

		messageView.setText(form.getMsg());
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
