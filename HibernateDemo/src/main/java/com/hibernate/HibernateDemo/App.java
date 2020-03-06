package com.hibernate.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Name name = new Name();
    	name.setFirst1Name("Virat");
    	name.setFirst2Name("chiku");
    	
       Student student = new Student();
       
       student.setId(101);
       student.setLastName("kohli");
       student.setFirstName(name);
       
       Configuration config  =new Configuration().configure().addAnnotatedClass(Student.class);
       SessionFactory sessionfactory = config.buildSessionFactory();
       Session session = sessionfactory.openSession();
       
       Transaction tx = session.beginTransaction();
       
      session.save(student);
      tx.commit();
    
    }
}
