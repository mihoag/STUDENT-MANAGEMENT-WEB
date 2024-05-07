package com.hcmus.web.DTO;

import com.hcmus.web.Model.Course_Student;
import com.hcmus.web.Model.Student;

public class CourseStudentDTO {
   private Integer idCourseStudent;
   private Integer idCourse;
   private String nameCourse;
   private String lecture;
   private Integer year;
   private Double point;
public CourseStudentDTO() {
	super();
	// TODO Auto-generated constructor stub
}



public CourseStudentDTO(Integer idCourseStudent, Integer idCourse, String nameCourse, String lecture, Integer year,
		Double point) {
	super();
	this.idCourseStudent = idCourseStudent;
	this.idCourse = idCourse;
	this.nameCourse = nameCourse;
	this.lecture = lecture;
	this.year = year;
	this.point = point;
}



public static  CourseStudentDTO ConvertToDTO(Course_Student cs) {
  	 // TODO Auto-generated method stub
  	 //return null;
	return new CourseStudentDTO(cs.getId(),cs.getCourse().getId(), cs.getCourse().getName(), cs.getCourse().getLecture(), cs.getCourse().getYear(), cs.getGrade());
}



public Integer getIdCourseStudent() {
	return idCourseStudent;
}
public void setIdCourseStudent(Integer idCourseStudent) {
	this.idCourseStudent = idCourseStudent;
}
public Integer getIdCourse() {
	return idCourse;
}
public void setIdCourse(Integer idCourse) {
	this.idCourse = idCourse;
}
public String getNameCourse() {
	return nameCourse;
}
public void setNameCourse(String nameCourse) {
	this.nameCourse = nameCourse;
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
public Double getPoint() {
	return point;
}
public void setPoint(Double point) {
	this.point = point;
}
}
