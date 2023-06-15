package conectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	static final String URL = "jdbc:postgresql://localhost:5432/postgres"; // O caminho do banco de dados
	static final String USER = "postgres"; // aqui o nome usuario que vc quer acessar
	static final String PASS = "Eurico!2024"; // aqui a senha do banco

	
	//método para criar conexão com o banco de daodos
	public static Connection criarConexao() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection conect = DriverManager.getConnection(URL, USER, PASS);
		if (conect != null) {
			System.out.print("Conexão efetuada com sucesso...");
			return conect;
		}
		return null;
	}

}




