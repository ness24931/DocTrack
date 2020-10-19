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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.una.muni.entitys.t_employees;
import com.una.muni.model.TEmployee;
import com.una.muni.model.TUser;
import com.una.muni.repository.t_employeesRepository;

// @CrossOrigin(origins = "http://localhost:3000"/*, maxAge = 3600*/)
@RestController
@RequestMapping(value = "t_employees/", consumes = MediaType.ALL_VALUE)
public class Control_Employee {
	@Autowired
	private t_employeesRepository repo;

	@PostMapping(value = "filter")
	public List<TEmployee> filter(@RequestParam(name = "firstName")String name){
		List<TEmployee> list = new ArrayList<>();
		var result = repo.findAllByFirstName(name);
		result.forEach(list::add);
		return list;
	}


	// @PostMapping(value = "validate") 
	// public ResponseEntity<TEmployee> validate(@ModelAttribute TEmployee employee) {
	// 	Optional<TEmployee> e = repo.findById(employee.getEmployee_id());
	// 	if (e.isPresent()) {
	// 		return new ResponseEntity<TEmployee>(repo.findById(employee.getEmployee_id()).get(), HttpStatus.OK);
	// 	} else {
	// 		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// 	}
	// }
  
	// @GetMapping(value = "listar")
	// public List<t_employees> listar() {
	// 	List<t_employees> list = new ArrayList<>();
	// 	var ite = repo.findAll();
	// 	ite.forEach(e -> list.add(e));
	// 	return list;
	// }
	
	// @PostMapping(value = "delete")
	// public ResponseEntity<Object> delete(@ModelAttribute t_employees employee) {
	// 	repo.deleteById(employee.getEmployee_id());
	// 	if (repo.findById(employee.getEmployee_id()).isEmpty()) {
	// 		return new ResponseEntity<>(HttpStatus.OK);
	// 	} else {
	// 		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// 	}
	// }

	// @PostMapping(value = "insert")
	// public ResponseEntity<Object> insert(@ModelAttribute t_employees employee) {
	// 	repo.save(employee);
	// 	if (repo.findById(employee.getEmployee_id()).isPresent()) {
	// 		return new ResponseEntity<>(HttpStatus.OK);
	// 	} else {
	// 		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// 	}
	// }

	// @PostMapping(value = "update")
	// public ResponseEntity<Object> update(@ModelAttribute t_employees employee) {
	// 	repo.save(employee);
	// 	if (repo.findById(employee.getEmployee_id()).isPresent()) {
	// 		return new ResponseEntity<>(HttpStatus.OK);
	// 	} else {
	// 		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// 	}
	// }
}
