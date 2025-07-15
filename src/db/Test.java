package db;

import java.time.LocalDate;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {

		testInjection();

		testSelectAllGast();
	}

	private static void testSelectAllGast() {
		ArrayList<Gast> list = Gast.getAllGast();

		System.out.println(list);

	}

	private static void testInjection() {
		Gast gast = new Gast();
		gast.setBirthday(LocalDate.now());
		gast.setAgree(true);
		//"insert into gast (name, birthday, agree) values ('%s', '%s', %b)";
		gast.setName("Name");//', '2025-07-15', true); DELETE FROM gast;");
		gast.saveIntoDB();
	}
}
