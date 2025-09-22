package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	String host = "jdbc:mysql://localhost:3306/";
	String user = "root";
	String pass = "root";
	private String dbName = "segurosgroup?useUnicode=yes&characterEncoding=UTF-8&useSSL=false";


	public Conexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(host + dbName, this.user, this.pass);
			return connection;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
