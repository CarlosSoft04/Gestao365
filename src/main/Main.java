package main;

import java.sql.SQLException;

import dao.TabelaDAO;
import model.Tabelas;

public class Main {

	public static void main(String[] args) throws SQLException {
		TabelaDAO dao = new TabelaDAO();

		// Criar
		Tabelas tabela0 = new Tabelas();
		tabela0.setEsporte("Basquete");
		tabela0.setCompeticao("NBA");
		tabela0.setMandante("Flamengo");
		tabela0.setVisitante("Corinthians");
		tabela0.setOdd(2.0);
		tabela0.setValor(700);
		tabela0.setRetorno(1000.0);
		dao.save(tabela0);

		
		//Deletar
		dao.deleteById(1);
		
		
		// Atualizar
		Tabelas t1 = new Tabelas();
		t1.setCompeticao("Camp Espanhol");
		t1.setEsporte("Futsal");
		t1.setMandante("Bahia");
		t1.setValor(11);
		
		t1.setId_aposta(1);
		dao.update(t1);

		
		// Listar
		for (Tabelas t : dao.listar()) {
			System.out.println("Esporte: " + t.getEsporte() + "\nCompeticao: " + t.getCompeticao() + "\nMandante: "
					+ t.getMandante() + "\nVisitante: " + t.getVisitante() + "\nOdd: " + t.getOdd() + "\nValor: "
					+ t.getValor() + "\nRetorno: " + t.getRetorno());

		}
		

	}

}
