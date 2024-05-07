package com.hcmus.web.Model;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "student")
public class Student {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   
   @Column(name = "name", length = 65, nullable = false)
   private String name;
   
   @Column(name = "birthday", nullable = false)
   private Date birthday;
   
   @Column(name = "address", nullable = false, length = 64)
   private String address;
   
   @Column(name = "notes", length = 100)
   private String notes;

   @OneToMany(mappedBy =  "student" ,  cascade = CascadeType.REMOVE)
   private List<Course_Student> listCourseStudent;
   
   public Student() {
	 super();
	 // TODO Auto-generated constructor stub
   }

   public Student(Integer id)
   {
	   this.id  =id;
   }
   
   public List<Course_Student> getListCourseStudent() {
	return listCourseStudent;
   }

   public void setListCourseStudent(List<Course_Student> listCourseStudent) {
	  this.listCourseStudent = listCourseStudent;
   }
 
   public Student(String name, Date birthday, String address, String notes, List<Course_Student> listCourseStudent) {
	 super();
	 this.name = name;
	 this.birthday = birthday;
	 this.address = address;
	 this.notes = notes;
	 this.listCourseStudent = listCourseStudent;
   }
   
   

   public Student(Integer id, String name, Date birthday, String address, String notes,
		List<Course_Student> listCourseStudent) {
	super();
	this.id = id;
	this.name = name;
	this.birthday = birthday;
	this.address = address;
	this.notes = notes;
	this.listCourseStudent = listCourseStudent;
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

   public Date getBirthday() {
	 return birthday;
   }

   public void setBirthday(Date birthday) {
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
	Student other = (Student) obj;
	return Objects.equals(id, other.id);
}

@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", birthday=" + birthday + ", address=" + address + ", notes="
			+ notes + ", listCourseStudent=" + listCourseStudent + "]";
}
}
