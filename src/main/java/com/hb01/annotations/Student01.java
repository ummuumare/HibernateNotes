package com.hb01.annotations;

import javax.persistence.*;

@Entity // !!! @Entity koydugumuz class db de bir tabloya karsilik gelecek
@Table(name = "t_student01") // !!! olusacak olan tabonun ismini degistirdik -- opsiyoneldi
public class Student01 {
    @Id
    private int id; //entity yaptiktan sonra bir tane degisken mutlaka pk olmak zorunda

    @Column(name = "student_name", length = 100, nullable = false, unique = false) // tablodaki header customiize etmek,
    private String name; //


    // @Transient // !!! db de grade adinda bir tablonun olmasini (header) istemiyorum
    private int grade;

    //@Lob // !!! Large object ile buyuk boyutlu veriler db de tutlabiliyor
    //private byte[] image;


   // !!! GETTER-SETTER


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}