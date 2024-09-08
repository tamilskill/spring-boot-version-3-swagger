package com.tamilskillhub.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tamilskillhub.course.entity.Course;
import com.tamilskillhub.course.service.CourseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@Tag(name="Tutorial", description= "Tutorial management APIs")
@RestController
@RequestMapping("/api")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/welcome")
	public String welcome() {
		return new String("Welcome User!");
	}
	
	@GetMapping("/courses")
	public List<Course> getCourses() {
		return courseService.getCourses();
	}
	
	
	@Operation(summary="Retrieve a tutorial using id", description ="Get the tutrial opbject using the passed id as path variable", tags= {"tutorials", "get"})
	@ApiResponses({
		@ApiResponse(responseCode = "200", content = {
				@Content(schema = @Schema(implementation = Course.class), mediaType = "application/json")
		}),
		@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema())}),
		@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema())})
	})
	
	@GetMapping("/course/{id}")
	public Course getCourseById(@PathVariable Long id) {
		return courseService.getCourseById(id);
	}
	
	@PostMapping("/course")
	public Course addCourse(@RequestBody Course course) {
		//TODO: process POST request
		
		return courseService.addCourse(course);
	}
	
	@PutMapping("/course/{id}")
	public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
		//TODO: process PUT request
		course.setId(id);
		return courseService.addCourse(course);
	}
	
	@DeleteMapping("/course/{id}")
	public String deleteCourse(@PathVariable Long id) {
		return courseService.deleteCourse(id);
	}
	
	

}
