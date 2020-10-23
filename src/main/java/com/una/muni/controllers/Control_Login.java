package com.una.muni.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.una.muni.entitys.t_users;
import com.una.muni.model.TDepartment;
import com.una.muni.model.TEmployee;
import com.una.muni.model.TJob;
import com.una.muni.model.TResolution;
import com.una.muni.model.TRole;
import com.una.muni.model.TTicket;
import com.una.muni.model.TUser;
import com.una.muni.repository.t_usersRepository;

// @CrossOrigin(origins = "http://localhost:3000"/* , maxAge = 3600 */)
@RestController
@RequestMapping(value = "tusers/" /*, consumes = MediaType.ALL_VALUE */)
public class Control_Login {
	@Autowired
	private t_usersRepository repo;

	// version de pablo y ema
	// @PostMapping(value = "validate")
	// public ResponseEntity<t_users > validate(@ModelAttribute t_users user) {
	// Optional<t_users > u = repo.findById(user.getUser());
	// if (u.isPresent() && u.get().getPass().equals(user.getPass())) {
	// return new ResponseEntity<t_users >(repo.findByUser(user.getUser()).get(),
	// HttpStatus.OK);
	// } else {
	// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// }
	// }

	// version nestor
	@RequestMapping(value = "validate", method = RequestMethod.POST)
	public String validate(@RequestParam(name = "user") String user, @RequestParam(name = "pass") String pass) {
		Optional<TUser> u = repo.findById(user);
		System.out.println(user);
		if (u.isPresent() && u.get().getPasswd().equals(pass) && u.get().getStatus().equals("ENABLED")) {
			JSONObject o = new JSONObject();
			o.put("rol", u.get().getTRole().getRoleId());
			// return ResponseEntity.status(HttpStatus.OK).body(u.get());
			return o.toString();
		} else {
			// return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			return new JSONObject().put("rol", -1).toString();
		}
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public @ResponseBody String insert(@RequestParam(name = "user") String user,
			@RequestParam(name = "pass") String pass, @RequestParam(name = "rol") int rol,
			@RequestParam(name = "status") String status) {
		TUser u = new TUser();
		u.setUsername(user);
		System.out.println(user);
		u.setPasswd(pass);
		u.setStatus(status);
		u.setTEmployee(null);
		TRole r = new TRole();
		r.setRoleId(4);
		r.setName("CLIENT");
		u.setTRole(r);
		repo.save(u);
		Optional<TUser> optional = repo.findById(user);
		if (optional.isPresent()) {
			JSONObject o = new JSONObject();
			o.put("resp", "Ingresado");
			System.out.println(o.toString());
			return o.toString();
		} else {
			return new JSONObject().put("resp", "no ingresado").toString();
		}
	}

	// @GetMapping(value = "listar")
	// public List<t_users > listar() {
	// List<t_users > list = new ArrayList<>();
	// var ite = repo.findAll();
	// ite.forEach(u -> list.add(u));
	//
	// return list;
	//
	// }
	//
	// @PostMapping(value = "delete")
	// public ResponseEntity<Object> delete(@ModelAttribute t_users user) {
	// repo.deleteById(user.getUser());
	// if (repo.findById(user.getUser()).isEmpty()) {
	// return new ResponseEntity<>(HttpStatus.OK);
	// } else {
	// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// }
	// }
	//
	// @PostMapping(value = "insert")
	// public ResponseEntity<Object> insert(@ModelAttribute t_users user) {
	// repo.save(user);
	// if (repo.findById(user.getUser()).isPresent()) {
	// return new ResponseEntity<>(HttpStatus.OK);
	// } else {
	// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// }
	// }
	//
	// @PostMapping(value = "update")
	// public ResponseEntity<Object> update(@ModelAttribute t_users user) {
	// repo.save(user);
	// if (repo.findById(user.getUser()).isPresent()) {
	// return new ResponseEntity<>(HttpStatus.OK);
	// } else {
	// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// }
	// }
}
