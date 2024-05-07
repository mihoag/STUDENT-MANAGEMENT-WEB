package com.hcmus.web.Model;

import java.util.List;
import java.util.Objects;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Course")
public class Course {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   
   @Column(name = "name", length = 64, nullable = false)
   private String name;
   
   @Column(name = "lecture", nullable = false, length = 64)
   private String lecture ;
   
   @Column(name = "year")
   private Integer year;
   
   @Column(name = "notes", length = 100)
   private String notes;
   
   @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "course")
   private List<Course_Student> listCourseStuent;

    public Course() {
    }

   

    public Course(String name, String lecture, Integer year, String notes, List<Course_Student> listCourseStuent) {
		super();
		this.name = name;
		this.lecture = lecture;
		this.year = year;
		this.notes = notes;
		this.listCourseStuent = listCourseStuent;
	}
 
	public Course(Integer id, String name, String lecture, Integer year, String notes,
			List<Course_Student> listCourseStuent) {
		super();
		this.id = id;
		this.name = name;
		this.lecture = lecture;
		this.year = year;
		this.notes = notes;
		this.listCourseStuent = listCourseStuent;
	}



	public List<Course_Student> getListCourseStuent() {
		return listCourseStuent;
	}



	public void setListCourseStuent(List<Course_Student> listCourseStuent) {
		this.listCourseStuent = listCourseStuent;
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

    public String getLecture() {
    	return lecture;
    }

    public void setLecture(String lecture) {
	   this.lecture = lecture;
    }

    public Integer getYear() {
	  return year;
    }

    public void setYear(Integer year) {
	    this.year = year;
    }

    public String getNotes() {
     	return notes;
    }

    public void setNotes(String notes) {
    	this.notes = notes;
    }



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(id, other.id);
	}
    
    
}
