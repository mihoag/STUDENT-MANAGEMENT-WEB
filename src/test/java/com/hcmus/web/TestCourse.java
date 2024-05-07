package com.hcmus.web;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.hcmus.web.Model.Course;
import com.hcmus.web.Repository.CourseRepository;
import com.hcmus.web.service.CourseService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class TestCourse {
    
	@Autowired
	private CourseService ser;
	
	@Autowired
	private CourseRepository repo;
	
	@Test
	public void TestAddCourse()
	{
		
		/*Course course1 = new Course("Lập trình hướng đối tượng", "Nguyễn Thanh Tùng", 2021, "none", null);
		Course course2 = new Course("Mạng máy tính", "Nguyễn Hà Minh", 2021, "none", null);
		
		ser.add(course1);
		ser.add(course2);
		*/
	}
	
	@Test
	public void TestDeleteCourse()
	{
		//Course c = ser.getById(1);
		//ser.delete(c);
	}
	
	@Test
	public void getYears()
	{
		List<Integer> lsYear = repo.listYears();
		lsYear.forEach(System.out::println);
	}
}
