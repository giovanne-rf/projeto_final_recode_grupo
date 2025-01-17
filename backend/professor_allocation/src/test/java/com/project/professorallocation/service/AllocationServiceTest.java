package com.project.professorallocation.service;

import java.sql.Date;
import java.time.DayOfWeek;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.entity.Allocation;
import com.project.professorallocation.entity.Course;
import com.project.professorallocation.entity.Department;
import com.project.professorallocation.entity.Professor;


@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class AllocationServiceTest {

	@Autowired
	private AllocationService allocationService;
	
	@Test
	public void create() {
		Allocation a = new Allocation();
		Professor p = new Professor();
		Course c = new Course();
		Department d = new Department();
		
		c.setId(8L);
		c.setName("teste");
		p.setId(4L);
		p.setName("José");
		p.setCpf("022.233.32-55");
		p.setDepartment(d);
		a.setId(8L);
		a.setProfessor(p);
		a.setCourse(c);
		a.setDays(DayOfWeek.FRIDAY);
		a.setStart_hour(Date.valueOf("9:00"));
		a.setEnd_hour(Date.valueOf("10:00"));
		
		
		Allocation a2 = allocationService.create(a);
		System.out.println(a2);
	}
	
	
	@Test
	public void findAll() {
		List<Allocation> a = allocationService.findAll();
		System.out.println(a);
	}
	
	
	@Test
	public void findById() {
		Long id = 6L;
		
		Allocation aList = allocationService.findById(id);
		System.out.println(aList);
	}
	
	
	@Test
	public void deleteAll() {
		allocationService.deleteAll();
	}
	
	
	@Test
	public void deleteById( ) {
		Long id = 7L;
		allocationService.deleteById(id);
	}
}
