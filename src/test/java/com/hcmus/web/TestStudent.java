package com.hcmus.web;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.hcmus.web.Model.Student;
import com.hcmus.web.Repository.StudentRepository;
import com.hcmus.web.service.StudentService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class TestStudent {
   
	@Autowired
	private StudentRepository repo;
	
	@Autowired
	private StudentService ser;
	@Test
	public void TestInsertStudent()
	{
		/*Student st = new Student("Minh Hoàng",new Date(2003-1900, 0, 29), "Khánh Hòa", "None", null);
		ser.add(st);
		repo.save(st);
		*/
	}
	@Test
	public void TestDeleteStudent()
	{
		/*Student st = ser.getById(4);
		ser.delete(st);
	   ser.delete(st);*/
	}
	@Test
	public void TestStudentByYear()
	{
		List<Student> ls = ser.getStudentByYear(2021);
		System.out.println(ls.size());
	}
}
