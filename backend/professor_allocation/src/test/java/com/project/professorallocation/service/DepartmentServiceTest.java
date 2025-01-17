package com.project.professorallocation.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.entity.Department;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class DepartmentServiceTest {
	
	@Autowired
	private DepartmentService departmentService;

	@Test
	public void create() {
		Department d = new Department();
		d.setName("Teste 2");		
		Department d2 = departmentService.create(d);
		System.out.println(d2);
	}
	
	
	@Test
	public void findAll() {
		String name = "Física";
		List<Department> d = departmentService.findAll(name);
		System.out.println(d);
	}
	
	
	@Test
	public void findById() {
		Long id = 7L;
		
		Department d = departmentService.findById(id);
		System.out.println(d);
	}
	
	
	@Test
	public void findByName() {
		String name = "Física";
		
		List<Department> d = departmentService.findAll(name);
		System.out.println(d);
	}
	
	
	@Test
	public void deleteAll() {
		departmentService.deleteAll();
	}
	
	
	@Test
	public void deleteById( ) {
		Long id = 7L;
		departmentService.deleteById(id);
	}
}
