package com.hcmus.web.DTO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.hcmus.web.Model.Course;
import com.hcmus.web.Model.Student;

public class CourseDTO {
	   private Integer id;
	   private String name;
	   private Integer year;
	   private String lecture;
	   private String notes;
	  
	   public CourseDTO() {
	   }
	  
	public CourseDTO(Integer id, String name, Integer year, String lecture, String notes) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.lecture = lecture;
		this.notes = notes;
	}




	public static  CourseDTO ConvertToDTO(Course c) {
		 return new CourseDTO(c.getId(), c.getName(), c.getYear(), c.getLecture(), c.getNotes());
	}

	   
	public static Course DTOtoModel(CourseDTO c) {
	   	// TODO Auto-generated method stub
	   	//return null;
		  return new Course(c.getId(), c.getName(),c.getLecture(), c.getYear(), c.getNotes(), null);
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


	  public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getLecture() {
		return lecture;
	}

	public void setLecture(String lecture) {
		this.lecture = lecture;
	}

	public String getNotes() {
		return notes;
	  }

	  public void setNotes(String notes) {
		this.notes = notes;
	  } 
}
