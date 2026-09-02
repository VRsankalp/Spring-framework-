package in.strikes.crudSpringBoot;

import in.strikes.crudSpringBoot.entity.Student;
import in.strikes.crudSpringBoot.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // CREATE
    public Student createStudent(Student studentReq) {
        return studentRepository.save(studentReq);
    }

    // GET ONE
    public Student getStudent(Long id) {
        Optional<Student> student = studentRepository.findByDeletedIsFalse(id);

        if (student.isPresent()) {
            return student.get();
        }

        return null;
    }

    // GET ALL
    public List<Student> getAllStudents() {
        return studentRepository.findByDeletedFalse();
    }

    // UPDATE
    public Student updateStudent(Long id, Student studentReq) {

        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedFalse(id);

        if (existingStudent.isEmpty()) {
            return null;
        }

        Student student = existingStudent.get();

        student.setName(studentReq.getName());
        student.setAge(studentReq.getAge());
        student.setEmail(studentReq.getEmail());
        student.setRollNo(studentReq.getRollNo());
        student.setSubject(studentReq.getSubject());
        student.setDeleted(false);

        return studentRepository.save(student);
    }

    // DELETE
    public boolean deleteStudent(Long id) {

        Optional<Student> existingStudent = studentRepository.findById(id);

        if (existingStudent.isEmpty()) {
            return false;
        }

        studentRepository.deleteById(id);
        return true;
    }
    //
    public Boolean deleteStudentSoft(Long id) {
       Optional<Student> existingStudent   =studentRepository.findByDeletedIsFalse(id);
       if (existingStudent.isEmpty()) {
            return false;
       }
       Student student = existingStudent.get();
       student.setDeleted(true);
       studentRepository.save(student);
       return true ;


    }
}