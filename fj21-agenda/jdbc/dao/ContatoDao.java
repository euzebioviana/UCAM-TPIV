package br.com.caelum.jdbc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao extends DAOException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4085022508588246931L;
	private Connection connection;
	
	public ContatoDao(){
		this.connection = new ConnectionFactory().geConnection();
	}
	
	public void adiciona(Contato contato){
		String sql = "INSERT INTO contatos(nome,email,endereco,dataNascimento) VALUES(?,?,?,?);";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, (java.sql.Date) new Date(contato.getDataNascimento().getTimeInMillis()));
			
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Contato> getLista(){
		
		List<Contato> contatos = new ArrayList<Contato>();
		try{
		
				Connection connection = new ConnectionFactory().geConnection();
				
				PreparedStatement stmt = connection.prepareStatement("SELECT * FROM contatos");
				
				ResultSet res = stmt.executeQuery();
				
				while(res.next()){
					Contato contato = new Contato();
					contato.setNome(res.getString("nome"));
					contato.setEmail(res.getString("email"));
					contato.setEndereco(res.getString("endereco"));
					
		             Calendar data = Calendar.getInstance();
		             data.setTime(res.getDate("dataNascimento"));
		             contato.setDataNascimento(data);
					

					contatos.add(contato);
				}
				res.close();
				stmt.close();
				
				return contatos;
			
			
		}catch(SQLException e){
			throw new DAOException();
		}
	}
	
	public void altera(Contato contato){
	     String sql = "update contatos set nome=?, email=?, endereco=?," +
	             "dataNascimento=? where id=?";
	     try {
	         PreparedStatement stmt = connection.prepareStatement(sql);
	         stmt.setString(1, contato.getNome());
	         stmt.setString(2, contato.getEmail());
	         stmt.setString(3, contato.getEndereco());
	         stmt.setDate(4, (java.sql.Date) new Date(contato.getDataNascimento()
	                 .getTimeInMillis()));
	         stmt.setLong(5, contato.getId());
	         stmt.execute();
	         stmt.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}
	
	 public void remove(Contato contato) {
	     try {
	         PreparedStatement stmt = connection.prepareStatement("delete" +
	                 "from contatos where id=?");
	         stmt.setLong(1, contato.getId());
	         stmt.execute();
	         stmt.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }

}
