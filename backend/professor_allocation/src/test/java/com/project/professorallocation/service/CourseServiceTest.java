package com.project.professorallocation.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.entity.Course;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class CourseServiceTest {

	@Autowired
	private CourseService courseService;

	@Test
	public void create() {
		Course c = new Course();
		c.setId(4L);
		c.setName("Matemática");;	
		
		Course c2 = courseService.create(c);
		System.out.println(c2);
	}
	
	
	@Test
	public void findAll(String name) {
		List<Course> d = courseService.findAll(name);
		System.out.println(d);
	}
	
	
	@Test
	public void findById() {
		Long id = 7L;
		
		Course cList = courseService.findById(id);
		System.out.println(cList);
	}
	
	
	@Test
	public void deleteAll() {
		courseService.deleteAll();
	}
	
	
	@Test
	public void deleteById( ) {
		Long id = 7L;
		courseService.deleteById(id);
	}
}
