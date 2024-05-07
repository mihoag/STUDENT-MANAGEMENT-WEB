package com.hcmus.web.Api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcmus.web.DTO.CourseStudentDTO;
import com.hcmus.web.DTO.StudentDTO;
import com.hcmus.web.Model.Course;
import com.hcmus.web.Model.Course_Student;
import com.hcmus.web.Model.MyArray;
import com.hcmus.web.Model.Student;
import com.hcmus.web.service.CourseService;
import com.hcmus.web.service.CourseStudentService;
import com.hcmus.web.service.StudentService;

@RestController
public class ApiCourseStudent {
   
	@Autowired
	private CourseStudentService csSer;
	
	@Autowired
	private StudentService stSer;
	
	@Autowired
	private CourseService cSer;
	
	@GetMapping("/api/students-from-course/{id}")
	public List<StudentDTO> getStudentEnrollingCourse(@PathVariable("id") Integer idCourse)
	{
	
	   List<Student> lsSt =  csSer.getStudentFromCourse(idCourse);
	   List<StudentDTO> lsDTO = new ArrayList<>();
	   for(Student st : lsSt)
	   {
		   lsDTO.add(StudentDTO.ConvertToDTO(st));
	   }
	   return lsDTO;	
	}
	
	@GetMapping("/api/courses-from-student/{id}")
	public List<CourseStudentDTO> getCoursesFromStudent(@PathVariable("id") Integer id)
	{
		Student st = stSer.getById(id);
		List<Course_Student> lsCS = st.getListCourseStudent();
		List<CourseStudentDTO> lsDTO = new ArrayList<>();
		for(Course_Student cs : lsCS)
		{
			lsDTO.add(CourseStudentDTO.ConvertToDTO(cs));
		}
		return lsDTO;
		//List<Course_Student> lsCS = 
	}
	
	
	@GetMapping("/api/students-not-in-course/{id}")
	public List<StudentDTO> getStudentNotInCourse(@PathVariable("id") Integer idCourse)
	{
	
	   List<Student> lsSt =  csSer.listStudentsNotInCourse(idCourse);
	   List<StudentDTO> lsDTO = new ArrayList<>();
	   for(Student st : lsSt)
	   {
		   lsDTO.add(StudentDTO.ConvertToDTO(st));
	   }
	   return lsDTO;	
	}
	
	@PostMapping("/api/insertion-students-in-course/{id}")
	public ResponseEntity<?> insertStudentToCourse(@PathVariable("id") Integer idCourse, @RequestBody MyArray myArray)
	{
		try {
			//System.out.println(idCourse);
			//System.out.println(myArray.getListID().size());
   
			List<Integer> lsID = myArray.getListID();
			for(Integer id : lsID)
			{
				Student st = stSer.getById(id);
				Course course = cSer.getById(idCourse);
				Course_Student cs = new Course_Student(st, course, 0.0);
		        csSer.add(cs);
				//csSer.add(new Cou)
			}
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PutMapping(value = "/api/courses-student/{id}/point/{point}")
	public ResponseEntity<?> updatePoint (@PathVariable("id") Integer id, @PathVariable("point") Double point)
	{
		try {
			   csSer.updatePointStudent(id, point);
			   return ResponseEntity.ok().build();
		} catch (Exception e) {
			// TODO: handle exception
			   return ResponseEntity.notFound().build();
		}   
	}
	
	
	
	//@DeleteMapping
	@DeleteMapping("/api/student-course/{idCourse}/{idStudent}")
	public ResponseEntity<?> removeStudentFromCourse(@PathVariable("idCourse") Integer idCourse, @PathVariable("idStudent") Integer idStudent)
	{
		try {
		     csSer.removeStudentFromCourse(idCourse, idStudent);
		     return ResponseEntity.ok().build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}
}
