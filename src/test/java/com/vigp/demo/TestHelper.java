package com.vigp.demo;

import java.util.Optional;

import com.vigp.demo.model.Student;
import com.vigp.demo.model.StudentFee;

public class TestHelper {

	public static final Student s1 = new Student() ;
	public static final Student s1NullSchoolName = new Student() ;
	public static final Student s1NullMobNo = new Student() ;
	
	public static final StudentFee sf1 = new StudentFee() ;
	
	static {
	s1.setGradeId(1);
	s1.setId(1);
	s1.setMobileNo("123123");
	s1.setName("testStudent");
	s1.setSchoolName("testSchool");
	
	s1NullSchoolName.setGradeId(1);
	s1NullSchoolName.setId(1);
	s1NullSchoolName.setMobileNo("123123");
	s1NullSchoolName.setName("testStudent");
	
	s1NullMobNo.setGradeId(1);
	s1NullMobNo.setId(1);
	s1NullMobNo.setName("testStudent");
	s1NullMobNo.setSchoolName("testSchool");
	
	sf1.setCardNo("12341234");
	sf1.setCardType("Master");
	sf1.setFeeAmt(10.25);
	sf1.setGradeId(1);
	sf1.setId(1);
	sf1.setStudentId(1); 
	
	}
	
	public static final Optional<Student> s2 = Optional.of(s1);
	public static final Optional<Student> s1NullSchoolNameOpt = Optional.of(s1NullSchoolName);
	public static final Optional<Student> s1NullMobNoOpt = Optional.of(s1NullMobNo);
	
	public static final Optional<StudentFee> sfo1 = Optional.of(sf1);
	
}
