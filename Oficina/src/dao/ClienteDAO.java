package dao;

import javax.persistence.EntityManager;

import negocio.Cliente;
import util.JPAutil;

public class ClienteDAO {
	public Cliente salvar(Cliente cliente) throws Exception {
		EntityManager unGerenciadora = JPAutil.getEntityManager();
	    try {
	      unGerenciadora.getTransaction().begin();
	      unGerenciadora.persist(cliente);
	      unGerenciadora.flush();
	      unGerenciadora.getTransaction().commit();
	    } catch (Exception ex) {
	    	unGerenciadora.getTransaction().rollback();
	    } finally {
	    	unGerenciadora.close();
	    }
	    return cliente;
	  }
	public Cliente consultarPorId(int id) {
		EntityManager unGerenciadora = JPAutil.getEntityManager();
	    Cliente cliente = null;
	    try {
	      cliente = unGerenciadora.find(Cliente.class, id);
	    } finally {
	    	unGerenciadora.close();
	    }
	    return cliente;	
	}
	public void apagar(int id) {
		EntityManager unGerenciadora = JPAutil.getEntityManager();
	    try {
	    	unGerenciadora.getTransaction().begin();
	      Cliente cliente = unGerenciadora.find(Cliente.class, id);
	      unGerenciadora.remove(cliente);
	      unGerenciadora.getTransaction().commit();
	    } catch (Exception ex) {
	    	unGerenciadora.getTransaction().rollback();
	    } finally {
	    	unGerenciadora.close();
	    }
	    System.out.println("Cliente "+id+" excluído.");
	    JPAutil.close();
	  }
}
