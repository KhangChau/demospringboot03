package com.cybersoft.demospringboot03.entity;

import java.util.List;

public class StudentList {
    private List<Student> list;
    public void add(Student student){
        this.list.add(student);
    }
}
