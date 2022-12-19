package com.vigp.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.vigp.demo.TestHelper;
import com.vigp.demo.dao.StudentFeeRepository;
import com.vigp.demo.model.FeeReceipt;
import com.vigp.demo.model.Student;
import com.vigp.demo.model.StudentFee;

@ExtendWith(MockitoExtension.class)
class StudentFeeServiceImplTest extends TestHelper{

	@InjectMocks
	private StudentFeeServiceImpl studentFeeService;
	
	@Mock
	private StudentFeeRepository studentFeeRepository;
	
	@Mock
	private RestTemplate restTemplate;
	
	@Test
	void testSaveSuccess() {
		when(studentFeeRepository.save(sf1)).thenReturn(sf1);
		when(restTemplate.getForObject("http://localhost:8080/v1/student/{id}", Student.class, Map.of("id", sf1.getStudentId()))).thenReturn(s1);
		StudentFee studentFee = studentFeeService.saveStudentFee(sf1);
		assertThat(studentFee.equals(sf1));
	}
	
	@Test
	void testSaveFail() {
		when(restTemplate.getForObject("http://localhost:8080/v1/student/{id}", Student.class, Map.of("id", sf1.getStudentId())))
		.thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));
		
		HttpClientErrorException thrown = Assertions
				.assertThrows(HttpClientErrorException.class, () -> {
					studentFeeService.saveStudentFee(sf1);
				});
	
		Assertions.assertEquals("NOT_FOUND", thrown.getStatusText());
	
	}
	
	@Test
	void testgetStudentReceiptByIdSuccess() {
		when(studentFeeRepository.findById(sf1.getId())).thenReturn(sfo1);
		when(restTemplate.getForObject("http://localhost:8080/v1/student/{id}", Student.class, Map.of("id", sf1.getStudentId()))).thenReturn(s1);
		FeeReceipt feeReceipt = studentFeeService.getStudentReceiptById(sf1.getId(), sf1.getStudentId());
		assertThat(feeReceipt.getId() == sf1.getId());
		assertThat(feeReceipt.getStudentId() == sf1.getStudentId());
	}
	
	@Test
	void testgetStudentReceiptByIdFail() {
		when(studentFeeRepository.findById(sf1.getId())).thenReturn(sfo1);
		when(restTemplate.getForObject("http://localhost:8080/v1/student/{id}", Student.class, Map.of("id", sf1.getStudentId())))
		.thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));
		
		HttpClientErrorException thrown = Assertions
				.assertThrows(HttpClientErrorException.class, () -> {
					studentFeeService.getStudentReceiptById(sf1.getId(), sf1.getStudentId());
				});
	
		Assertions.assertEquals("NOT_FOUND", thrown.getStatusText());
		
	}

}
