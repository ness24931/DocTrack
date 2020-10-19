package com.una.muni.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.una.muni.repository.t_employeesRepository;


@Service
public class t_employeesService {
	@Autowired
	private t_employeesRepository e;

	public void test() {
		/*
		 * if (e.existsById("111")) { System.out.println("Si lo cargo"); } else {
		 * System.out.println("No lo cargo"); }
		 */
	}

}