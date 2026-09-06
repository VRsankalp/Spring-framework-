package com.example.filterDemo.service;

import com.example.filterDemo.Dto.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Service
public class StudentService {
    public void createStudent(Student student){
        System.out.println("createStudent");
        System.out.println("student:"+student.getName());
        System.out.println("student:"+student.getEmail());
    }



}
