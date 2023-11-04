package com.hb03.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Diary04.class).addAnnotatedClass(Student04.class);

        SessionFactory sf = con.buildSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();


        Student04 student = s.get(Student04.class, 1001);
        Diary04 diary = s.get(Diary04.class, 101);


        System.out.println(student);
        System.out.println("-------------------------------");
        System.out.println(student.getDiary()); // !!! QUESTIONNNNN burasi bende null veriyor normal mi ????
        System.out.println("-------------------------------");
        System.out.println(diary);
        System.out.println("-----------------------------------");
        System.out.println(diary.getStudent());


        //ben sadece gunlukleri olan ogrencileri fetchleyin ?? (INNER JOIN)
        String hqlQuery1 = "SELECT s.name,d.name FROM Student04 s INNER JOIN FETCH Diary04 d ON s.id=d.student";
        // ustteki HQL in SQL hali :
        // SELECT s.std_name,d.name FROM student04 s INNER JOIN diary04 d ON s.id = d.std_id
//        List<Object[]> resultList1 = s.createQuery(hqlQuery1).getResultList();
//        for (Object[] objects: resultList1) {
//            System.out.println(Arrays.toString(objects));
//        }
//
//        resultList1.forEach(oa->{ // lambda expression
//            System.out.println(Arrays.toString(oa));
//        });


        String hql = "select s.name, d.name from Student04 s inner join fetch Diary04 d on s.id = d.student";
        List<Object[]> results = s.createQuery(hql).getResultList();
        for (Object[] objects : results) {
            System.out.println(Arrays.toString(objects));
        }

        results.forEach(t -> { //lambda exprssion
            System.out.println(Arrays.toString(t));
        });

        //SQL hali
        // String sql = " select std_name, d.name from t_student04 s  inner join diary04 d on s.id = s.std_id";


        tx.commit();


        s.close();
        sf.close();

    }
}
