package daniel.grzelak.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.sqlite.SQLiteConfig;

import daniel.grzelak.classes.Student;
import daniel.grzelak.classes.StudentUniversity;
import daniel.grzelak.classes.University;
import daniel.grzelak.classes.User;
import daniel.grzelak.classes.Entry;


public class Database {

	private static String DRIVER = "org.sqlite.JDBC";
	private static String DB = "jdbc:sqlite:Deansoffice.db";

	private static Connection conn; 
	private static Statement stat; 
	public static void connect() {
		try {
			Class.forName(DRIVER);

			SQLiteConfig conf = new SQLiteConfig();
			conf.enforceForeignKeys(true);
			conn = DriverManager.getConnection(DB, conf.toProperties()); 
			stat = conn.createStatement(); 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void createTables() {

		try {
			String createTableStudent = "create table if not exists Student " + "( "
					+ "id integer primary key autoincrement, " + "name varchar(50) not null, "
					+ "surname varchar(50) not null, " + "age integer not null, " + "studyYear integer not null, "
					+ "mail varchar(50) not null, " + "phone varchar(50) not null " + " );";
			String createTableUniversity = "create table if not exists University " + "( "
					+ "id integer primary key autoincrement, " + "name varchar(50) not null, "
					+ "address varchar(50) not null, " + "mail varchar(50) not null, " + "phone varchar(50) not null "
					+ " );";
			String createTableEntry = "create table if not exists Entry " + "( "
					+ "id integer primary key autoincrement, " + "idS integer not null, " + "idU integer not null, "
					+ "foreign key (idS) references Student(id) on delete cascade on update cascade, "
					+ "foreign key (idU) references University(id) on delete cascade on update cascade " + " );";
			String createTableUser = "create table if not exists User (id integer primary key autoincrement, "
					+ "login varchar(50) not null,"
					+ " password varchar(50) not null, "
					+ "role varchar(50) not null);";
			stat.execute(createTableStudent);
			stat.execute(createTableUniversity);
			stat.execute(createTableEntry);
			stat.execute(createTableUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void insertStudent(Student s) {

		try {
			String insertStudent = "" + "insert into Student " + "(name, surname, age, studyYear, mail, phone) "
					+ "values " + "(?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(insertStudent);
			ps.setString(1, s.getName());
			ps.setString(2, s.getSurname());
			ps.setInt(3, s.getAge());
			ps.setInt(4, s.getStudyYear());
			ps.setString(5, s.getMail());
			ps.setString(6, s.getPhone());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updateStudent(Student s) {

		PreparedStatement ps;
		try {
			String updateStudent = "UPDATE Student SET "
					+ "name = ?, surname = ?, age = ?, studyYear = ?, mail = ?, phone = ? " + "WHERE id = ?";
			ps = conn.prepareStatement(updateStudent);
			ps.setString(1, s.getName());
			ps.setString(2, s.getSurname());
			ps.setInt(3, s.getAge());
			ps.setInt(4, s.getStudyYear());
			ps.setString(5, s.getMail());
			ps.setString(6, s.getPhone());
			ps.setInt(7, s.getId());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	


	public static void deleteStudent(int idx) {
		try {
			String deleteStudent = "DELETE FROM Student WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(deleteStudent);
			ps.setInt(1, idx);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<Student> selectStudent() {
		try {
			List<Student> students = new ArrayList<>();
			String selectStudent = "select * from Student;";
			ResultSet rs = stat.executeQuery(selectStudent);

			while (rs.next()) {
				students.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getString("surname"),
						rs.getInt("age"), rs.getInt("studyYear"), rs.getString("mail"), rs.getString("phone")));
			}
			return students;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static List<Integer> selectStudentIds() {
		try {
			List<Integer> studentsId = new ArrayList<>();
			String selectStudentId = "select * from Student;";
			ResultSet rs = stat.executeQuery(selectStudentId);
			while (rs.next()) {
				studentsId.add(rs.getInt("id"));
			}
			return studentsId;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static List<Integer> selectUniversityIds() {
		try {
			List<Integer> universitiesId = new ArrayList<>();
			String selectUniversityId = "select * from University;";
			ResultSet rs = stat.executeQuery(selectUniversityId);
			while (rs.next()) {
				universitiesId.add(rs.getInt("id"));
			}
			return universitiesId;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static void insertUniversity(University u) {

		try {
			String insertUniversity = "" + "insert into University " + "(name, address, mail, phone) " + "values "
					+ "(?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(insertUniversity);
			ps.setString(1, u.getNameU());
			ps.setString(2, u.getAddress());
			ps.setString(3, u.getMailU());
			ps.setString(4, u.getPhoneU());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<University> selectUniversity() {
		try {
			List<University> universities = new ArrayList<>();
			String selectUniversity = "select * from University;";
			ResultSet rs = stat.executeQuery(selectUniversity);

			while (rs.next()) {
				universities.add(new University(rs.getInt("id"), rs.getString("name"), rs.getString("address"),
						rs.getString("mail"), rs.getString("phone")));

			}
			return universities;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static void updateUniversity(University u) {

		PreparedStatement ps;
		try {
			String updateUniversity = "UPDATE University SET " + "name = ?, address = ?, mail = ?, phone = ? "
					+ "WHERE id = ?";
			ps = conn.prepareStatement(updateUniversity);
			ps.setString(1, u.getNameU());
			ps.setString(2, u.getAddress());
			ps.setString(3, u.getMailU());
			ps.setString(4, u.getPhoneU());
			ps.setInt(5, u.getId());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void deleteUniversity(int idx) {
		try {
			String deleteUniversity = "DELETE FROM University WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(deleteUniversity);
			ps.setInt(1, idx);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void insertEntry(Entry w) {

		try {
			String insertEntry = "" + "insert into Entry " + "(idS, IdU) " + "values " + "(?, ?);";
			PreparedStatement ps = conn.prepareStatement(insertEntry);
			ps.setInt(1, w.getIdS());
			ps.setInt(2, w.getIdU());

			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<Entry> selectEntry() {
		try {
			List<Entry> entries = new ArrayList<>();
			String selectEntry = "select * from Entry;";
			ResultSet rs = stat.executeQuery(selectEntry);

			while (rs.next()) {
				entries.add(new Entry(rs.getInt("id"), rs.getInt("idS"), rs.getInt("idU")));

			}
			return entries;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static void updateEntry(Entry w) {

		PreparedStatement ps;
		try {
			String updateEntry = "UPDATE Wpis SET " + "idS = ?, idU = ? " + "WHERE id = ?";
			ps = conn.prepareStatement(updateEntry);
			ps.setInt(1, w.getIdS());
			ps.setInt(2, w.getIdU());
			ps.setInt(5, w.getId());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void deleteEntry(int idx) {
		try {
			String deleteEntry = "DELETE FROM Wpis WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(deleteEntry);
			ps.setInt(1, idx);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insertUser(User u) {

		try {
			String insertUser = "" + "insert into User " + "(login, password, role) "
					+ "values " + "(?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(insertUser);
			ps.setString(1, u.getLogin());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getRole());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<User> selectUser() {
		try {
			List<User> users = new ArrayList<>();
			String selectUser = "select * from User;";
			ResultSet rs = stat.executeQuery(selectUser);

			while (rs.next()) {
				users.add(new User(rs.getInt("id"), rs.getString("login"), rs.getString("password"),
						rs.getString("role")));

			}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean userMatcher(String login, String password) {
		boolean ifUserExists = false;
		try {
			
			String selectUser = "select * from User where login like ? and password like ?;";
			PreparedStatement ps = conn.prepareStatement(selectUser);
			ps.setString(1, login);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				ifUserExists = true;
			}
			return ifUserExists;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ifUserExists;
		}
		
			
	}
	
	public static User selectUserByLoginAndPassword(String login, String password) {

		try {
			String selectUser = "select * from User where login like ? and password like ?;";
			PreparedStatement ps = conn.prepareStatement(selectUser);
			ps.setString(1, login);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getString("role"));
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public static void updateUser(User u) {

		PreparedStatement ps;
		try {
			String updateUser = "UPDATE User SET " + "login = ?, password = ?, role = ? "
					+ "WHERE id = ?";
			ps = conn.prepareStatement(updateUser);
			ps.setString(1, u.getLogin());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getRole());
			ps.setInt(4, u.getId());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void deleteUser(int idx) {
		try {
			String deleteUser = "DELETE FROM User WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(deleteUser);
			ps.setInt(1, idx);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<StudentUniversity> innerJoin() {
		try {
			List<StudentUniversity> studentsUniversities = new ArrayList<>();

			String selectEntry = "select Entry.id, Student.name, Student.surname, Student.age, Student.studyYear, "
					+ "Student.mail, Student.phone, University.name, University.address, University.mail, University.phone "
					+ "FROM " + "Student INNER JOIN " + "Entry " + "ON Student.id = Entry.idS " + "INNER JOIN "
					+ "University " + "ON Entry.idU = University.id;";

			ResultSet rs = stat.executeQuery(selectEntry);

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String surname = rs.getString(3);
				int age = rs.getInt(4);
				int studyYear = rs.getInt(5);
				String mailS = rs.getString(6);
				String phoneS = rs.getString(7);
				String nameU = rs.getString(8);
				String address = rs.getString(9);
				String mailU = rs.getString(10);
				String phoneU = rs.getString(11);
				studentsUniversities.add(new StudentUniversity(id, name, surname, age, studyYear, mailS, phoneS, nameU,
						address, mailU, phoneU));
			}
			return studentsUniversities;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}

	}

	public static double averageAge() {
		try {
			String sql = "SELECT AVG(age) FROM Student";
			ResultSet rs = stat.executeQuery(sql);
			if (rs.next()) {
				return rs.getDouble(1);
			}
			return -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	public static Student oldestStudent() {

		try {
			String sql = "SELECT * FROM Student WHERE age = (SELECT MAX(age) FROM Student);";
			ResultSet rs = stat.executeQuery(sql);
			if (rs.next()) {
				return new Student(rs.getInt("id"), rs.getString("name"), rs.getString("surname"), rs.getInt("age"),
						rs.getInt("studyYear"), rs.getString("mail"), rs.getString("phone"));
			}
			return null;
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static Student youngestStudent() {

		try {
			String sql = "SELECT * FROM Student WHERE age = (SELECT MIN(age) FROM Student);";
			ResultSet rs = stat.executeQuery(sql);
			if (rs.next()) {
				return new Student(rs.getInt("id"), rs.getString("name"), rs.getString("surname"), rs.getInt("age"),
						rs.getInt("studyYear"), rs.getString("mail"), rs.getString("phone"));
			}
			return null;
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static List<String> studentsOnYear() {

		List<String> countingStudents = new ArrayList<>();
		try {
			String sql = "SELECT studyYear, COUNT(id) FROM Student GROUP BY studyYear;";
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getInt(2));
				countingStudents.add(rs.getInt(1) + " - " + rs.getInt(2));
			}
			return countingStudents;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static List<String> studentsInCities() {
		List<String> countingStudents = new ArrayList<>();

		try {
			String selectWpis = "select University.address, COUNT(DISTINCT Entry.idS) " + "FROM " + "Student INNER JOIN " + "Entry "
					+ "ON Student.id = Entry.idS " + "INNER JOIN " + "University "
					+ "ON Entry.idU = University.id GROUP BY University.address;";
			ResultSet rs = stat.executeQuery(selectWpis);
			while (rs.next()) {
				countingStudents.add(rs.getString(1) + " - " + rs.getInt(2));
			}
			return countingStudents;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	public static List<Integer> ageList() {
		List<Integer> ageList = new ArrayList<>();
		
		try {

			String selectAge = "select distinct age from Student INNER JOIN Entry on Student.id = Entry.IdS "
					+ "INNER JOIN University on Entry.IdU = University.Id;";
			ResultSet rs = stat.executeQuery(selectAge);
			while (rs.next()) {
				ageList.add(rs.getInt(1));
			}
			return ageList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	
}
	public static List<Integer> yearsList() {
		List<Integer> yearsList = new ArrayList<>();
		
		try {

			String selectYear = "select distinct studyYear from Student INNER JOIN Entry on Student.id = Entry.IdS "
					+ "INNER JOIN University on Entry.IdU = University.Id;";
			ResultSet rs = stat.executeQuery(selectYear);
			while (rs.next()) {
				yearsList.add(rs.getInt(1));
			}
			return yearsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	
}
	
	public static List<String> namesList() {
		List<String> namesList = new ArrayList<>();

		try {

			String selectName = "select distinct Student.name from Student INNER JOIN Entry on Student.id = Entry.IdS "
					+ "INNER JOIN University on Entry.IdU = University.Id;";
			ResultSet rs = stat.executeQuery(selectName);
			while (rs.next()) {
				namesList.add(rs.getString(1));
			}
			return namesList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	public static List<String> surnamesList() {
		List<String> surnamesList = new ArrayList<>();

		try {

			String selectSurname = "select distinct Student.surname from Student INNER JOIN Entry on Student.id = Entry.IdS "
					+ "INNER JOIN University on Entry.IdU = University.Id;";
			ResultSet rs = stat.executeQuery(selectSurname);
			while (rs.next()) {
				surnamesList.add(rs.getString(1));
			}
			return surnamesList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	public static List<StudentUniversity> downloadData(
			boolean isNameChecked, List<String> names,
			boolean isSurnameChecked, List<String> surnames,
			boolean isAgeChecked, int ageFrom, int ageTo,
			boolean isYearChecked, int yearFrom, int yearTo
			) 
	{
		try
		{
			String SQL = "select Entry.id, Student.name, Student.surname, Student.age, Student.studyYear, "
					+ "Student.mail, Student.phone, University.name, University.address, University.mail, University.phone "
					+ "FROM " + "Student INNER JOIN " + "Entry " + "ON Student.id = Entry.idS " + "INNER JOIN "
					+ "University " + "ON Entry.idU = University.id WHERE 1 = 1";
			
			String namesFilter = "";
			if (names != null && !names.isEmpty())
			{
				
				namesFilter += " and Student.name IN ('" + String.join("','", names) + "') ";
			}
			
			
			String surnamesFilter = "";
			if (surnames != null && !surnames.isEmpty())
			{
				
				surnamesFilter += " and Student.surname IN ('" + String.join("','", surnames) + "') ";
			}
			
			String agesFilter = " and Student.age BETWEEN " + ageFrom + " AND " + ageTo + " ";
			String yearFilter = " and Student.studyYear BETWEEN " + yearFrom + " AND " + yearTo + " ";
			
			
			if (isNameChecked)
			{
				SQL += namesFilter;
			}
			if (isSurnameChecked)
			{
				SQL += surnamesFilter;
			}
			if (isAgeChecked)
			{
				SQL += agesFilter;
			}
			if(isYearChecked)
			{
				SQL += yearFilter;
			}
			SQL += ";";
			
			System.out.println(SQL);
			
			List<StudentUniversity> studentsUniversities = new ArrayList<>();
			
			ResultSet rs = stat.executeQuery(SQL);
	
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String surname = rs.getString(3);
				int age = rs.getInt(4);
				int studyYear = rs.getInt(5);
				String mailS = rs.getString(6);
				String phoneS = rs.getString(7);
				String nameU = rs.getString(8);
				String address = rs.getString(9);
				String mailU = rs.getString(10);
				String phoneU = rs.getString(11);
				studentsUniversities.add(new StudentUniversity(id, name, surname, age, studyYear, mailS, phoneS, nameU,
						address, mailU, phoneU));
			}
			return studentsUniversities;
	} catch (SQLException e) {

		e.printStackTrace();
		return null;
	}
	}
}


