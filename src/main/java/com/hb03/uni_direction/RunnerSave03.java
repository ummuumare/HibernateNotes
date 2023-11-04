package com.hb03.uni_direction;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {
    public static void main(String[] args) {

        Student03 student03 = new Student03();

        student03.setId(1001);
        student03.setName("Ummu Umare");
        student03.setGrade(90);

        Student03 student01 = new Student03();

        student01.setId(1002);
        student01.setName("mirac Uslu");
        student01.setGrade(30);


        Student03 student02 = new Student03();

        student02.setId(1003);
        student02.setName("Enes Uslu");
        student02.setGrade(30);


        Diary diary1 = new Diary();

        diary1.setId(101);
        diary1.setName("Mirac beyin gunlugu");
        diary1.setStudent(student01);


        Diary diary2 = new Diary();

        diary2.setId(102);
        diary2.setName("Enes beyin gunlugu");
        diary2.setStudent(student02);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Diary.class).addAnnotatedClass(Student03.class);

        SessionFactory sf = con.buildSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();


        s.save(student02);
        s.save(student01);
        s.save(student03);


        s.save(diary1);
        s.save(diary2);



        tx.commit();


        sf.close();
        s.close();


    }
}
