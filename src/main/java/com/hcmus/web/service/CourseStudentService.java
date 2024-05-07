package com.hcmus.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcmus.web.Model.Course_Student;
import com.hcmus.web.Model.Student;
import com.hcmus.web.Repository.CourseStudentRepository;
import com.hcmus.web.Repository.StudentRepository;

@Service
public class CourseStudentService implements IService<Course_Student> {

	@Autowired
	private CourseStudentRepository CourseStudentRepo;
	
	
	@Autowired
	private StudentRepository stRepo;

	@Override
	public Course_Student add(Course_Student t) {
		return CourseStudentRepo.save(t);
	}

	@Override
	public Course_Student update(Course_Student t) {
		return CourseStudentRepo.save(t);
	}

	@Override
	public void delete(Course_Student t) {
		CourseStudentRepo.delete(t);
	}

	@Override
	public List<Course_Student> getAll() {
		return CourseStudentRepo.findAll();
	}

	@Override
	public Course_Student getById(int id) {
		return CourseStudentRepo.findById(id).get();
	}
	
	public void deleteByStudentId(Integer id)
	{
		CourseStudentRepo.deleteByStudentId(id);
	}
	public void deleteByCourseId(Integer id)
	{
		CourseStudentRepo.deleteByCourseId(id);
	}	
	
	public List<Student> getStudentFromCourse(Integer id)
	{
		return stRepo.getStudentEnroll(id);
	}
	
	public void removeStudentFromCourse(Integer idCourse, Integer idStudent)
	{
		CourseStudentRepo.deleteStudentCourse(idCourse, idStudent);
	}

	public List<Student> listStudentsNotInCourse(Integer id)
	{
		return stRepo.getStudentsNotInCourse(id);
	}
	
	public void updatePointStudent(Integer id, Double point)
	{
		Course_Student cs = CourseStudentRepo.findById(id).get();
		if(cs != null)
		{
		   cs.setGrade(point);
		   CourseStudentRepo.save(cs);
		}
	}
	
}
