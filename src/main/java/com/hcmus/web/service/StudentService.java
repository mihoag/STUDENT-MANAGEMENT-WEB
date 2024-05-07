package com.hcmus.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hcmus.web.Model.Student;
import com.hcmus.web.ModelSpecification.StudentSpecification;
import com.hcmus.web.Repository.CourseRepository;
import com.hcmus.web.Repository.CourseStudentRepository;
import com.hcmus.web.Repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentService implements IService<Student> {

	@Autowired
	private StudentRepository stRepo;
	@Autowired
	private CourseStudentRepository csRepo;

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		//return null;
		return stRepo.findAll();
	}
	
	public Page<Student> listAll(String keyword, int pageNum, String sortField, String sortDir)
	{
		Pageable pageable = PageRequest.of(pageNum - 1, 10, 
				sortDir.equals("asc") ? Sort.by(sortField).ascending()
									  : Sort.by(sortField).descending()
		);
		if(keyword != null && !keyword.equals(""))
		{
			return stRepo.findAll(StudentSpecification.keywordContains(keyword) ,pageable);
		}
		return stRepo.findAll(pageable);
	}
	
	@Override
	public Student getById(int id) {
		// TODO Auto-generated method stub
		return stRepo.findById(id).get();
	}

	@Override
	public Student add(Student t) {
		// TODO Auto-generated method stub
		//return null;
		return stRepo.save(t);
	}

	@Override
	public Student update(Student t) {
		// TODO Auto-generated method stub
		//return null;
		return stRepo.save(t);
	}

	@Override
	public void delete(Student t) {
		// TODO Auto-generated method stub
		csRepo.deleteByStudentId(t.getId());
		stRepo.delete(t);
	}
	
	public List<Student> getStudentByYear(Integer year)
	{
		return stRepo.getStudentByYear(year);
	}
	
	
	
}
