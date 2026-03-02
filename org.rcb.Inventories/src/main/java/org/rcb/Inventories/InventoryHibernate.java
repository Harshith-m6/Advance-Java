package org.rcb.Inventories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class InventoryHibernate {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Inventory");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();
	
	public void addInventory(String name , long cost , int availability)
	{
		Inventory p = new Inventory();
		p.setName(name);
		p.setAvailability(availability);
		p.setCost(cost);
		
		et.begin();
		em.persist(p);
		et.commit();
	}
	

}
