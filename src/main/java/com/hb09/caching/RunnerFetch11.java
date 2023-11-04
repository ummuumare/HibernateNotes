package com.hb09.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch11 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student11.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        System.out.println("****************ilk get islemi -->  1 id li ogrenci icin ***************");

        Student11 student = session.get(Student11.class, 1L);


//session.clear();  --> cache bellek silinir

        System.out.println("****************ikinci get islemi -->  1 id li ogrenci icin ***************");

        Student11 student1 = session.get(Student11.class, 1L);

        tx.commit();
        session.close();


        Session session2 = sf.openSession();
        Transaction tx1 = session2.beginTransaction();


        System.out.println("**************** session.close sonrasi get islemi --> 1 id li ogrenci icin ************");

        Student11 student3  = session2.get(Student11.class, 1L);

        tx1.commit();

        session.close();


        Session session3 = sf.openSession();
        Transaction tx2 = session3.beginTransaction();

        System.out.println("**************** session.close sonrasi get islemi --> 1 id li ogrenci icin ************");

        Student11 student4  = session2.get(Student11.class, 1L);


        tx2.commit();
        session3.close();


        sf.close();
    }
}
