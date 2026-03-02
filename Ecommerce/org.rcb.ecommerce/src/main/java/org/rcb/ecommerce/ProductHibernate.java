package org.rcb.ecommerce;

import java.util.logging.ErrorManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ProductHibernate {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProductDetails");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();
	
	public void addStudent(String name , double cost , String brand , int rating)
	{
		Product p = new Product();
		p.setBrand(brand);
		p.setCost(cost);
		p.setName(name);
		p.setRating(rating);
		et.begin();
		em.persist(p);
		et.commit();
	}
	
	public Product fetchProduct(int id)
	{
		return em.find(Product.class, id);
	}
	
	public boolean updateProduct(int id , String name , int rating , String brand)
	{
		Product p = em.find(Product.class, id);
		if(p!=null)
		{
			p.setBrand(brand);
			p.setCost(rating);
			p.setName(name);
			p.setRating(rating);
			et.begin();
			em.merge(p);
			et.commit();
			return true;
		}else {
			return false;
		}
	}
	
	public boolean removeProduct(int id)
	{
		Product p = em.find(Product.class, id);
		if(p!=null)
		{
			et.begin();
			em.remove(p);
			et.commit();
			return true;
		}else {
			return false;
		}
		
	}
	
	
}

