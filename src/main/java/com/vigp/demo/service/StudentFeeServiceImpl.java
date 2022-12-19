package com.vigp.demo.service;

import java.time.ZoneOffset;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import com.vigp.demo.dao.StudentFeeRepository;
import com.vigp.demo.exception.CustomException;
import com.vigp.demo.model.FeeReceipt;
import com.vigp.demo.model.Student;
import com.vigp.demo.model.StudentFee;

@Service
public class StudentFeeServiceImpl implements StudentFeeService{

	Logger logger = LoggerFactory.getLogger(StudentFeeServiceImpl.class);

	@Autowired
	private StudentFeeRepository studentFeeRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<StudentFee> getStudentFeeReceipts() {
		return studentFeeRepository.findAll();
	}

	@Override
	public StudentFee saveStudentFee(StudentFee studentFee) {
		
		//to Validate Student found
		restTemplate.getForObject("http://localhost:8080/v1/student/{id}", Student.class, Map.of("id", studentFee.getStudentId()));
		
		return studentFeeRepository.save(studentFee);
	}

	@Override
	public FeeReceipt getStudentReceiptById(Long id,Long studentid) {
		StudentFee std = studentFeeRepository.findById(id).get();
		if(ObjectUtils.isEmpty(std)) {
			logger.debug("Receipt Not found!");
			throw new CustomException(HttpStatus.NOT_FOUND,"Receipt not found.");
		}
			
		Student student = restTemplate.getForObject("http://localhost:8080/v1/student/{id}", Student.class, Map.of("id", std.getStudentId()));
		
		FeeReceipt fReceipt = new FeeReceipt();
		fReceipt.setCardNo(std.getCardNo());
		fReceipt.setCardType(std.getCardType());
		fReceipt.setGradeId(std.getGradeId());
		fReceipt.setCreateDate(std.getCreateDate().toInstant(ZoneOffset.UTC));
		fReceipt.setFeeAmt(std.getFeeAmt());
		fReceipt.setStudentId(std.getStudentId());
		fReceipt.setStudentName(student.getName());
		
		return fReceipt;
	}

	//In case to student delete, will delete all fee receipt related to the student, later enhancement
	@Override
	public void deleteStudentFeeById(Long id) {
		studentFeeRepository.deleteById(id);	
	}

}
