package tests.sysout;

import java.time.LocalDate;

import bl.Formular;

public class TestFormular {

	public static void main(String[] args) {

		Formular form = new Formular("Name", LocalDate.of(2007, 5, 10));
		save(form);
		
		form.setAgree(true);
		form.setBirthday(LocalDate.of(2077, 5, 10));
		save(form);

		form.setBirthday(LocalDate.of(2020, 5, 10));
		save(form);
		
		form.setBirthday(LocalDate.of(2005, 5, 10));
		save(form);

	}

	private static void save(Formular form) {
		System.out.println();
		System.out.println(form);
//		Saveable.Result result = form.new Result();
		form.save();
		System.out.println("Save result:  \n" );

	}

}
