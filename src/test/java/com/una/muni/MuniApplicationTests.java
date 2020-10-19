package com.una.muni;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.una.muni.model.TUser;
import com.una.muni.repository.t_usersRepository;


@SpringBootTest
class MuniApplicationTests {

	@Autowired
	private t_usersRepository repo;
	
	@Test
	void contextLoads() {
		List<TUser> lista =(List<TUser>) repo.findAll();
		TUser u= lista.get(0);
		System.out.println(u.getTEmployee().getFirstName());
		
		
		
		
		
//		lista.forEach(m -> System.out.println(m.getTRole().getName()));
//		assertTrue(repo.existsById("jpiedras"));
//		assertTrue(e.findById("1").isPresent());
		//assertTrue(urepo.existsById("111"));
		
	
	}
	
	

}
