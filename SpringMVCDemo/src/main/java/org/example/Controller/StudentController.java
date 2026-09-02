package org.example.Controller;

import org.example.entity.Student;
import org.example.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student studentReq) {
        return ResponseEntity.ok(studentReq);
    }
    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents() {
        List<Student>studentResp = studentService.getAllStudent();
        return ResponseEntity.ok(studentResp);

    }

}
