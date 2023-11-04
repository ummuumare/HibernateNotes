package com.hb05.bi_onetomany;

import com.hb05.uni_onetomany.Book06;
import com.hb05.uni_onetomany.Student06;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave07 {
    public static void main(String[] args) {
        Student07 student = new Student07();
        student.setName("Ummu Umare");
        student.setId(1001);
        student.setGrade(99);

        Student07 student1 = new Student07();
        student1.setGrade(90);
        student1.setId(1002);
        student1.setName("Cihan ");

        Student07 student2 = new Student07();
        student2.setName("Esma");
        student2.setId(1003);
        student2.setGrade(54);

        Book07 book = new Book07();
        book.setId(1);
        book.setName("Sefiller");

        Book07 book1 = new Book07();
        book1.setId(11);
        book1.setName("Kimyaci");

        Book07 book2 = new Book07();
        book2.setId(15);
        book2.setName("ada");

        Book07 book3 = new Book07();
        book3.setId(115);
        book3.setName("masum");

        Book07 book4 = new Book07();
        book4.setId(915);
        book4.setName("ada");

       //setleme isleme ----> book uzerinden student setlenir.

        book.setStudent(student);
        book1.setStudent(student1);
        book3.setStudent(student2);
        book4.setStudent(student1);
        book2.setStudent(student2);


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).
                addAnnotatedClass(Book07.class);


        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student);


//        session.save(book);
//        session.save(book1);
//        session.save(book2);
//        session.save(book3);
//        session.save(book4);



        tx.commit();


        session.close();
        sf.close();



    }
}
