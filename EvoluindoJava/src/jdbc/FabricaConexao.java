package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FabricaConexao {
	
	public static Connection getConexao() {
		
		try {
			Properties prop = getProperties();
			final String url = prop.getProperty("banco.url");
			final String usuario = prop.getProperty("banco.usuario");
			final String senha = prop.getProperty("banco.senha");		
			
//			final String url = "jdbc:mysql://localhost/db_curso_java?verifyServerCertificate=false&useSSL=true";
//			final String usuario = "root";
//			final String senha = "oluapoas5801";

			return DriverManager.getConnection(url, usuario, senha);

		} catch (SQLException | IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static Properties getProperties() throws IOException {
		Properties prop = new Properties();
		String caminho = "/conexao.properties";
		prop.load(FabricaConexao.class.getResourceAsStream(caminho));
		return prop;
	}

}
