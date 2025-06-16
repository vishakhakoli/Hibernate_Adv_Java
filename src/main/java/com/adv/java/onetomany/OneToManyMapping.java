package com.adv.java.onetomany;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.adv.java.hibernate.util.HibernateUtil;

public class OneToManyMapping {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		//set up for 1 questions answer
		QuestionOneToMany que = new QuestionOneToMany();
		
		que.setQuestionId(1212);
		que.setQuestion("What is Java?");
		
		AnswerManyToOne ans = new AnswerManyToOne();
		
		ans.setAnswerId(343);
		ans.setQuestion(que);
		ans.setAnswer("Java is programming language.");
		
		AnswerManyToOne ans1 = new AnswerManyToOne();
		
		ans1.setAnswerId(344);
		ans1.setQuestion(que);
		ans1.setAnswer("Java is used o build desktop applications.");
		
		AnswerManyToOne ans2 = new AnswerManyToOne();
		
		ans2.setAnswerId(345);
		ans2.setQuestion(que);
		ans2.setAnswer("Java uses OOPS conecpt.");
		
		List<AnswerManyToOne> a = new ArrayList<AnswerManyToOne>();
		a.add(ans);
		a.add(ans1);
		a.add(ans2);
		que.setAnswer(a);
		
		
		session.save(que);
		session.save(ans);
		session.save(ans1);
		session.save(ans2);
		
	
		
		tx.commit();
		
		//Fetching 
		
		/*
		 * QuestionOneToMany q =(QuestionOneToMany)session.get(QuestionOneToMany.class,
		 * 1212); System.out.println(q.getQuestion()); for(AnswerManyToOne s :
		 * q.getAnswer()) { System.out.println(s.getAnswer()); }
		 */
		session.close();
		

	}

}
