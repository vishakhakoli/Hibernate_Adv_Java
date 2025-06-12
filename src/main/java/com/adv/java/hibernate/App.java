package com.adv.java.hibernate;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

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
        System.out.println(student);
        
        Address address = new Address();
        address.setCity("Sangli");
        address.setStreet("Street1");
        address.setOpen(true);
        address.setAddedDate(new Date());
        address.setX(1.1);
        
        //Reading image
        try {
			FileInputStream fis = new FileInputStream("src/main/java/Algnim.jpg");
			byte[] data = new byte[fis.available()]; 
			fis.read(data);
			address.setImage(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        
        session.save(student);
        session.save(address);
        
        tx.commit();
        
        session.close();
        
        System.out.println("Done..");
        
        
    }
}
