package com.hb04.uni_ManyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch05 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        // Student05 student = session.get(Student05.class,1001);
        // System.out.println(student.getUniversity());
        // System.out.println("----------------------"+ student);



     //  !! TASK : 1 id li universiteye giden butun ogrencileri bulalim

        String hql = "from Student05 s where s.university.id =1";
        List<Student05> allStudent = session.createQuery(hql, Student05.class).getResultList();
        for (Student05 student1 : allStudent) {
            System.out.println(student1);
        }

        allStudent.forEach(System.out::println); //method reference
//
//        String hql1 = "SELECT s FROM Student05 s LEFT JOIN FETCH s.university u";
//        List<Student05> allStudents = session.createQuery(hql1, Student05.class).getResultList();
//        for (Student05 student : allStudents) {
//            System.out.println(student);
//        }
//


        tx.commit();


        sf.close();
        session.close();

    }
}
