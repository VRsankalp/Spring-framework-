package in.strikes.crudSpringBoot.repository;

import in.strikes.crudSpringBoot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository//usse the componrnt t
// here it use the interface due to not write query on their qwn
public interface StudentRepository extends JpaRepository<Student, Long> {


    Optional<Student> findByIdAndDeletedFalse(Long id);


    Optional<Student> findByDeletedIsFalse(Long id );

    List<Student> findByDeletedFalse();
}
