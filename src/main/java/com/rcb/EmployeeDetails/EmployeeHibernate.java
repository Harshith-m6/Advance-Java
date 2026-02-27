package com.rcb.EmployeeDetails;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeHibernate {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeForm");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();
	
	public void addEmp(String name , long phone , String work)
	{
		Employee e1 = new Employee();
		e1.setName(name);
		e1.setPhone(phone);
		e1.setWork(work);
		
		et.begin();
		em.persist(e1);
		et.commit();
		
		
	}

}
