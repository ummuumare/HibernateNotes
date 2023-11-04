package com.hb03.bi_onetoone;

import javax.persistence.*;

@Entity
@Table(name = "t_student04")
public class Student04 {
   @Id
    private  int id;

   @Column(name = "std_name", length = 20, nullable = false)
   private String name;

   //@Transient
   private  int  grade;


   @OneToOne(mappedBy = "student") //--> eger mapped by yapmazsak o zaman default deger atilabilir hibernate iki tarafa da clumn atar iki tablo da da fk icin birer talo olur, bir adet column yeterli iki trafta da column atilmamasi icin
   // iliskinin tek taraftan yonetilmesi icin degil, iliski her turlu cift tarafi calisacak sadece bi tane fk yeterli
   //ilisinin duzgun kurulabilmesi icin, setlee  islemi Diary tarafindn ypilmasi lazim
   private Diary04 diary;

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

    public Diary04 getDiary() {
        return diary;
    }

    public void setDiary(Diary04 diary) {
        this.diary = diary;
    }

    @Override
    public String toString() {
        return "Student04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
