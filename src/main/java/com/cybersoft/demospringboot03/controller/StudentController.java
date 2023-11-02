package com.cybersoft.demospringboot03.controller;

import com.cybersoft.demospringboot03.entity.Student;
import com.cybersoft.demospringboot03.entity.StudentList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    List<Student> list = new ArrayList<Student>();
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestParam String name, @RequestParam int age){
        Student student = new Student();
        student.setName(name);
        student.setAge(age);

        list.add(student);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/{name}/{age}")
    public ResponseEntity<?> addV2(@PathVariable String name, @PathVariable int age) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);

        list.add(student);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/addV3")
    public  ResponseEntity<?> addV3(@RequestBody Student student) {
        list.add(student);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
