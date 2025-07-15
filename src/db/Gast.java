package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class represents the data base table Gast
 */
public class Gast implements DBConstants{

//	private static final String INSERT_STMT = "insert into gast (name, birthday, agree) values ('%s', '%s', %b)";
//	private static final String UPDATE_STMT = "update gast set name = '%s', birthday = '%s', agree = %b where id = %d";
	
	private static final String INSERT_STMT_2 = "insert into gast (name, birthday, agree) values (?, ?, ?)";
	private static final String UPDATE_STMT_2 = "update gast set name = ?, birthday = ?, agree = ? where id = ?";
	
	private static final String ID = "id";
	private static final String NAME = "name";
	
	private int id;
	private String name;
	private LocalDate birthday;
	private boolean agree;
	
	public static ArrayList<Gast> getAllGast(){
		
		ArrayList<Gast> list = new ArrayList<Gast>();
		Gast gast;
		Connection connection = null;
		try {

			connection = DriverManager.getConnection(URL, USER, PASSWD);
			Statement query = connection.createStatement();
			
			ResultSet res =query.executeQuery("Select * from gast");
			while (res.next()) {
				gast = new Gast();
				gast.id = res.getInt(ID);
				gast.name = res.getString(NAME);
				
				list.add(gast);
			}

			query.close();
			connection.close();
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}



	public String saveIntoDB() {

		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD)) {

			if (id == 0) {

				try (PreparedStatement pstmt = connection.prepareStatement(INSERT_STMT_2,
						Statement.RETURN_GENERATED_KEYS)) {

					setValues(pstmt);
					System.out.println(pstmt);
					pstmt.execute();
					try (ResultSet res = pstmt.getGeneratedKeys()) {
						if (res.next()) {
							id = res.getInt(1);
						}
					}
				}

			} else {

				try (PreparedStatement pstmt = connection.prepareStatement(UPDATE_STMT_2)) {
					setValues(pstmt);
					pstmt.executeUpdate();
				}
			}

		} catch (SQLException e) {
			return e.getMessage();
		} 
		return null;
	}

	private void setValues(PreparedStatement pstmt) throws SQLException {
		pstmt.setString(1, name);
		pstmt.setDate(2, java.sql.Date.valueOf(birthday));
		pstmt.setBoolean(3, agree);
		if (id != 0)
			pstmt.setInt(4, id);

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
