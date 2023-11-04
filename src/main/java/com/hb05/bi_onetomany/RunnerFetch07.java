package com.hb05.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch07 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).
                addAnnotatedClass(Book07.class);


        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

//        Student07 student = session.get(Student07.class, 1001);
//        // student.getBook07List().forEach(System.out::println);
//        System.out.println(student);


        //TASK : SQL ile
//        //DB de kitaplari olan ogrenci isimleri ve kitaplari getirelim
//        String sql = "select s.student_name, b.name from t_student07 s inner join book07 b on s.id = b.student_id ";
//        List<Object[]> sql1 = session.createSQLQuery(sql).getResultList();
//        for (Object[] result : sql1) {
//            System.out.println(Arrays.toString(result));
//        }
////Yukaridaki Raski HQL ile yazdigimizdaa
//        String hql = "select s.name, b.name from Student07 s inner join fetch Book07 b on s.id = b.student.id";
//        List<Object[]> hql1 = session.createQuery(hql).getResultList();
//        for (Object[] result1 : hql1) {
//            System.out.println(Arrays.toString(result1));
//        }
//

        //Not : DELETE islemi (HQL)

        String hqlDelete = "delete from Book07";
        int numberOfRecord = session.createQuery(hqlDelete).executeUpdate();
        System.out.println("Etkilenen veri sayisi = " + numberOfRecord);


        String hqlDelete1 = "delete from Student07";
        int numberOfRecord1 = session.createQuery(hqlDelete1).executeUpdate();
        System.out.println("Etkilenen veri sayisi = " + numberOfRecord1);

        // !!! TASK : Kitabi olan bir ogrenciyi silmek istiyorum
        //1001 id li student nesnesini silelim.

//        Student07 student1 = session.get(Student07.class, 1001);
//session.delete(student1);

       // String delete = "delete from Student07 s where s.id =1001;";


        tx.commit();


        session.close();
        sf.close();


    }
}
