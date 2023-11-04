package com.hb05.uni_onetomany;

import com.hb04.uni_ManyToOne.Student05;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave06 {
    public static void main(String[] args) {
        Student06 student = new Student06();
        student.setName("Ummu Umare");
        student.setId(1001);
        student.setGrade(99);

        Student06 student1 = new Student06();
        student1.setGrade(90);
        student1.setId(1002);
        student1.setName("Cihan ");

        Student06 student2 = new Student06();
        student2.setName("Esma");
        student2.setId(1003);
        student2.setGrade(54);

        Book06 book = new Book06();
        book.setId(1);
        book.setName("Sefiller");

        Book06 book1 = new Book06();
        book1.setId(11);
        book1.setName("Kimyaci");

        Book06 book2 = new Book06();
        book2.setId(15);
        book2.setName("ada");



        //setleme islemi student uzerinden olacak

        student1.getBookList().add(book);
        student.getBookList().add(book1);
        student2.getBookList().add(book2);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student06.class).
                addAnnotatedClass(Book06.class);


        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        session.save(book);
        session.save(book1);
        session.save(book2);

        session.save(student1);
        session.save(student2);
        session.save(student);



        tx.commit();


        session.close();
        sf.close();

    }
}
