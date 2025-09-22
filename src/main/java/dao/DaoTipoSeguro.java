package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entidad.*;

public class DaoTipoSeguro {

	public ArrayList<TipoSeguro> listarTipoSeguro() {
		ArrayList<TipoSeguro> lista = new ArrayList<TipoSeguro>();
		String query = "Select * from tiposeguros";
		try {
			Connection cn = new Conexion().getConection();
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				TipoSeguro tipo = new TipoSeguro();
				tipo.setId(rs.getInt("idTipo"));
				tipo.setDescripcion(rs.getString("descripcion"));
				lista.add(tipo);
			}

			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("DaoTipoSeguro | Lista = " + lista);
		return lista;
	}
}
