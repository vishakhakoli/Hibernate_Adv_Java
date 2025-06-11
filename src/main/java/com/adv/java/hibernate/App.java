package com.adv.java.hibernate;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.adv.java.hibernate.entities.Student;
import com.adv.java.hibernate.util.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        
        Student student = new Student();
        student.setId(001);
        student.setsName("Ravi");
        student.setPassoutYear(2021);
        
        session.save(student);
        
        tx.commit();
        
        session.close();
        
        
    }
}
