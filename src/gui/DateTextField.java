package gui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class DateTextField extends MyTextField {

	public static final String FORMAT = "tt.mm.jjjj";
	private static final String FORMAT_PARSE = "dd.MM.uuuu";
	LocalDate date;

	public DateTextField() {
		this(FORMAT);
	}

	public DateTextField(String text) {
		super(text);
	}

	public String check() {

		String txt = getText();
		if (txt.trim().isEmpty() || txt.equals(FORMAT)) {
			return "Geburtstag fehlt";
		} else {
			try {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_PARSE)
						.withResolverStyle(ResolverStyle.STRICT);
				date = LocalDate.parse(txt, formatter);

			} catch (DateTimeParseException e) {
				return "Geburtsdatum ist kein gültiges Datum";
			}
		}
		return "";
	}

	public LocalDate getDate() {
	
		return date;
	}
}
