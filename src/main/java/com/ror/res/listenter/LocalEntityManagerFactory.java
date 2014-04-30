package com.ror.res.listenter;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;



public class LocalEntityManagerFactory implements javax.servlet.ServletContextListener {

	private static EntityManagerFactory emf;  

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		if (emf != null) {
			emf.close();  
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			emf = Persistence.createEntityManagerFactory("com.ror.res");
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}

	public static EntityManager createEntityManager() {  
		if (emf == null) {  
			throw new IllegalStateException("Context is not initialized yet.");  
		}  
		return emf.createEntityManager();  
	} 
}
