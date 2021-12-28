package com.shantesh.studentService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shantesh.studentService.domain.Student;
import com.shantesh.studentService.domain.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepo;
	

	@Override
	public Student saveStudent(Student student) {
		studentRepo.save(student);
		return student;
	}

	@Override
	public List<Student> getStudents() {
		return (List<Student>) studentRepo.findAll();
	}

	@Override
	public Student getStudent(Long id) {
		return studentRepo.findById(id).get();
	}

	@Override
	public Student deleteStudent(Long id) {
		Student st = studentRepo.findById(id).get();
		studentRepo.delete(st);
		return st;
	}

	@Override
	public Student updateStudent(Long id, Student student) {
		studentRepo.save(student);
		Student st = studentRepo.findById(id).get();
		return st;
	}}
