package com.hcmus.web.ModelSpecification;

import org.springframework.data.jpa.domain.Specification;

import com.hcmus.web.Model.Student;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class StudentSpecification {
	public static Specification<Student> keywordContains(String keyword) {
        return new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (keyword == null || keyword.isEmpty()) {
                    return criteriaBuilder.conjunction();
                }
                return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + keyword.toLowerCase() + "%");
            }
        };
    }
}
