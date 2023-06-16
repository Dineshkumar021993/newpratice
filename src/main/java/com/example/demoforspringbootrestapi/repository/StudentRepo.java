package com.example.demoforspringbootrestapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoforspringbootrestapi.entity.student;

public interface StudentRepo extends JpaRepository<student, Long>{
	

}
