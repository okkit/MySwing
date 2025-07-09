package bl;

import java.time.LocalDate;

public class Formular {

	private String name;
	private LocalDate birthday;

	public Formular() {
		super();
	}

	public Formular(String name, LocalDate birthday) {
		super();
		this.name = name;
		this.birthday = birthday;
	}

	public String toString() {
		String info = "Formular: \n";
		info += "Name:		" + name + "\n";
		info += "Geburtsdatum:	" + birthday;
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

}
