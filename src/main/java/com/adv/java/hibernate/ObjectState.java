package com.adv.java.hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.adv.java.hibernate.entities.Certificate;
import com.adv.java.hibernate.entities.Student;
import com.adv.java.hibernate.util.HibernateUtil;

public class ObjectState {
 
	public static void main(String[] args) {
		
		
		//creating object
		Student student = new Student();
		student.setId(123);
		student.setsName("Radha");
		student.setPassoutYear(2021);
		student.setCerti(new Certificate("Hibernate", "1 month"));
		//Student : Transient State
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(student);
		student.setsName("Shyam");//Both DB and Session will update
		
		tx.commit();
		//Student : Persistent State
		
		System.out.println(student);
		
		student.setsName("Kiran"); //Only session will change not DB
		System.out.println(student);
		session.close();
		//Student : Detached State
		
	}

}
