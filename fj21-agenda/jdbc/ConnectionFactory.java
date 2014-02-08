package br.com.caelum.jdbc;

import java.sql.*;



public class ConnectionFactory {
	public Connection geConnection(){
		try{
			
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21","root","spf@");
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

}
