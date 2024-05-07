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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcmus.web.DTO.StudentDTO;
import com.hcmus.web.Model.Student;
import com.hcmus.web.service.StudentService;

@RestController
public class ApiStudent {
	
	@Autowired
	private StudentService stSer;
	
	
	@GetMapping("/api/student/{id}")
    public StudentDTO getStudentById(@PathVariable(name = "id") Integer id)
    {
    	Student st = stSer.getById(id);
    	return StudentDTO.ConvertToDTO(st);
    }
	
    @GetMapping("/api/student/get-all")
    public ResponseEntity<?> getAll()
    {
       List<Student> lsSt =  stSer.getAll();	
       if(lsSt.isEmpty())
       {
    	   return ResponseEntity.noContent().build();
       }
       
       List<StudentDTO> lsStDTO = new ArrayList<>();
       
       for(Student st : lsSt)
       {
    	     lsStDTO.add(StudentDTO.ConvertToDTO(st));
       }
       return new ResponseEntity<>(lsStDTO, HttpStatus.OK);
    }
    
    @PostMapping("/api/student")
    public ResponseEntity<?> insertStudent(@RequestBody StudentDTO st)
    {
    	stSer.add(StudentDTO.DTOtoModel(st));
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/api/student")
    public  ResponseEntity<?> update(@RequestBody StudentDTO st)
    {
    	Student student1 = StudentDTO.DTOtoModel(st);
        Student student2 = stSer.getById(st.getId());
    	List<Student> lsSt = stSer.getAll();
    	//System.out.println(student);
    	if(!lsSt.contains(student1))
    	{
    		return ResponseEntity.notFound().build();
    	}
    	else
    	{
    		student1.setListCourseStudent(student2.getListCourseStudent());
    		stSer.update(student1);
    		return  new ResponseEntity(HttpStatus.OK);
    	}
    }
   
    @DeleteMapping("/api/student/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable(name = "id") Integer id)
    {
    	List<Student> lsSt = stSer.getAll();
    	Student st = new Student(id);
    	if(!lsSt.contains(st))
    	{
    	   return ResponseEntity.notFound().build();	
    	}
    	//System.out.println(st);
        stSer.delete(st);
        return new ResponseEntity<>	(HttpStatus.OK);
    } 
    
    
}
