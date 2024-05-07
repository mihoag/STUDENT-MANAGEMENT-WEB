package com.hcmus.web.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcmus.web.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> {
	@Query(value = "select * from student u where u.name like %?1%", nativeQuery = true)
	public List<Student> findStudentByName(String name);
	
	
	// Get list student enrolling class
	@Query(value = "select * from student s where s.id in (select cs.student_id from course_student cs where cs.course_id = ?1)", nativeQuery = true)
	public List<Student> getStudentEnroll(Integer idCourse);
	
	// Get List student not in course
	@Query(value = "select * from student s where s.id not in (select cs.student_id from course_student cs where cs.course_id = ?1) ", nativeQuery = true)
	public List<Student> getStudentsNotInCourse(Integer idCourse);
	
	
	// Get list student in course in year
	@Query(value = "select * from student s where s.id in (select cs.student_id from course_student cs, course c where cs.course_id = c.id and c.year = ?1 ) ", nativeQuery =  true)
	public List<Student> getStudentByYear(Integer year);
}
