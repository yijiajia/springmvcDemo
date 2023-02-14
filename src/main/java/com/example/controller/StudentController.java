package com.example.controller;

import com.example.model.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping(value = "/converter")
    public String getStudentInfo(Student student) {
        System.out.println(student);
        return "success：" + student;
    }

   @RequestMapping("/test")
   @ResponseBody
    public String test() {
        return "student/test";
   }

   @RequestMapping("/get/{id}")
    public String getStudentInfoById(@PathVariable int id) {
        return service.getStudentById(id).toString();
   }
}
