package com.vn.nev.SpringMvcDemo.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vn.nev.SpringMvcDemo.model.Student;
import com.vn.nev.SpringMvcDemo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private static List<Student> students = Arrays.asList(
			// 1
			new Student(1, "Student 1", 4.5,0),
			// 2
			new Student(2, "Student 2", 3.5,0),
			// 3
			new Student(3, "Student 3", 2.5,0),
			// 4
			new Student(4, "Student 4", 1.5,0),
			// 5
			new Student(5, "Student 5", 4.5,0),
			// 6
			new Student(6, "Student 6", 3.5,0)).stream().map(s -> s).collect(Collectors.toList());

	@Override
	public List<Student> getAll() {
		return students;
	}

	@Override
	public Student getById(int id) {
		return students.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
	}

	@Override
	public Student add(Student newStudent) {
		students.add(newStudent);
		return newStudent;
	}

	@Override
	public int removeById(int id) {
		// TODO Auto-generated method stub
		int oldSize = students.size();
		for(int index=0;index<oldSize;index++){
			if(students.get(index).getId()==id){
				students.remove(index);
				break;
			}
		}
		int newSize = students.size();
		return oldSize - newSize;
	}
	
	@Override
	public void editById(Student student) {
		for(Student s:students){
			if(s.getId()==student.getId()){
				s.setGpa(student.getGpa());
				s.setName(student.getName());
				break;
			}
		}
	}

	@Override
	public List<Student> getAllOrderByName(int Asc) {
		return students.stream().sorted((s1,s2)->{
			return Asc*s1.getName().compareTo(s2.getName());
		}).collect(Collectors.toList());
	}

	@Override
	public List<Student> getAllOrderByGpa(int Asc) {
		return students.stream().sorted((s1,s2)->{
//			return s1.getGpa() - s2.getGpa();
			if(s1.getGpa()>s2.getGpa())
				return 1*Asc;
			else if(s1.getGpa()<s2.getGpa())
				return -1*Asc;
			return 0;
		}).collect(Collectors.toList());
	}

	public int genID(){
		return students.get(students.size()-1).getId()+1;
	}

	@Override
	public List<Student> get(int fromIndex, int toIndex) {
		return students.subList(fromIndex, toIndex);
	}

}
