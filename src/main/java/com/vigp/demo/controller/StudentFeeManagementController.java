package com.vigp.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vigp.demo.model.FeeReceipt;
import com.vigp.demo.model.StudentFee;
import com.vigp.demo.service.StudentFeeService;

@RestController
public class StudentFeeManagementController {

	@Autowired
	private StudentFeeService studentFeeService;

	
	@GetMapping("/v1/students/receipts")
	public List<StudentFee> listStudentReceipts() {
		return studentFeeService.getStudentFeeReceipts();
	}
	
	@GetMapping("v1/student/{studentId}/receipt/{id}")  
	private FeeReceipt getStudentFeeReceipt(@PathVariable("id") long id,@PathVariable("studentId") long studentId)   
	{  
	return studentFeeService.getStudentReceiptById(id,studentId);  
	}  
	
	@PostMapping("/v1/student/fee")  
	private long saveStudentFee(@RequestBody StudentFee student)   
	{  
	studentFeeService.saveStudentFee(student);  
	return student.getId(); 
	}  
	
	@DeleteMapping("/v1/student/{id}")  
	private void deleteStudentFeeRec(@PathVariable("id") long id)   
	{  
	studentFeeService.deleteStudentFeeById(id); 
	}  
	
}
