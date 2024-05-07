package com.hcmus.web.DTO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hcmus.web.Model.Student;

public class StudentDTO {
   private Integer id;
   private String name;
   private String birthday;
   private String address;
   private String notes;
  
   public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
   

   public StudentDTO(Integer id, String name, String birthday, String address, String notes) {
	super();
	this.id = id;
	this.name = name;
	this.birthday = birthday;
	this.address = address;
	this.notes = notes;
}


  
   public static  StudentDTO ConvertToDTO(Student u) {
   	 // TODO Auto-generated method stub
   	 //return null;
	   
	 return new StudentDTO(u.getId(), u.getName(), new SimpleDateFormat("dd-MM-yyyy").format(u.getBirthday()), u.getAddress(), u.getNotes());
   }

   
   public static Student DTOtoModel(StudentDTO t) {
   	// TODO Auto-generated method stub
   	//return null;
	   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	   try {
		   Date date = dateFormat.parse(t.getBirthday());
		   return new Student(t.getId(),t.getName(), new java.sql.Date(date.getTime()) , t.getAddress(), t.getNotes(), null);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	  return null;
   }
   
   public static List<StudentDTO> listModeltoListDTO(List<Student> lsSt)
   {
	   List<StudentDTO> lsDTO = new ArrayList<>();
	   
	   lsSt.forEach(st -> {
		   lsDTO.add(ConvertToDTO(st));
	   });
	   return lsDTO;
   }
   public Integer getId() {
	return id;
   }


   public void setId(Integer id) {
	this.id = id;
  }


   public String getName() {
	return name;
  }


  public void setName(String name) {
	this.name = name;
  }


  public String getBirthday() {
	return birthday;
  }


  public void setBirthday(String birthday) {
	this.birthday = birthday;
  }


  public String getAddress() {
	return address;
  }


  public void setAddress(String address) {
	this.address = address;
  }


  public String getNotes() {
	return notes;
  }


  public void setNotes(String notes) {
	this.notes = notes;
  } 
}
