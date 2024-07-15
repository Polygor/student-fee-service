package com.rakbank.studentfee.repository;

import com.rakbank.studentfee.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
