package dao;

import javax.persistence.EntityManager;

import negocio.Carro;
import util.JPAutil;

public class CarroDAO {
	public Carro salvar(Carro carro) throws Exception {
		EntityManager unGerenciadora = JPAutil.getEntityManager();
	    try {
	      unGerenciadora.getTransaction().begin();
	      unGerenciadora.persist(carro);
	      unGerenciadora.flush();
	      unGerenciadora.getTransaction().commit();
	    } catch (Exception ex) {
	    	unGerenciadora.getTransaction().rollback();
	    } finally {
	    	unGerenciadora.close();
	    }
	    return carro;
	  }
	public Carro consultarPorId(int id) {
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		Carro carro = null;
	    try {
	      carro = unGerenciadora.find(Carro.class, id);
	    } finally {
	    	unGerenciadora.close();
	    }
	    return carro;	
	}
	public void apagar(int id) {
		EntityManager unGerenciadora = JPAutil.getEntityManager();
	    try {
	    	unGerenciadora.getTransaction().begin();
	    	Carro carro = unGerenciadora.find(Carro.class, id);
	      unGerenciadora.remove(carro);
	      unGerenciadora.getTransaction().commit();
	    } catch (Exception ex) {
	    	unGerenciadora.getTransaction().rollback();
	    } finally {
	    	unGerenciadora.close();
	    }
	    System.out.println("Carro "+id+" excluído.");
	    JPAutil.close();
	  }
}
