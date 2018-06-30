package dao;

import javax.persistence.EntityManager;

import negocio.Modelo;
import util.JPAutil;

public class ModeloDAO {
	public Modelo salvar(Modelo modelo) throws Exception {
		EntityManager unGerenciadora = JPAutil.getEntityManager();
	    try {
	      unGerenciadora.getTransaction().begin();
	      unGerenciadora.persist(modelo);
	      unGerenciadora.flush();
	      unGerenciadora.getTransaction().commit();
	    } catch (Exception ex) {
	    	unGerenciadora.getTransaction().rollback();
	    } finally {
	    	unGerenciadora.close();
	    }
	    return modelo;
	  }
	public Modelo consultarPorId(int id) {
		EntityManager unGerenciadora = JPAutil.getEntityManager();
	    Modelo modelo = null;
	    try {
	      modelo = unGerenciadora.find(Modelo.class, id);
	    } finally {
	    	unGerenciadora.close();
	    }
	    return modelo;	
	}
	public void apagar(int id) {
		EntityManager unGerenciadora = JPAutil.getEntityManager();
	    try {
	    	unGerenciadora.getTransaction().begin();
	      Modelo modelo = unGerenciadora.find(Modelo.class, id);
	      unGerenciadora.remove(modelo);
	      unGerenciadora.getTransaction().commit();
	    } catch (Exception ex) {
	    	unGerenciadora.getTransaction().rollback();
	    } finally {
	    	unGerenciadora.close();
	    }
	    System.out.println("Modelo "+id+" excluído.");
	    JPAutil.close();
	  }
}
