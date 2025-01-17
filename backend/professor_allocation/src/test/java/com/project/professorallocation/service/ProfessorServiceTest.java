package com.project.professorallocation.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.entity.Department;
import com.project.professorallocation.entity.Professor;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class ProfessorServiceTest {

	@Autowired
	private ProfessorService professorService;
	
	@Test
	public void create() {
		Professor p = new Professor();
		Department d = new Department();
		d.setId(8L);		
		p.setId(4L);
		p.setName("José");
		p.setCpf("022.233.32-55");
		p.setDepartment(d);		
		Professor p2 = professorService.create(p);
		System.out.println(p2);
	}
	
	
	@Test
	public void update() {
		Professor p = new Professor();
		Department d = new Department();
		d.setId(8L);		
		p.setId(4L);
		p.setName("José");
		p.setCpf("022.233.32-55");
		p.setDepartment(d);		
		Professor p2 = professorService.create(p);
		System.out.println(p2);
	}
	
	
	@Test
	public void findAll(String name) {
		List<Professor> p = professorService.findAll(name);
		System.out.println(p);
	}
	
	
	@Test
	public void findById() {
		Long id = 14L;		
		Professor p = professorService.findById(id);
		System.out.println(p);
	}
	
	
	@Test
	public void findByName() {
		String name = "João";		
		List<Professor> p = professorService.findAll(name);
		System.out.println(p);
	}
	
	
	@Test
	public void deleteAll() {
		professorService.deleteAll();
	}
	
	
	@Test
	public void deleteById( ) {
		Long id = 7L;
		professorService.deleteById(id);
	}
}
