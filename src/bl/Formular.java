package bl;

import java.time.LocalDate;

import db.Gast;

public class Formular {

	private static final String SUCCESS_MSG = "Das Formular wurde erfolgreich gespeichert";
	private static final String ERR_AGE = "Du bist zu jung für diese Party :-(";
	private static final String ERR_BIRTHDAY = "Das Geburtsdatum liegt in der Zukunft";
	private static final String ERR_EGREE = "Bitte die Regeln anklicken";

	private String name;
	private LocalDate birthday;
	private boolean agree = false;
	String msg;

	public Formular() {
		super();
	}

	public Formular(String name, LocalDate birthday) {
		super();
		this.name = name;
		this.birthday = birthday;
	}

	/**
	 * Pass over to db-tier
	 */
	public void save() {

//		validate(); // TODO falls falsch, muss das weitere verhindert werden
		Gast gast = new Gast();
		gast.setName(name);
		gast.setBirthday(birthday);
		gast.setAgree(agree);
		gast.saveToDB();
	}

	public boolean validate() {

		boolean ok = validateAgree();
		ok &= validateBirthday();
		return ok;
	}

	private boolean validateAgree() {

		if (!agree) {
			msg += ERR_EGREE;
			return false;
		}
		return true;
	}

	private boolean validateBirthday() {
		LocalDate now = LocalDate.now();
		if (birthday.isAfter(now)) {
			msg += ERR_BIRTHDAY;
			return false;
		}
		LocalDate date = birthday.plusYears(18);
		if (date.isAfter(now)) {
			msg += ERR_AGE;
			return false;
		}
		return true;
	}

	public String toString() {
		String info = "Formular: \n";
		info += "Name:		" + name + "\n";
		info += "Geburtsdatum:	" + birthday + "\n";
		info += "Agreement:	" + agree;
		return info;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public boolean isAgree() {
		return agree;
	}

	public void setAgree(boolean agree) {
		this.agree = agree;
	}

}
