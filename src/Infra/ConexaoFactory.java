package Infra;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	private static final String USUARIO = "root";
	private static final String SENHA = "root";
	private static final String URL = "jdbc:mysql://localhost:3306/reminders";
	
	public static Connection conectar() throws SQLException {
		
		//Referência ao Driver mysql para versões antigas do Java
		DriverManager.deregisterDriver(new com.mysql.jdbc.Driver());
		
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}
	
	public static void main(String[] args) {
		try {
			Connection conexao = ConexaoFactory.conectar();
			System.out.println("Conectado com sucesso!!!");
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			System.out.println("Conexão Falhou!!!");
		}
	}
}
