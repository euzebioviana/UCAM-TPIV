package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaLista {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ContatoDao contatoDao = new ContatoDao();
		Date data = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Contato> contatos = contatoDao.getLista();
		Contato contat = new Contato();
		contat.setId((long) 1);
		contatoDao.altera(contat);
		
		for(Contato contato : contatos){
			  System.out.println("Nome: " + contato.getNome());
			  System.out.println("Email: " + contato.getEmail());
			  System.out.println("Endereço: " + contato.getEndereco());
			  System.out.println("Data de Nascimento: " + 
			              sdf.format(contato.getDataNascimento().getTime())+"\n");
			
		}
		

	}

}
