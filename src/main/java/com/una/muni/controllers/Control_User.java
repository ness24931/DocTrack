package com.una.muni.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.una.muni.model.TEmployee;
import com.una.muni.model.TJob;
import com.una.muni.model.TRole;
import com.una.muni.model.TUser;
import com.una.muni.model.TDepartment;
import com.una.muni.repository.t_employeesRepository;
import com.una.muni.repository.t_usersRepository;

// @CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "tusersE/")
public class Control_User {

	@Autowired
	private t_usersRepository repo;

	@Autowired
	private t_employeesRepository repoE;

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public @ResponseBody String insert(@RequestParam(name = "e_dni") String dni,
			@RequestParam(name = "e_name") String name, @RequestParam(name = "e_first") String firstsur,
			@RequestParam(name = "e_second") String secondsur, @RequestParam(name = "e_email") String email,
			@RequestParam(name = "e_tel") String tel, @RequestParam(name = "e_department") int department,
			@RequestParam(name = "e_position") int position, @RequestParam(name = "u_user") String user,
			@RequestParam(name = "u_pass") String pass) {
		JSONObject o = new JSONObject();
		TUser u = new TUser();
		u.setUsername(user);
		u.setPasswd(pass);
		u.setStatus("ENABLED");

		TRole r = new TRole();
		r.setRoleId(3);
		r.setName("USER");
		u.setTRole(r);

		TEmployee emplo = new TEmployee();
		emplo.setDni(dni);
		emplo.setEmail(email);
		emplo.setStatus("ENABLED");
		emplo.setFirstName(name);
		emplo.setSecondSurname(secondsur);
		emplo.setTelephone(tel);
		emplo.setFirstSurname(firstsur);

		TDepartment depart = new TDepartment();
		depart.setDepartmentId(department);
		emplo.setTDepartment(depart);

		TJob job = new TJob();
		job.setJobId(position);
		emplo.setTJob(job);

		u.setTEmployee(emplo);

		repoE.save(u.getTEmployee());
		repo.save(u);
		return o.put("status", "ok").toString();
	}

	@RequestMapping(value = "listar", method = RequestMethod.POST)
	public List<TUser> requestMethodName() {
		List<TUser> list = new ArrayList<>();
		Iterable<TUser> ite = repo.findAll();
		ite.forEach(list::add);
		return list;
	}

	@RequestMapping(value = "find", method = RequestMethod.POST)
	public TUser findUser(@RequestParam(name = "username")String username) {
		Optional<TUser> user = repo.findById(username);
		if(user.isPresent()){
			return user.get();
		}
		return null;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public @ResponseBody String update(@RequestParam(name = "user") String u) {

		JSONObject user = new JSONObject(u);
		JSONObject role = user.getJSONObject("trole");
		JSONObject employee = user.getJSONObject("temployee");
		JSONObject job = employee.getJSONObject("tjob");
		JSONObject department = employee.getJSONObject("tdepartment");
		JSONArray resolutions = employee.getJSONArray("tresolutions");
		JSONArray tickets = employee.getJSONArray("ttickets");

		System.out.println(user.toString());

		TDepartment depa = new TDepartment();
		depa.setDepartmentId(department.getInt("departmentId"));
		depa.setDepartmentName(department.getString("departmentName"));
		depa.setTEmployee(null);

		TJob tjob = new TJob();
		tjob.setJobTitle(job.getString("jobTitle"));
		tjob.setJobId(job.getInt("jobId"));

		TEmployee emp = new TEmployee();
		emp.setDni(employee.getString("dni"));
		emp.setEmail(employee.getString("email"));
		emp.setFirstName(employee.getString("firstName"));
		emp.setFirstSurname(employee.getString("firstSurname"));
		emp.setSecondSurname(employee.getString("secondSurname"));
		emp.setStatus(employee.getString("status"));
		emp.setTelephone(employee.getString("telephone"));

		emp.setTDepartment(depa);
		emp.setTJob(tjob);

		TRole trole = new TRole();
		trole.setName(role.getString("name"));
		trole.setRoleId(role.getInt("roleId"));

		TUser tuser = new TUser();
		tuser.setUsername(user.getString("username"));
		tuser.setPasswd(user.getString("passwd"));
		tuser.setStatus(user.getString("status"));
		tuser.setTEmployee(emp);
		tuser.setTRole(trole);

		repoE.save(emp);
		repo.save(tuser);

		JSONObject o = new JSONObject();
		o.put("response", "ok");
		return o.toString();
	}
}
