package com.leanStream;

import java.util.*;
public class Student {
    int id;
    String name;
    String dept;

    int rank;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", rank=" + rank +
                ", birthdate=" + birthdate +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", contact=" + contact +
                '}';
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public Student(int id, String name, String dept, int rank, Date birthdate, String gender, int age, List<String> contact) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.rank = rank;
        this.birthdate = birthdate;
        this.gender = gender;
        this.age = age;
        this.contact = contact;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    Date birthdate;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    String gender;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(int id, String name, String dept, int rank, String gender, int age, List<String> contact) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.rank = rank;
        this.gender = gender;
        this.age = age;
        this.contact = contact;
    }

    int age;
    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }


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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public List<String> getContact() {
        return contact;
    }

    public void setContact(List<String> contact) {
        this.contact = contact;
    }

    List<String>contact;


}
