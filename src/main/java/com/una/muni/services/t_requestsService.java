package com.una.muni.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.una.muni.repository.t_requestsRepository;




@Service
public class t_requestsService {
	@Autowired
	private t_requestsRepository repo;

	public void test() {
		// if (repo.existsById("111")) {
		// 	System.out.println("Si lo cargo");
		// } else {
		// 	System.out.println("No lo cargo");
		// }
	}
}