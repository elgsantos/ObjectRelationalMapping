package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAutil {

	private static EntityManagerFactory fabrica;
	static {
		fabrica = Persistence.createEntityManagerFactory("ProjetoAula20181");
	}
	
	public static EntityManager getEntityManager() {
		return fabrica.createEntityManager();
	}
	
	public static void close() {
		fabrica.close();
	}
}
