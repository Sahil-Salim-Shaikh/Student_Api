package com.StudentAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.StudentAPI.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
