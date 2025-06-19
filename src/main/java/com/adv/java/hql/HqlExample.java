package com.adv.java.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.adv.java.hibernate.entities.Student;
import com.adv.java.onetomany.AnswerManyToOne;
import com.adv.java.onetomany.QuestionOneToMany;
import com.adv.java.hibernate.util.HibernateUtil;

public class HqlExample {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		String query = "from Student where id=:x";
		
		Query q =session.createQuery(query);
		q.setParameter("x", 123)	;	
	  List<Student> s = q.list();
		//List<Student> s = (List<Student>) q.uniqueResult();
		
		for(Student student  : s)
		{
			System.out.println(student.getsName());
		}
		
		//delete 
		
		/*
		 * Query q2 =
		 * session.createQuery("delete from Student s where s.passoutYear=:y");
		 * q2.setParameter("y", 2012); int r=q2.executeUpdate();
		 * System.out.println("deleted record : "+r);
		 */
		
		//update
		
		/*
		 * Query q3 =
		 * session.createQuery("update Student set passoutYear=:p where sName=:n ");
		 * q3.setParameter("p", 2022); q3.setParameter("n", "Kedar"); int r2 =
		 * q3.executeUpdate(); System.out.println("Updated record : "+r2);
		 */
		
		//Join query
		
		Query q4 =session.createQuery("select q.questionId ,q.question ,a.answer from QuestionOneToMany  q INNER JOIN q.answer a");
		List<Object[]> list =q4.getResultList();
		
		for(Object[] ob : list)
		{System.out.println(Arrays.toString(ob));}
		
		
		
		
		 tx.commit(); 
		 session.close();

	}

}
