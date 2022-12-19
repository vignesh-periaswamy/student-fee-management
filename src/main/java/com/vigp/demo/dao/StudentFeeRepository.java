package com.vigp.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vigp.demo.model.StudentFee;

public interface StudentFeeRepository extends JpaRepository<StudentFee, Long>{

	StudentFee findByIdAndStudentId(long id,long studentId);
}
