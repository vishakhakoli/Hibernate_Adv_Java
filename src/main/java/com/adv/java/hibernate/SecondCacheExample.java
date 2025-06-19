package com.adv.java.hibernate;

import org.hibernate.Session;

import com.adv.java.hibernate.entities.Student;
import com.adv.java.hibernate.util.HibernateUtil;

public class SecondCacheExample {

	public static void main(String[] args) {
		
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		
		Student s=session1.get(Student.class, 1);
		System.out.println(s);
		
		session1.close();
		
		Session session2 = HibernateUtil.getSessionFactory().openSession();
		
		Student s1=session2.get(Student.class, 1);
		System.out.println(s1);
		session1.close();
		
	}

}
