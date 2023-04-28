package com.Classroom.ClassroomApp.entity;
import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name, lastName, grade;
    private int year , age;
    //
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "teacher")
    private Teacher teacher;
//

    public Student(long id, String name, String lastName, String grade, int year, int age, Teacher teacher) {

        this.name = name;
        this.lastName = lastName;
        this.grade = grade;
        this.year = year;
        this.age = age;
        this.teacher = teacher;
    }

    public Student(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}