package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	public static Connection getConexao(){
		
		Connection conexao = null;
		
		String sevidor = "jdbc:mysql://localhost";
		String porta = "3306";
		String banco = "agencia";
		String usuario ="root";
		String senha = "";		
		String url = sevidor + ":" +porta+ "/" +banco;
		
		try{
			
			String driveName ="com.mysql.jdbc.Driver";
			Class.forName(driveName);
			conexao = DriverManager.getConnection(url,usuario,senha);
			
		} catch(Exception e){
			e.getMessage();
		}
		
		return conexao;
	}

}

