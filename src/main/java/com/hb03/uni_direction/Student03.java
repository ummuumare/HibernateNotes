package com.hb03.uni_direction;

import javax.persistence.*;

@Entity
@Table (name = "t_student03")
public class Student03 {


    @Id
    private int id;

    @Column(name = "std_name")
    private  String name;


   // @Transient
    private int grade;

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
        return "Student03{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grsde=" + grade +
                '}';
    }
}
