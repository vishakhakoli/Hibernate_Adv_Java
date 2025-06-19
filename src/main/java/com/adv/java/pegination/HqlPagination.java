package com.adv.java.pegination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.adv.java.hibernate.entities.Student;
import com.adv.java.hibernate.util.HibernateUtil;

public class HqlPagination {

	public static void main(String[] args) {
		

		Session session =HibernateUtil.getSessionFactory().openSession();
		
		Query query = session.createQuery("from Student");
		
		//start position
		query.setFirstResult(0);
		
		//max results from starting position
		query.setMaxResults(10);
		
	    List<Student> list =query.list();
	    for(Student s :list)
	    {
	    	System.out.println(s.getId() +" :"+s.getsName() +" :"+s.getCerti().getCourse());
	    }
		
		
	}

}
