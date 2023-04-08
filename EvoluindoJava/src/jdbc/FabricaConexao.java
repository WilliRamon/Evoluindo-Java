package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FabricaConexao {
	
	public static Connection getConexao() {
		
		try {
			final String url = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true";
			final String usuario = "root";
			final String senha = "oluapoas5801";

			return DriverManager.getConnection(url, usuario, senha);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
