package com.project.professorallocation.repository;

import java.sql.Date;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.entity.Allocation;
import com.project.professorallocation.entity.Course;
import com.project.professorallocation.entity.Professor;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class AllocationRepositoryTest {
	
	@Autowired
	private AllocationRepository allocationRepository;
	
	@Test
	public void findAll() {
		List<Allocation> allocations = allocationRepository.findAll();
		System.out.println(allocations);
	}
	
	@Test
	public void findById() {
		
		Long id = 1L;	
		Optional<Allocation> allocationOptional = allocationRepository.findById(id);
		Allocation allocation = allocationOptional.orElse(null);
		System.out.println(allocation);
	}
	
	@Test
	public void saveCreate() {
		
		Allocation a = new Allocation();
		Professor p = new Professor();
		Course c = new Course();
		p.setId(7L);
		c.setId(6L);
		a.setProfessor(p);
		a.setCourse(c);
		a.setDays(DayOfWeek.FRIDAY);
		a.setStart_hour(Date.valueOf("11:00"));
		a.setEnd_hour(Date.valueOf("12:00"));
		Allocation allocation = allocationRepository.save(a);
		System.out.println(allocation);	
	}
	
	@Test
	public void saveUpdate() {
		
		Allocation a = new Allocation();
		a.setId(5L);
		a.getProfessor().setId(3L);
		a.getCourse().setId(7L);
		a.setDays(DayOfWeek.FRIDAY);
		a.getStart_hour().setTime(11);
		a.getEnd_hour().setTime(12);			
		Allocation allocation = allocationRepository.save(a);
		System.out.println(allocation);	
	}
	
	@Test
	public void delete() {
		
		Long id = 5L;		
		allocationRepository.deleteById(id);	
	}
	
	@Test
	public void deleteAll() {
				
		allocationRepository.deleteAllInBatch();	
	}
}
