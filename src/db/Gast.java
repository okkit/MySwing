package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/**
 * This class represents the data base table Gast
 */
public class Gast {

	private static final String INSERT_STMT = "insert into gast (name, birthday, agree) values ('%s', '%s', %b)";
	private static final String UPDATE_STMT = "update gast set name = '%s', birthday = '%s', agree = %b where id = %d";
	private int id;
	private String name;
	private LocalDate birthday;
	private boolean agree;

	/**
	 * Push data into the data base
	 */
	public void saveToDB() {
		Connection connection;
		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MySwing", "root",
					"");
			Statement stmt;
			stmt = connection.createStatement();

			String sql_stmt;
			if (id == 0)
				sql_stmt = String.format(INSERT_STMT, name, birthday, agree);
			else
				sql_stmt = String.format(UPDATE_STMT, name, birthday, agree, id);
			
			stmt.execute(sql_stmt, Statement.RETURN_GENERATED_KEYS);

			ResultSet res = stmt.getGeneratedKeys();
			while (res.next()) {
				id = res.getInt(1); // DB counts from one
			}

		} catch (SQLException e) {
			//TODO Eine Fehler meldung muss weiter bis nach gui gereicht werden
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
