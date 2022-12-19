package com.vigp.demo.service;

import java.util.List;

import com.vigp.demo.model.FeeReceipt;
import com.vigp.demo.model.StudentFee;

public interface StudentFeeService {
	List<StudentFee> getStudentFeeReceipts();
	
	StudentFee saveStudentFee(StudentFee student);
	
	FeeReceipt getStudentReceiptById(Long id,Long studentid);
	
	void deleteStudentFeeById(Long id);
}
