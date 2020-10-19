package com.una.muni.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.una.muni.repository.t_departmentsRepository;



@Service
public class t_departmenstService {
	@Autowired
	private t_departmentsRepository e;

	public void test() {
		// if (e.existsById("111")) {
		// 	System.out.println("Si lo cargo");
		// } else {
		// 	System.out.println("No lo cargo");
		// }
	}
}




