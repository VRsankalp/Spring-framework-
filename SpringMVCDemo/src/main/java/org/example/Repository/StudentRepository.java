package org.example.Repository;

import org.example.entity.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepository {
    private Map<String, Student> students;
    public StudentRepository() {
        students = new HashMap<>();
    }
    public Student save(Student student) {
        students.put(student.getName(), student);
        return student;
    }
    public Student findById(String id) {
        return students.get(id);
    }
    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }
}
