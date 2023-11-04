package com.hb06;

import com.hb05.bi_onetomany.Book07;
import com.hb05.bi_onetomany.Student07;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class RunnerSave08 {
    public static void main(String[] args) {

        Student08 student = new Student08();
        student.setName("Ummu Umare");
        student.setId(1001);
        student.setGrade(99);

        Student08 student1 = new Student08();
        student1.setGrade(90);
        student1.setId(1002);
        student1.setName("Cihan ");

        Student08 student2 = new Student08();
        student2.setName("Esma");
        student2.setId(1003);
        student2.setGrade(54);

        Book08 book = new Book08();
        book.setId(1);
        book.setName("Sefiller");

        Book08 book1 = new Book08();
        book1.setId(11);
        book1.setName("Kimyaci");


        /// !!! Creating 3 booklist
        List<Book08> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book);
        //iliskinin duzgun kurulabilmesi icin setleme islemi student uzeirnden yapilmasi gerekiyor
        student1.setBookList(bookList);

        List<Book08> bookList1 = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book);
        student.setBookList(bookList1);


        List<Book08> bookList2 = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book);
        student.setBookList(bookList2);


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student08.class).
                addAnnotatedClass(Book08.class);


        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        session.save(student2);
        session.save(student);
        session.save(student1);


        session.save(book1);
        session.save(book);

        tx.commit();

        session.close();
        sf.close();

    }
}