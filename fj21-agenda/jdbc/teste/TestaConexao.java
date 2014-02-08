package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.jdbc.ConnectionFactory;

public class TestaConexao {
	
	public static void main(String[] args) throws SQLException{
		Connection connection = new ConnectionFactory().geConnection();
		System.out.println("Conexão aberta!");
		
		String sql = "INSERT INTO contatos(nome,email,endereco,dataNascimento) VALUES(?,?,?,?);";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,"Euzébio");
		stmt.setString(2,"santos.euzebio@gmail.com");
		stmt.setString(3, "Olimpio Pintos");
		stmt.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		
		stmt.execute();
		stmt.close();
		
		System.out.println("Gravado!");
		connection.close();
	}

}
