package com.cybersoft.demospringboot03.controller;

import com.cybersoft.demospringboot03.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student2")
public class studentController2 {
    List<Student> list = new ArrayList<Student>();

    @GetMapping("")
    public String foo(){
        return "hello student 2";
    }

    @PostMapping("/add")
    public List<Student> addFunc(@RequestParam String name, @RequestParam int age){
        Student stu = new Student();
        stu.setAge(age);
        stu.setName(name);
        list.add(stu);
        return list;
    }

    @PostMapping("/addV2/{name}/{age}")
    public ResponseEntity<?> addFuncV2(@PathVariable String name, @PathVariable int age){
        Student stu = new Student();
        stu.setAge(age);
        stu.setName(name);
        list.add(stu);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/addV3")
    public ResponseEntity<?> addV3Func(@RequestBody Student stu) {
        list.add(stu);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
