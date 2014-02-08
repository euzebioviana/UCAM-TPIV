package br.com.caelum.jdbc;

import java.sql.*;



public class ConnectionFactory {
	public Connection geConnection(){
		try{
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/f21","postgres","spf@");
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

}
