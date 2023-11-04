package com.hb05.uni_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class RunnerFetch06 {
    public static void main(String[] args) {


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student06.class).
                addAnnotatedClass(Book06.class);


        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student06 student = session.get(Student06.class, 1001);
        System.out.println(student);

// !!! TASK : HQL ile id si 101 olan kitabi getirelim.
//        String hql = "from Book06 b where b.id =11";
//        Book06 book = session.createQuery(hql, Book06.class).uniqueResult();
//        System.out.println(book);

//
//        Book06 book1 = session.get(Book06.class, 101);
//        System.out.println(book1);

        // !!! TASK: 1001 id li ogrencilerin kitaplarini getirelim (HQL)
        String hql2 = "select b.id, b.name from Student06 s inner join s.bookList where s.id = 1001";
        List<Object[]> result1 = session.createQuery(hql2).getResultList();
        result1.forEach(t -> {
            System.out.println(Arrays.toString(t));
        });

        //yukaridaki Taski get methodu ile yazalim
        Student06 student2 = session.get(Student06.class, 1003);
        student2.getBookList().forEach(System.out::println);
        tx.commit();


        session.close();
        sf.close();


    }
}
