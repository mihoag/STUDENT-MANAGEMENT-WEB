package com.hcmus.web.Api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcmus.web.DTO.CourseDTO;
import com.hcmus.web.DTO.StudentDTO;
import com.hcmus.web.Model.Course;
import com.hcmus.web.Model.Student;
import com.hcmus.web.service.CourseService;
import com.hcmus.web.service.StudentService;

@RestController
public class ApiCourse {
	@Autowired
	private CourseService cSer;
	
	
	@GetMapping("/api/course/{id}")
    public CourseDTO getCoursetById(@PathVariable(name = "id") Integer id)
    {
    	Course st = cSer.getById(id);
    	return CourseDTO.ConvertToDTO(st);
    }
	
 
    @PutMapping("/api/course")
    public  ResponseEntity<?> update(@RequestBody CourseDTO course)
    {
    	Course course1 = CourseDTO.DTOtoModel(course);
    	Course course2 = cSer.getById(course.getId());
    	List<Course> lsCourse = cSer.getAll();
    	//System.out.println(student);
    	if(!lsCourse.contains(course1))
    	{
    		return ResponseEntity.notFound().build();
    	}
    	else
    	{
    		course1.setListCourseStuent(course2.getListCourseStuent());
    		cSer.update(course1);
    		return  new ResponseEntity(HttpStatus.OK);
    	}
    }
   
    @DeleteMapping("/api/course/{id}")
    public ResponseEntity<?> deleteCourseById(@PathVariable(name = "id") Integer id)
    {
    	List<Course> lsCourse = cSer.getAll();
    	Course course = cSer.getById(id);
    	if(!lsCourse.contains(course))
    	{
    	   return ResponseEntity.notFound().build();	
    	}
    	//System.out.println(st);
        cSer.delete(course);
        return new ResponseEntity<>	(HttpStatus.OK);
    } 
}
