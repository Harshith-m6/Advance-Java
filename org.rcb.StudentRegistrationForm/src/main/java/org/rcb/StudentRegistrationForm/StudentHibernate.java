package org.rcb.StudentRegistrationForm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentHibernate {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentDetails");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();
	
	public void addStu(String name , String email, String course , double percentage )
	{
		Student s = new Student();
		s.setCourse(course);
		s.setEmail(email);
		s.setName(name);
		s.setPercentage(percentage);
		
		et.begin();
		em.persist(s);
		et.commit();
		
	}

}
