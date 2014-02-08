package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaInsere {
	
	public static void main(String[]args){
		
		Contato contato = new Contato();
		contato.setNome("Caelum");
		contato.setEmail("contato@caelum.com.br");
		contato.setEndereco("Rua Principal");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDao contatoDao = new ContatoDao();
		contatoDao.adiciona(contato);
		System.out.println("Adcionado!");
		
	}


	
}
