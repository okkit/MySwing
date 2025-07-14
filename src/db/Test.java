package db;

import java.time.LocalDate;

public class Test {

	public static void main(String[] args) {
		
		Gast gast = new Gast();
		gast.setName("Eine Gast");
		gast.setBirthday(LocalDate.now());
		gast.setAgree(true);
		
		gast.saveToDB();
		
		gast.setName("Eine nette Gast");
		gast.saveToDB();
	}
}
