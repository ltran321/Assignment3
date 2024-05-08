package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Employee;


public class DBUtil {

	static final String DB_URL = "jdbc:mysql://localhost:3306/hrmanager";
	static final String USER = "root";
	static final String PASS = "Secret55!";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException  {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		return conn;
	}
	
	public static int registerEmployee(Employee emp) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO employee"
				+ "(firstName, lastName, userName, password, emailAddress,hireDate) VALUES " + "(?, ?, ?, ?, ?, ?);";
		int result = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, emp.getFirstname());
			preparedStatement.setString(2, emp.getLastname());
			preparedStatement.setString(3, emp.getUsername());
			preparedStatement.setString(4, emp.getPassword());
			preparedStatement.setString(5, emp.getEmail());
			preparedStatement.setDate(6, new java.sql.Date(emp.getHireDate().getTime()));

			result = preparedStatement.executeUpdate();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return result;
	}
	
	public static List<Employee> getEmployeesFromDatabase() throws ClassNotFoundException {
		List<Employee> employees = new ArrayList<>();
		try(
			Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee");
			ResultSet rs = 	statement.executeQuery();
				){
			while(rs.next()) {
				System.out.println(rs.getInt("id")+"==>"+rs.getString("userName"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return employees;
	}
}
