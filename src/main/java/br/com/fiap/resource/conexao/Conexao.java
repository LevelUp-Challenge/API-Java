package br.com.fiap.resource.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private Connection con = null ;
	
	public Connection abrirConexao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
			final String USER = "RM93423";
			final String PASS = "260404";
			con = DriverManager.getConnection(url, USER, PASS);
			System.out.println("Conexão foi aberta!");
			return con;
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
		
	}
	public static void fecharConexao(Connection con) {
		try {
			con.close();
			System.out.println("Conexao foi fechada!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}