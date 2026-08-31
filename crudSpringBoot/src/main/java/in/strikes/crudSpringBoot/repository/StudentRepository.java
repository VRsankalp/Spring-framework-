package in.strikes.crudSpringBoot.repository;

import in.strikes.crudSpringBoot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository//usse the componrnt t
// here it use the interface due to not write query on their qwn
public interface StudentRepository extends JpaRepository<Student, Long> {



}
