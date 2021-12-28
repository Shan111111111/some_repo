package com.shantesh.studentService.service;

import java.util.List;

import com.shantesh.studentService.domain.Student;

public interface StudentService {
	
	
	public Student saveStudent(Student student) ;
	public List<Student> getStudents() ;
	public Student getStudent(Long id) ;
	public Student deleteStudent(Long id) ;
	public Student updateStudent(Long id, Student student) ;

}
