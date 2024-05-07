package com.hcmus.web.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcmus.web.Model.Course;
import com.hcmus.web.Model.Student;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>,JpaSpecificationExecutor<Course> {
	
	@Query(value = "select distinct c.year from course c order by c.year desc", nativeQuery = true)
	public List<Integer> listYears();
}
