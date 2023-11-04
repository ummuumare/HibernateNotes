package com.hb07.fetchtypes;

import com.hb06.Book08;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student09.class).
                addAnnotatedClass(Book09.class);


        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Student09 student = session.get(Student09.class, 1002); // burasi lazy olarak calsiir cunku studet kismin onetomany
     //   System.out.println(student);


      //  Book09 book = session.get(Book09.class,17); // bu eager olarak calisir cunku book kisminda manytoone var


//        for (Book09 books : student.getBookList()){ // lazy ile geliyor
//            System.out.println(books);
//        }
        tx.commit();

        session.close();

        for (Book09 books : student.getBookList()){
            System.out.println(books);
        }
//Not : sessiion kapandigi icin lazy oldugu zaman veriler gelmez ve hata mesaji atar ama eager cevirirsek, session kapanmis olsa bile verileri bir kerede getirir




        sf.close();

    }
}
