package com.adv.java.maytomany;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.adv.java.hibernate.util.HibernateUtil;

public class ManyToMany {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Emp e1 = new Emp();
		Emp e2 = new Emp();
		
		e1.seteId(12);
		e1.seteName("Ram");
		
		e2.seteId(13);
		e2.seteName("Shyam");
		
		Project p1=new Project();
		Project p2=new Project();
		
		p1.setpId(2);
		p1.setProjectName("Library Management");
		
		p2.setpId(3);
		p2.setProjectName("Chatbot");
		
		List<Emp> eList = new ArrayList<Emp>();
		List<Project> pList = new ArrayList<Project>();
		eList.add(e1);
		eList.add(e2);
		
		pList.add(p1);
		pList.add(p2);
		
		e1.setProjects(pList);
		p1.setEmps(eList);
		
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);
		
		tx.commit();
		session.close();
		

	}

}
