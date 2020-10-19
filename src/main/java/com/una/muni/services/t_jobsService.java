package com.una.muni.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.una.muni.repository.t_jobsRepository;


@Service
public class t_jobsService {
	@Autowired
	private t_jobsRepository e;

	public void test() {
		// if (e.existsById("111")) {
		// 	System.out.println("Si lo cargo");
		// } else {
		// 	System.out.println("No lo cargo");
		// }
	}
}



