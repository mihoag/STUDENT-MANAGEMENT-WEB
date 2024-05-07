package com.hcmus.web.ModelSpecification;

import org.springframework.data.jpa.domain.Specification;

import com.hcmus.web.Model.Course;
import com.hcmus.web.Model.Student;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class CourseSpecification {
	public static Specification<Course> keywordContains(String keyword) {
        return new Specification<Course>() {
            @Override   
            public Predicate toPredicate(Root<Course> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (keyword == null || keyword.isEmpty()) {
                    return criteriaBuilder.conjunction();
                }
                return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + keyword.toLowerCase() + "%");
            }
        };
    }
}
