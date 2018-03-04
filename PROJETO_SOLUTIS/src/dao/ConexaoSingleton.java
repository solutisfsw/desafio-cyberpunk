package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoSingleton {
	private static ConexaoSingleton singleton = null;
	private Connection con;
	
	public static Connection getInstance() {
		if (singleton == null){
			singleton = new ConexaoSingleton();
		}
		return singleton.con;
	}
	 
	private ConexaoSingleton(){
	 try{
		 	Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SOLUTIS",
					"root", "root");
			System.out.println("Banco Conectado com sucesso!");
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Nao foi possível realizar a conexao!!!");
		}
	}
}
