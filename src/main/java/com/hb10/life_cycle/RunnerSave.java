package com.hb10.life_cycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("Esin");
        employee.setSalary(10000.3);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("------------->session.save() cagrildi");

        session.save(employee);



        tx.commit();

        sf.close();
        session.close();


    }
}
