package com.hibernate.HibernateCacheDemo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
        Student data;
        
        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
			
        SessionFactory sessionfactory = config.buildSessionFactory(reg);
        Session session = sessionfactory.openSession();
       
        session.beginTransaction();
        
        Query q1 = session.createQuery("from Student where rollno = 1");
        q1.setCacheable(true);
        data = (Student)q1.uniqueResult();
        System.out.println(data);
       
        session.getTransaction().commit();
        session.close();
        
        Session session1 = sessionfactory.openSession();
        
        session1.beginTransaction();
        
        Query q2 = session1.createQuery("from Student where rollno = 1");
       q2.setCacheable(true);
        data = (Student)q2.uniqueResult();
        
        System.out.println(data);
       
        session1.getTransaction().commit();
        session1.close();
    }
}
