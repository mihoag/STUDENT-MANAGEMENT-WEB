package com.hcmus.web.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcmus.web.Model.Course_Student;

import jakarta.transaction.Transactional;

@Repository
public interface CourseStudentRepository extends JpaRepository<Course_Student, Integer> {
   @Transactional
   @Modifying
   @Query( value =  "delete from course_student cs where cs.student_id = ?1", nativeQuery = true)
   public void deleteByStudentId(Integer id);
   
	 
   @Transactional
   @Modifying
   @Query(value = "delete from course_student cs where cs.course_id = ?1", nativeQuery = true)
   public int deleteByCourseId(Integer id);
   
   @Transactional
   @Modifying
   @Query(value = "delete from course_student cs where cs.course_id = ?1 and cs.student_id = ?2", nativeQuery = true)
   public int deleteStudentCourse(Integer idCourse, Integer idStudent);
  
}
