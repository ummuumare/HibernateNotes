package com.hb03.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {
    public static void main(String[] args) {
        Student04 student03 = new Student04();

        student03.setId(1001);
        student03.setName("Ummu Umare");
        student03.setGrade(90);

        Student04 student01 = new Student04();

        student01.setId(1002);
        student01.setName("mirac Uslu");
        student01.setGrade(30);


        Student04 student02 = new Student04();

        student02.setId(1003);
        student02.setName("Enes Uslu");
        student02.setGrade(30);


        Diary04 diary1 = new Diary04();

        diary1.setId(101);
        diary1.setName("Mirac beyin gunlugu");
        diary1.setStudent(student01); // !!! iliskinin duzgun kurulabilmesi icin diary tarafinda  student setlenmesi gerkiyor
       // student01.setDiary(diary1);


        Diary04 diary2 = new Diary04();

        diary2.setId(102);
        diary2.setName("Enes beyin gunlugu");
        diary2.setStudent(student02);// !!! iliskinin duzgun kurulabilmesi icin diary tarafinda  student setlenmesi gerkiyor
        //student02.setDiary(diary2);


        Diary04 diary3 = new Diary04();
        diary3.setId(103);
        diary3.setName("kimseye ait degil");
        diary3.setStudent(student03);


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Diary04.class).addAnnotatedClass(Student04.class);

        SessionFactory sf = con.buildSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();

        s.save(student03);
        s.save(student01);
        s.save(student02);


        s.save(diary2);
        s.save(diary1);
        s.save(diary3);


        tx.commit();
        s.close();
        sf.close();


    }
}
