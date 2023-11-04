package com.hb09.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave11 {
    public static void main(String[] args) {
        Student11 student1 = new Student11();

        student1.setMathGrade(80);
        student1.setName("ayse");

        Student11 student2 = new Student11();

        student2.setMathGrade(60);
        student2.setName("esma");

        Student11 student3 = new Student11();

        student3.setMathGrade(90);
        student3.setName("elif");

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student11.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        session.save(student3);
        session.save(student2);
        session.save(student1);








        tx.commit();

        session.close();
        sf.close();
    }
}
