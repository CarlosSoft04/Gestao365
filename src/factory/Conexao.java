package factory;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static final String USERNAME = "root";
	
	private static final String PASSWORD= "";
	
	private static final String URL = "jdbc:mysql://localhost:3306/BET365";
	
	public static Connection getConexao() throws SQLException {
		
		try {
			return DriverManager.getConnection(URL,USERNAME, PASSWORD);
			
		} catch (SQLException e) {
			System.out.println("Erro ao conectar com o banco de dados");
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public static void main(String[] args) throws SQLException {
		
		
	try(Connection conn = getConexao()) {
		if(conn != null) {
			System.out.println("Conexao feita com sucesso!");
		}else {
			System.out.println("Conexao nao feita");
		}
			
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
	}
	
	
	
	

}
