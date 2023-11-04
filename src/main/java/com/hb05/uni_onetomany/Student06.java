package com.hb05.uni_onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_student06")
public class Student06 {
    @Id
    private int id;

    @Column(name = "std_name")
    private String name;
    private int grade;
    @OneToMany

    // FK burada olsun istesekte, hibernate buna musaade etmiyor en performansl cozumu yani book06 clasinda fk kolonu olusturuyor
    //eger hic bir tarafta joincolumn yazmassak, o zaman hibernate iliskileri takip etmke icin 3. bir tablo olusturur.

    @JoinColumn
    private List<Book06> bookList = new ArrayList<>();


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

    public List<Book06> getBookList() {
        return bookList;
    }

//    public void setBookList(List<Book06> bookList) {
//        this.bookList = bookList;
//    }

    @Override
    public String toString() {
        return "Student06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", bookList=" + bookList +
                '}';
    }
}
