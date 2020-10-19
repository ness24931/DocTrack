package com.una.muni.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.una.muni.repository.t_usersRepository;


@Service
public class userService {
	@Autowired
	private t_usersRepository urepo;

	public void test() {
		// if (urepo.existsById("111")) {
		// 	System.out.println("Si lo cargo");
		// } else {
		// 	System.out.println("No lo cargo");
		// }
	}

}
