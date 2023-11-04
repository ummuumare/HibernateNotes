package com.hb02.embeddable;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {
    public static void main(String[] args) {
        Student02 student02 = new Student02();

        student02.setId(1001);
        student02.setName("Ummu Umare");
        student02.setGrade(90);

        Address address1 = new Address();


        address1.setCity("Aydin");
        address1.setCountry("Turkey");
        address1.setStreet("Zafer Mah");
        address1.setZipCode("1r002");

        student02.setAddress(address1);


        Address address2 = new Address();

        address2.setCity("Agri");
        address2.setCountry("Turkey");
        address2.setStreet("Alma Mah");
        address2.setZipCode("34002");

        Student02 student01 = new Student02();

        student01.setId(1002);
        student01.setName("mirac Uslu");
        student01.setGrade(30);
        student01.setAddress(address2);


        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").addAnnotatedClass(Student02.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student02);
        session.save(student01);



        tx.commit();


        session.close();
        sf.close();
    }
}
