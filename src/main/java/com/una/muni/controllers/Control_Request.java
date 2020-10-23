package com.una.muni.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.una.muni.entitys.t_requests;
import com.una.muni.model.TRequest;
import com.una.muni.model.TRequirement;
import com.una.muni.repository.t_requestsRepository;

// @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(value = "t_requests/"/*, consumes = MediaType.ALL_VALUE*/)
public class Control_Request {
	@Autowired
	private t_requestsRepository repo;

	// @PostMapping(value = "validate")
	// public ResponseEntity<t_requests> validate(@ModelAttribute t_requests
	// t_request ) {
	// Optional<t_requests> req = repo.findById(t_request .getRequest_id());
	// if (req.isPresent()) {
	// return new ResponseEntity<t_requests>(repo.findById(t_request
	// .getRequest_id()).get(), HttpStatus.OK);
	// } else {
	// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// }
	// }

	@PostMapping(value = "listar")
	public List<TRequest> listar() {
		List<TRequest> list = new ArrayList<>();
		var ite = repo.findAll();
		ite.forEach(e -> list.add(e));
		return list;
	}

	// @PostMapping(value = "delete")
	// public ResponseEntity<Object> delete(@ModelAttribute t_requests r) {
	// repo.deleteById(r.getRequest_id());
	// if (repo.findById(r.getRequest_id()).isEmpty()) {
	// return new ResponseEntity<>(HttpStatus.OK);
	// } else {
	// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// }
	// }

	@PostMapping(value = "insert")
	public String insert(@RequestParam(name = "title") String title_proc,
			@RequestParam(name = "description") String desc_proc, @RequestParam(name = "TRequirements") String lista) {
		JSONArray list = new JSONArray(lista);
		List<TRequirement> requirements = new ArrayList<>();
		for (int i = 0; i < list.length(); i++) {
			JSONObject jo = list.getJSONObject(i);
			int requirementId = jo.getInt("requirementId");
			String title = jo.getString("title");
			String description = jo.getString("description");
			TRequirement tr = new TRequirement();
			tr.setRequirementId(requirementId);
			tr.setTitle(title);
			tr.setDescription(description);
			requirements.add(tr);
		}
		TRequest rqst = new TRequest();
		rqst.setTitle(title_proc);
		rqst.setDescription(desc_proc);
		rqst.setTRequirements(new HashSet<TRequirement>(requirements));
		repo.save(rqst);
		return new JSONObject().put("resp", "ok").toString();
	}

	@PostMapping(value = "update")
	public String update(@RequestParam(name = "idprocess") String idproc,@RequestParam(name = "title") String title_proc,
			@RequestParam(name = "description") String desc_proc, @RequestParam(name = "TRequirements") String lista) {
		JSONArray list = new JSONArray(lista);
		List<TRequirement> requirements = new ArrayList<>();
		for (int i = 0; i < list.length(); i++) {
			JSONObject jo = list.getJSONObject(i);
			int requirementId = jo.getInt("requirementId");
			String title = jo.getString("title");
			String description = jo.getString("description");
			TRequirement tr = new TRequirement();
			tr.setRequirementId(requirementId);
			tr.setTitle(title);
			tr.setDescription(description);
			requirements.add(tr);
		}
		TRequest rqst = new TRequest();
		rqst.setRequestId(Integer.parseInt(idproc));
		rqst.setTitle(title_proc);
		rqst.setDescription(desc_proc);
		rqst.setTRequirements(new HashSet<TRequirement>(requirements));
		repo.save(rqst);
		return new JSONObject().put("resp", "ok").toString();
	}
}
