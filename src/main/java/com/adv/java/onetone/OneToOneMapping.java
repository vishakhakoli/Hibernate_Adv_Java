package com.adv.java.onetone;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.adv.java.hibernate.util.HibernateUtil;

public class OneToOneMapping {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		//set up for 1 questions answer
		Question que = new Question();
		
		que.setQuestionId(1212);
		que.setQuestion("What is Java?");
		
		Answer ans = new Answer();
		
		ans.setAnswerId(343);
		ans.setQuestion(que);
		ans.setAnswer("Java is programming language.");
		
		que.setAnswer(ans);
		
		session.save(ans);
		session.save(que);
		
		//setup for 2nd question and answer
		Question que1 = new Question();
		
		que1.setQuestionId(242);
		que1.setQuestion("What is Collection framework?");
		
		Answer ans1 = new Answer();
		
		ans1.setAnswerId(344);
		ans1.setQuestion(que1);
		ans1.setAnswer("API to work with group of objects.");
		
		que1.setAnswer(ans1);
		
		session.save(ans1);
		session.save(que1);
		
		tx.commit();
		
		//Fetching 
		
		Question q =(Question)session.get(Question.class, 1212);
		System.out.println(q.getQuestion());
		System.out.println(q.getAnswer().getAnswer());
		session.close();
		

	}

}
