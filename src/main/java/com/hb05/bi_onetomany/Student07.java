package com.hb05.bi_onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_student07")
public class Student07 {
    @Id
    private int id;
    @Column(name = "student_name")
    private String name;

    private int grade;
    @OneToMany(mappedBy = "student", orphanRemoval = true, cascade = CascadeType.PERSIST)
    // !!! Trick : Cascade.Remove ve OrphanRemovel arasindaki fark : CascadeType.REMOVE varsa,Eger parent(Student) nesne silinirse,
    // chilld/dependent(Book) nesnesi de silinir.
    // Ancak bu secenek, child nesneye null degeri atarsak veya baska bir child nesne ile degistirirsek devreye girmez.
    // OrphanRemoval nulla cektiginiz child nesnesini de siler


    private List<Book07> book07List = new ArrayList<>();


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

    public List<Book07> getBook07List() {
        return book07List;
    }

//    public void setBook07List(List<Book07> book07List) {
//        this.book07List = book07List;
//    }


    @Override
    public String toString() {
        return "Student07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
