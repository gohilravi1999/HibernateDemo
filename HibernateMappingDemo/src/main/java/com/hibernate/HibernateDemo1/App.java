package com.hibernate.HibernateDemo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        Student student = new Student();
        Laptop laptop = new Laptop();
        
        student.setMarks(50);
        student.setName("Virat");
        student.setRollno(1);
       
        laptop.setLid(101);
        laptop.setLname("Lenovo");
        
        student.getLaptop().add(laptop);
        laptop.getStudent().add(student);
        
        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        SessionFactory sessionfactory = config.buildSessionFactory();
        Session session = sessionfactory.openSession();
       
        Transaction tr = session.beginTransaction();
        session.save(student);
        session.save(laptop);
        
        tr.commit();
    }
}
