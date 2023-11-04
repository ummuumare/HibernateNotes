package com.hb09.caching;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
/*
    1)	First Level Cache --->
                * defaultta açık geliyor , kapatma durumu yok
                * Aynı session içinde kayıt alır
                * session kapanınca içindekiler silinir

    2) Second Level Cache --->
                * Defaultta kapalıdır
                * Session factory seviyesinde cachleme yapar, yani farklı
                        sessionlar arasında data kullanılabiliyor
                * hibernate.cfg.xml den active edilebilir

    3) Query Cache
                * Query ler için kullanılıyor
                * hibernate.cfg.xml den active edilebilir

 */
@Entity
@Cacheable  //second level cache ile cachelendi
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE,region = "Student11")
public class Student11 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "std_name", nullable = false)
    private String name;

    private int mathGrade;

    //!!! GETTER SETTER


    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(int mathGrade) {
        this.mathGrade = mathGrade;
    }

    @Override
    public String toString() {
        return "Student11{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mathGrade=" + mathGrade +
                '}';
    }
}
