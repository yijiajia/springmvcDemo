package com.example.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Student implements Serializable {

    private int sid;

    private String name;

    private int age;

    private LocalDate createTime;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", createTime=" + createTime +
                '}';
    }

    public Student() {
    }

    public Student(int sid, String name, int age, LocalDate createTime) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.createTime = createTime;
    }
}
