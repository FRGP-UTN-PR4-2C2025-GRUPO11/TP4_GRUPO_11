package dao;

import entidad.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoSeguro {

	String host = "jdbc:mysql://localhost:3306/";
	String user = "root";
	String pass = "root";
	private String dbName = "segurosgroup?useUnicode=yes&characterEncoding=UTF-8&useSSL=false";

	public DaoSeguro() {
	}

	public int proximoIdSeguro() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Integer proximoIdSeguro = null;

		Connection cn = null;

		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			String query = "SELECT max(idSeguro) as ultimoIdSeguro FROM SEGUROS;";
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				proximoIdSeguro = rs.getInt("ultimoIdSeguro") + 1;

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// cierro conexion
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return proximoIdSeguro;
	}

	public int agregarSeguro() {

		return 0;
	}

	public ArrayList<Seguro> listarSeguros() {

		return null;
	}
}