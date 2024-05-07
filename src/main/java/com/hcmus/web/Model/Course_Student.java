package com.hcmus.web.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "course_student")
public class Course_Student {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   
   @ManyToOne(cascade = CascadeType.PERSIST)
   @JoinColumn(name = "student_id")
   private Student student;
   
   
   @ManyToOne(cascade = CascadeType.PERSIST)
   @JoinColumn(name = "course_id")
   private Course course;
   
   @Column(name = "grade")
   private Double grade;

   public Course_Student() {
	 super();
   }

   public Course_Student(Student student, Course course, Double grade) {
	  super();
	  this.student = student;
	  this.course = course;
	  this.grade = grade;
   }

   public Integer getId() {
	  return id;
   }

   public void setId(Integer id) {
	 this.id = id;
   }

   public Student getStudent() {
	 return student;
   }

   public void setStudent(Student student) {
      this.student = student;
   }

   public Course getCourse() {
	  return course;
   }

   public void setCourse(Course course) {
	  this.course = course;
   }

   public Double getGrade() {
    	return grade;
   }

   public void setGrade(Double grade) {
	 this.grade = grade;
   }
}
