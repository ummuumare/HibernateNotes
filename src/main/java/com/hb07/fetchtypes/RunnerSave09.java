package com.hb07.fetchtypes;

import com.hb06.Book08;
import com.hb06.Student08;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave09 {
    public static void main(String[] args) {
        Student09 student = new Student09();
        student.setName("Ummu Umare");
        student.setId(1001);
        student.setGrade(99);

        Student09 student1 = new Student09();
        student1.setGrade(90);
        student1.setId(1002);
        student1.setName("Cihan ");

        Student09 student2 = new Student09();
        student2.setName("Esma");
        student2.setId(1003);
        student2.setGrade(54);

        Book09 book = new Book09();
        book.setId(1);
        book.setName("Sefiller");

        Book09 book1 = new Book09();
        book1.setId(11);
        book1.setName("Kimyaci");

        Book09 book2 = new Book09();
        book2.setId(17);
        book2.setName("ada");

        Book09 book3 = new Book09();
        book3.setId(119);
        book3.setName("kurt mantolu madonna");

        Book09 book4 = new Book09();
        book4.setId(102);
        book4.setName("islam");


        // setleme islemini mappedby student in oldugu yerde yapilacak diyor,
        // Student ise Book clasinda oldugu icin setleme book clasindan yapilir

//Not2 : Setleme islemleri : CascadeTypr kullanildiginda tablollarin duzgun bir sekilde olusmasi icib iliskiyi iki taraftanda setlememiz gerekiyor
//student lar uzeirden setleme islemi
        student.getBookList().add(book1);
        student.getBookList().add(book2);

        student1.getBookList().add(book3);
        student1.getBookList().add(book4);

        student2.getBookList().add(book);

//booklar uzerinden setleme islemi
        book1.setStudent(student1);
        book.setStudent(student1);

        book2.setStudent(student);
        book3.setStudent(student);

        book4.setStudent(student2);


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student09.class).
                addAnnotatedClass(Book09.class);


        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student);
        session.save(student2);


        tx.commit();

        session.close();
        sf.close();


    }
}
