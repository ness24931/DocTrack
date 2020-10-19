package com.una.muni.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.una.muni.entitys.t_departments;
import com.una.muni.model.TDepartment;
import com.una.muni.repository.t_departmentsRepository;


@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(value = "t_departments/", consumes = MediaType.ALL_VALUE)
public class Control_Department {

	
	@Autowired
	private t_departmentsRepository repo;
// 
//	@PostMapping(value = "validate")
//	public ResponseEntity<t_departments> validate(@ModelAttribute t_departments t_departments) {
//		Optional<t_departments> d = repo.findById(t_departments.getDepartment_id());
//		if (d.isPresent()) {
//			return new ResponseEntity<t_departments>(repo.findById(t_departments.getDepartment_id()).get(), HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
// 
	@RequestMapping(value = "listar",method = RequestMethod.POST)
	public List<TDepartment> listar() {
		List<TDepartment> list = new ArrayList<>();
		var ite = repo.findAll();
		ite.forEach(e -> list.add(e));
		return list;
	}
//	
//	@PostMapping(value = "delete")
//	public ResponseEntity<Object> delete(@ModelAttribute t_departments department) {
//		repo.deleteById(department.getDepartment_id());
//		if (repo.findById(department.getDepartment_id()).isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
//
//	@PostMapping(value = "insert")
//	public ResponseEntity<Object> insert(@ModelAttribute t_departments t_departments) {
//		repo.save(t_departments);
//		if (repo.findById(t_departments.getDepartment_id()).isPresent()) {
//			return new ResponseEntity<>(HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
//
//	@PostMapping(value = "update")
//	public ResponseEntity<Object> update(@ModelAttribute t_departments t_departments) {
//		repo.save(t_departments);
//		if (repo.findById(t_departments.getDepartment_id()).isPresent()) {
//			return new ResponseEntity<>(HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
}

	



