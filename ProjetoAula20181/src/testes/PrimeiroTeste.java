package testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidades.Pessoa;
import util.JPAutil;

public class PrimeiroTeste {

	public static void main(String[] args) {

		/* Inserindo uma nova entidade*/
		Pessoa p = new Pessoa();
		p.setNome("Eduardo");
		p.setSalario(2.223);
		
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		EntityTransaction tx = unGerenciadora.getTransaction();
		
		tx.begin();
		
		unGerenciadora.persist(p);
		
		tx.commit();
		JPAutil.close();
		
		/*entidade existente no contexto
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		Pessoa p = unGerenciadora.find(Pessoa.class, 1);
		
		System.out.println("ID: " +p.getId()+" / nome: "+p.getNome());
		
		unGerenciadora.close();
		JPAutil.close();
		*/
		/*Atualizando uma entidade*/
		/*
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		EntityTransaction tx = unGerenciadora.getTransaction();
		
		tx.begin();
		Pessoa p = unGerenciadora.find(Pessoa.class, 1);
		
		System.out.println("Dados Antigos:");
		System.out.println("ID: " +p.getId()+" / Nome: "+p.getNome()+" / Salário: "+p.getSalario());
		
		System.out.println("Alterando os dados");
		p.setNome("Eduardo Gomes");
		p.setSalario(2000.00);
		
		System.out.println("Dados Novos:");
		System.out.println("ID: " +p.getId()+" / Nome: "+p.getNome()+" / Salário: "+p.getSalario());
		
		
		tx.commit();
		unGerenciadora.close();
		JPAutil.close();
		*/
		
		/*Deletando uma entidade*/
		/*
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		EntityTransaction tx = unGerenciadora.getTransaction();
		
		tx.begin();
		Pessoa p = unGerenciadora.find(Pessoa.class, 1);//id
		
		System.out.println("Deletando:");
		System.out.println("ID: " +p.getId()+" / Nome: "+p.getNome()+" / Salário: "+p.getSalario());
		
		unGerenciadora.remove(p);
		
		tx.commit();
		unGerenciadora.close();
		JPAutil.close();
		*/
		
		/*Buscando lista de entidades*/
		/*
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		
		Query query = unGerenciadora.createQuery("from Pessoa p", Pessoa.class);
		
		List<Pessoa> listaPessoas = query.getResultList();
		
		for (Pessoa p : listaPessoas) {
			System.out.println("ID: " +p.getId()+" / Nome: "+p.getNome()+" / Salário: "+p.getSalario());
		}
		unGerenciadora.close();
		JPAutil.close();
		*/
		/*TESTANDO NIVEL DE CACHE PRIMARIO*/
		/*
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		
		Pessoa p1 = unGerenciadora.find(Pessoa.class, 1);
		System.out.println("ID: " +p1.getId()+" / nome: "+p1.getNome());
		
		Pessoa p2 = unGerenciadora.find(Pessoa.class, 1);
		System.out.println("ID: " +p2.getId()+" / nome: "+p2.getNome());
		
		System.out.println("É a mesma entidade? "+(p1==p2));
		
		unGerenciadora.close();
		JPAutil.close();*/
		
		/*TESTANDO NIVEL DE CACHE PRIMARIO com detached*/
		/*
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		
		Pessoa p1 = unGerenciadora.find(Pessoa.class, 1);
		System.out.println("ID: " +p1.getId()+" / nome: "+p1.getNome());
		
		System.out.println("Objeto está sendo gerenciado? "+unGerenciadora.contains(p1));
		
		unGerenciadora.detach(p1);
		
		System.out.println("E agora? Objeto está sendo gerenciado? "+unGerenciadora.contains(p1));
		Pessoa p2 = unGerenciadora.find(Pessoa.class, 1);
		System.out.println("ID: " +p2.getId()+" / nome: "+p2.getNome());
		
		System.out.println("É a mesma entidade? "+(p1==p2));
		
		unGerenciadora.close();
		JPAutil.close();
		*/
		/* Testando sincronização com o método flush*/
		/*
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		EntityTransaction tx = unGerenciadora.getTransaction();
		
		tx.begin();
		
		Pessoa p1 = unGerenciadora.find(Pessoa.class, 1);
		System.out.println("ID: " +p1.getId()+" / nome: "+p1.getNome());
		
		p1.setNome("Teste Flush");
		
		unGerenciadora.flush();
		
		System.out.println("NOVO VALOR- ID: " +p1.getId()+" / nome: "+p1.getNome());
		tx.commit();
		JPAutil.close();
		*/
		
		/* Testando sincronização com o método flush*/
		/*
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		EntityTransaction tx = unGerenciadora.getTransaction();
		
		tx.begin();
		
		Pessoa p1 = unGerenciadora.find(Pessoa.class, 1);
		System.out.println("ID: " +p1.getId()+" / nome: "+p1.getNome());
		
		p1.setNome("Teste Flush");
		
		unGerenciadora.flush();
		
		System.out.println("NOVO VALOR- ID: " +p1.getId()+" / nome: "+p1.getNome());
		tx.commit();
		JPAutil.close();
		*/
		/* Testando sincronização com o método merge*/
/*
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		EntityTransaction tx = unGerenciadora.getTransaction();
		
		tx.begin();
		
		Pessoa p1 = unGerenciadora.find(Pessoa.class, 1);
		System.out.println("ID: " +p1.getId()+" / nome: "+p1.getNome());
		
		tx.commit();
		unGerenciadora.close();
		
		p1.setNome("Teste Merge");
		
		unGerenciadora = JPAutil.getEntityManager();
		tx = unGerenciadora.getTransaction();
		
		tx.begin();
		p1=unGerenciadora.merge(p1);
		tx.commit();
		unGerenciadora.close();
		
		System.out.println("NOVO VALOR- ID: " +p1.getId()+" / nome: "+p1.getNome());
		
		JPAutil.close();
*/
	}

}
