package com.shantesh.studentService.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shantesh.studentService.domain.Student;
import com.shantesh.studentService.service.StudentService;

@RestController
@RequestMapping(value = "/v1")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping(value = "/students")
	public List<Student> getAllStudents() {
		return studentService.getStudents();
	}


	@GetMapping(value = "/student/{id}")
	public Student getStudent(@PathVariable Long id) {
		return studentService.getStudent(id);
//		suso
	}

	@PostMapping(value = "/student")
	public Student createStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
		
	}

	
	@DeleteMapping(value = "/student/{id}")
	public Student deleteStudent(@PathVariable Long id) {
		return studentService.deleteStudent(id);
	}
	
	@PutMapping(value = "/student/{id}")
	public Student updateStudent(@RequestBody Student student,@PathVariable Long id) {
		Student st = studentService.getStudent(id);
//		BeanUtils.copyProperties(student, st);hh
		st.setAddressLine1("Something New changed changed");
		return studentService.saveStudent(st);
	}

}
