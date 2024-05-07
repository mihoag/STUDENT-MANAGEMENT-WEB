package com.hcmus.web;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.hcmus.web.Model.Course;
import com.hcmus.web.Model.Course_Student;
import com.hcmus.web.Model.Student;
import com.hcmus.web.Repository.StudentRepository;
import com.hcmus.web.service.CourseService;
import com.hcmus.web.service.CourseStudentService;
import com.hcmus.web.service.StudentService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CourseStudentTest {

	@Autowired
	private CourseService serCourse;
	
	@Autowired
	private StudentRepository stRepo;
	
	@Autowired 
	private StudentService studentSer;
	
	@Autowired
	private CourseStudentService courseStudentSer;
	
	@Test
	public void testCourseStudent()
	{
	  /* Student st = studentSer.getById(5);
	   Course co = serCourse.getById(3);
	   Course_Student cs = new Course_Student(st, co, 10.0);
	   courseStudentSer.add(cs);
	   
	   
	   List<Course_Student> lsCourse = st.getListCourseStudent();
	   System.out.println("Size: " + lsCourse.size());
	   
	   
	   List<Course_Student> lsCourse1 = co.getListCourseStuent();
	   System.out.println("Size: " + lsCourse1.size());
	  */
		
		List<Student> lsSt = stRepo.getStudentEnroll(1);
		System.out.println(lsSt.size());
		// Student st = studentSer.getById(4);
		 //Course co = serCourse.getById(3);
		 
		 // courseStudentSer.delete(courseStudentSer.getById(5));
		 //Course_Student cs = courseStudentSer.getById(6);
		 //st.getListCourseStudent().remove(cs);
		 //System.out.println(st.getListCourseStudent().size());
		 // System.out.println(co.getListCourseStuent().size());
	}
}
