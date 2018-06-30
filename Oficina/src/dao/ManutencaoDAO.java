package dao;

import javax.persistence.EntityManager;

import negocio.Manutencao;
import util.JPAutil;

public class ManutencaoDAO {
	public Manutencao salvar(Manutencao manutencao) throws Exception {
		EntityManager unGerenciadora = JPAutil.getEntityManager();
	    try {
	      unGerenciadora.getTransaction().begin();
	      unGerenciadora.persist(manutencao);
	      unGerenciadora.flush();
	      unGerenciadora.getTransaction().commit();
	    } catch (Exception ex) {
	    	unGerenciadora.getTransaction().rollback();
	    } finally {
	    	unGerenciadora.close();
	    }
	    return manutencao;
	  }
	public Manutencao consultarPorId(int id) {
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		Manutencao man = null;
	    try {
	      man = unGerenciadora.find(Manutencao.class, id);
	    } finally {
	    	unGerenciadora.close();
	    }
	    return man;	
	}
	public void apagar(int id) {
		EntityManager unGerenciadora = JPAutil.getEntityManager();
	    try {
	    	unGerenciadora.getTransaction().begin();
	    	Manutencao man = unGerenciadora.find(Manutencao.class, id);
	      unGerenciadora.remove(man);
	      unGerenciadora.getTransaction().commit();
	    } catch (Exception ex) {
	    	unGerenciadora.getTransaction().rollback();
	    } finally {
	    	unGerenciadora.close();
	    }
	    System.out.println("Manutenção "+id+" excluída.");
	    JPAutil.close();
	  }
}
