package com.project.professorallocation.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.entity.Course;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class CourseRepositoryTest {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Test
	public void findAll() {
		List<Course> courses = courseRepository.findAll();
		System.out.println(courses);
	}
	
	@Test
	public void findById() {
		
		Long id = 1L;	
		Optional<Course> courseOptional = courseRepository.findById(id);
		Course course = courseOptional.orElse(null);
		System.out.println(course);
	}
	
	@Test
	public void saveCreate() {
		
		Course c = new Course();
		c.setName("Literatura 1");	
		Course course = courseRepository.save(c);
		System.out.println(course);	
	}
	
	@Test
	public void saveUpdate() {
		
		Course c = new Course();
		c.setId(5L);
		c.setName("Literatura 1");
		Course course = courseRepository.save(c);
		System.out.println(course);	
	}
	
	@Test
	public void delete() {
		
		Long id = 5L;		
		courseRepository.deleteById(id);	
	}
	
	@Test
	public void deleteAll() {
				
		courseRepository.deleteAllInBatch();	
	}
}
