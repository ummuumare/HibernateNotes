package com.hb10.life_cycle_2;

import com.hb10.life_cycle.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave12 {
    public static void main(String[] args) {
        Student12 student = new Student12();
        student.setName("Edis");
        student.setGrade(43);//  transient donemi


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        session.save(student); // !!! persisted or managed asamasinda bir session uzerinde kalici hale gelmeye baslamistir

        student.setName("Updated in persisted statee");

        session.evict(student); // detach state olur evict oncesinde yapmis old islemler kalici hale gelmis olmmaz(UYKU hali)
        student.setName("Updated in detach");

        session.update(student); //uyku modundan detach den persistent state e alindi
        session.merge(student);
        tx.commit();
        sf.close();
        session.close();

    }
}