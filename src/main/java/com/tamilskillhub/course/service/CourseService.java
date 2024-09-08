package com.tamilskillhub.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tamilskillhub.course.entity.Course;
import com.tamilskillhub.course.repo.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository repo;

	public List<Course> getCourses(){
		return repo.findAll();
	}
	
	public Course getCourseById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Course addCourse(Course course) {
		return repo.save(course);
	}
	
	public String deleteCourse(Long id) {
		repo.deleteById(id);
		return "deleted sucessfully";
	}
}
