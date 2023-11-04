package com.hb08;

import javax.persistence.*;

@Entity
public class Student10 {

   // hibernate de id uretme,setleme vazifesi veriyoruz
     /*
       Oracle DB - PostgreSQL ---> Sequence ( kontrolü developera bırakır, Id üretilirken
                başlangıç değeri veya kaç tane id cachelenecek bu gibi bilgileri developer setliyebilir)
       MySQL - Microsoft SQL   ---> IDENTITY ( kontrol DB de , kendi yapısına göre ıd oluşturur,
                içlerindeki en basitidir)

       GenerationType.AUTO ---> Hibernate otomatik olarak kullanilan DB ye gore stratejiyi belirler
       GenerationType.TABLE ---> En yavaşı , oyüzden çok kullanılmıyor, çünkü id
                üretmek için ekstra tablo oluşturuyor
 */

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) //  hibernate de id uretme,setleme vazifesi veriyoruz
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", // @GenereatedValue nun generator parametresindeki isim
            sequenceName = "student_seq", // DB de olusacak olab sequence ismi
            initialValue = 1000, // id lerim 1000 ile baslasin
            allocationSize = 10) // cacheleme mekanizmasinda 10 adet id hazirda bekletilsin
    private int id;


    private String name;

    private int grade;

    public int getId() {
        return id;
    }

//   // public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student10{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}