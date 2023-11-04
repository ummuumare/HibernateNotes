package com.hb03.uni_direction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Diary.class).addAnnotatedClass(Student03.class);

        SessionFactory sf = con.buildSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();


        // !!! herhangi bir stydent i fetch edelim id ile

        Student03 student = s.get(Student03.class, 1001);

        // !!! diary fetch ediyourzz

        Diary diary = s.get(Diary.class, 101);

        System.out.println("====================" +student);
        System.out.println("------------------------------------");
        System.out.println("===================" + diary);
        System.out.println("---------------------");
        System.out.println(diary.getStudent());














        tx.commit();
        sf.close();
        s.close();

    }
}
