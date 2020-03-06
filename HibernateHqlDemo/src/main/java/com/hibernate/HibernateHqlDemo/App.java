package com.hibernate.HibernateHqlDemo;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
       Student student = new Student();
       Random random = new Random();
       
       Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);
       SessionFactory sessionfactory = config.buildSessionFactory();
       Session session = sessionfactory.openSession();
       Transaction tx = session.beginTransaction();

       Query q1 = session.createQuery("select rollno,name,marks from Student where marks>50");
       
       List<Object[]> student1= (List<Object[]>) q1.list(); 
      // Student student1 = (Student) q1.uniqueResult();
       //List<Student> list= q1.list();
       
      /* for(Student s:list)
       {
    	   System.out.println(s);
       }*/
       for(Object[] student2 : student1)
      System.out.println(student2[0] + " : " + student2[1] + " : " + student2[2]);
      tx.commit();
    }
}
