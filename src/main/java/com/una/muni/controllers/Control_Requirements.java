package com.una.muni.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.una.muni.entitys.t_requirements;
import com.una.muni.model.TRequirement;
import com.una.muni.repository.t_requirementsRepository;

@CrossOrigin(origins = "http://localhost:3000"/*, maxAge = 3600*/)
@RestController
@RequestMapping(value = "t_requiremnt/"/*, consumes = MediaType.ALL_VALUE*/)
public class Control_Requirements {
	@Autowired
	private t_requirementsRepository repo;

//	@PostMapping(value = "validate") 
//	public ResponseEntity<t_requirements> validate(@ModelAttribute t_requirements r) {
//		Optional<t_requirements> req = repo.findById(r.getRequirement_id());
//		if (req.isPresent()) {
//			return new ResponseEntity<t_requirements>(repo.findById(r.getRequirement_id()).get(), HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
  
	@RequestMapping(value = "listar")
	public List<TRequirement> listar() {   
		List<TRequirement> list = new ArrayList<>();
		var ite = repo.findAll();
		ite.forEach(e -> list.add(e));
		return list;
	}
	
//	@PostMapping(value = "delete")
//	public ResponseEntity<Object> delete(@ModelAttribute t_requirements r) {
//		repo.deleteById(r.getRequirement_id());
//		if (repo.findById(r.getRequirement_id()).isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}



	// @RequestMapping(value = "insert")
	// public ResponseEntity<Object> insert(@ModelAttribute TRequirement r) {
	// 	repo.save(r);
	// 	if (repo.findById(r.getRequirementId()).isPresent()) {
	// 		return new ResponseEntity<>(HttpStatus.OK);
	// 	} else {
	// 		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// 	}
	// }



//
//	@PostMapping(value = "update")
//	public ResponseEntity<Object> update(@ModelAttribute t_requirements r) {
//		repo.save(r);
//		if (repo.findById(r.getRequirement_id()).isPresent()) {
//			return new ResponseEntity<>(HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
}
