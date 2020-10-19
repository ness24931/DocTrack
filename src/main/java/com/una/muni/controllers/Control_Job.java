package com.una.muni.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.una.muni.entitys.t_jobs;
import com.una.muni.repository.t_jobsRepository;


@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(value = "t_jobs/", consumes = MediaType.ALL_VALUE)
public class Control_Job {
	@Autowired
	private t_jobsRepository repo;

	// @PostMapping(value = "validate")
	// public ResponseEntity<t_jobs> validate(@ModelAttribute t_jobs user) {
	// 	Optional<t_jobs> u = repo.findById(user.getJob_id());
	// 	if (u.isPresent() ) {
	// 		return new ResponseEntity<t_jobs>(repo.findById(user.getJob_id()).get(), HttpStatus.OK);
	// 	} else {
	// 		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// 	}
	// }

	// @GetMapping(value = "listar")
	// public List<t_jobs> listar() {
	// 	List<t_jobs> list = new ArrayList<>();
	// 	var ite = repo.findAll();
	// 	ite.forEach(u -> list.add(u));
	// 	return list;
	// }

	// @PostMapping(value = "delete")
	// public ResponseEntity<Object> delete(@ModelAttribute t_jobs user) {
	// 	repo.deleteById(user.getJob_id());
	// 	if (repo.findById(user.getJob_id()).isEmpty()) {
	// 		return new ResponseEntity<>(HttpStatus.OK);
	// 	} else {
	// 		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// 	}
	// }

	// @PostMapping(value = "insert")
	// public ResponseEntity<Object> insert(@ModelAttribute t_jobs user) {
	// 	repo.save(user);
	// 	if (repo.findById(user.getJob_id()).isPresent()) {
	// 		return new ResponseEntity<>(HttpStatus.OK);
	// 	} else {
	// 		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// 	}
	// }

	// @PostMapping(value = "update")
	// public ResponseEntity<Object> update(@ModelAttribute t_jobs user) {
	// 	repo.save(user);
	// 	if (repo.findById(user.getJob_id()).isPresent()) {
	// 		return new ResponseEntity<>(HttpStatus.OK);
	// 	} else {
	// 		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// 	}
	// }
}
