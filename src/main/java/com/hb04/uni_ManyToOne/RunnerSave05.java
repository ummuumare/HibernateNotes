package com.hb04.uni_ManyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05 {
    public static void main(String[] args) {
        Student05 student = new Student05();
        student.setName("Ummu Umare");
        student.setId(1001);
        student.setGrade(99);

        Student05 student1 = new Student05();

        student1.setGrade(90);
        student1.setId(1002);
        student1.setName("Cihan ");


        Student05 student2 = new Student05();

        student2.setName("Esma");
        student2.setId(1003);
        student2.setGrade(54);

        University university = new University();

        university.setId(1);
        university.setName("Ankara");


        student1.setUniversity(university);
        student2.setUniversity(university);
        student.setUniversity(university);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(university);


        session.save(student1);
        session.save(student2);
        session.save(student);



        tx.commit();



        sf.close();
        session.close();



    }
}
