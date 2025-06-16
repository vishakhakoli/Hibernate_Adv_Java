package com.adv.java.hibernate;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.adv.java.hibernate.entities.Address;
import com.adv.java.hibernate.entities.Student;
import com.adv.java.hibernate.util.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        
        Student student = new Student();
        student.setId(004);
        student.setsName("Radha");
        student.setPassoutYear(2022);
        
        
        System.out.println(student);
        
        Address address = new Address();
        address.setCity("Dhule");
        address.setStreet("Street4");
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
        
       Student st= (Student)session.load(Student.class, 1);
       Student st1= (Student)session.load(Student.class, 2);
       System.out.println(st.getsName());
       System.out.println(st1.getsName());
       
       Address sd = (Address)session.get(Address.class,1);
       System.out.println(sd.getCity());
       Address sd1 = (Address)session.get(Address.class,2);
       System.out.println(sd1.getStreet());
       
   
        
        session.close();
        
        System.out.println("Done..");
        
        
    }
}
