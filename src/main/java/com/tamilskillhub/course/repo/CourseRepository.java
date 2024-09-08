package com.tamilskillhub.course.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tamilskillhub.course.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
