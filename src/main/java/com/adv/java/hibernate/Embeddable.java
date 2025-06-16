package com.adv.java.hibernate;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.adv.java.hibernate.entities.Certificate;
import com.adv.java.hibernate.entities.Student;
import com.adv.java.hibernate.util.HibernateUtil;

public class Embeddable {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx =session.beginTransaction();
		
		Student s = new Student();
		s.setId(101);
		s.setsName("Vishakha");
		s.setPassoutYear(2021);
		
		Certificate certificate = new Certificate();
		certificate.setCourse("Hibernate");
		certificate.setDuration("1 Month");
		
		s.setCerti(certificate);
		
		session.save(s);
		tx.commit();
		
		session.close();
		

	}

}
