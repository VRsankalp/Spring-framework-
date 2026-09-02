package in.strikes.crudSpringBoot.controller;

import in.strikes.crudSpringBoot.StudentService;
import in.strikes.crudSpringBoot.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // CREATE Student
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        student.setDeleted(false);
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    // GET Student by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student studentResp = studentService.getStudent(id);

        if (studentResp == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentResp);
    }

    // GET ALL Students
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> studentList = studentService.getAllStudents();

        if (studentList == null || studentList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentList);
    }

    // UPDATE Student
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {

        Student updatedStudent = studentService.updateStudent(id, student);

        if (updatedStudent == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedStudent);
    }

    // DELETE Student
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {

        boolean deleted = studentService.deleteStudent(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Student deleted successfully");
    }
    @PatchMapping("/delete-soft/{id}")
    public ResponseEntity<String> deleteStudentSoft( @PathVariable Long id ){
        Boolean isDeleted = studentService.deleteStudentSoft(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record Deleted ");

    }
}