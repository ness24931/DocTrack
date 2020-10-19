package com.una.muni.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.una.muni.repository.t_requirementsRepository;


@Service
public class requirementsService {
	@Autowired
	private t_requirementsRepository repo;

	public void test() {
		// if (repo.existsById("111")) {
		// 	System.out.println("Si lo cargo");
		// } else {
		// 	System.out.println("No lo cargo");
		// }
	}

}
