package com.hcmus.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hcmus.web.Model.Course;
import com.hcmus.web.Model.Student;
import com.hcmus.web.ModelSpecification.CourseSpecification;
import com.hcmus.web.ModelSpecification.CourseYearSpecification;
import com.hcmus.web.ModelSpecification.StudentSpecification;
import com.hcmus.web.Repository.CourseRepository;
import com.hcmus.web.Repository.CourseStudentRepository;

@Service
public class CourseService implements IService<Course>{

	@Autowired
	private CourseRepository courseRepo;

	@Autowired
	private CourseStudentRepository csRepo;
	@Override
	public List<Course> getAll() {
		return courseRepo.findAll();
	}

	@Override
	public Course getById(int id) {
		return courseRepo.findById(id).get();
	}

	@Override
	public Course add(Course t) {
		return courseRepo.save(t);
	}

	@Override
	public Course update(Course t) {
		return courseRepo.save(t);
	}

	@Override
	public void delete(Course t) {
		csRepo.deleteByCourseId(t.getId());
		courseRepo.delete(t);
	}
	
	public Page<Course> listAll(String keyword, int pageNum, String sortField, String sortDir)
	{
		Pageable pageable = PageRequest.of(pageNum - 1, 10, 
				sortDir.equals("asc") ? Sort.by(sortField).ascending()
									  : Sort.by(sortField).descending()
		);
		if(keyword != null && !keyword.equals("") && !keyword.matches("\\d+"))
		{
			return courseRepo.findAll(CourseSpecification.keywordContains(keyword) ,pageable);
		}
		else if(keyword != null && !keyword.equals("") && keyword.matches("\\d+"))
		{
			return courseRepo.findAll(CourseYearSpecification.keywordContains(Integer.parseInt(keyword)) ,pageable);
		}
		return courseRepo.findAll(pageable);
	}
	
	public List<Integer> listYears()
	{
		return courseRepo.listYears();
	}
	
    
	
}
