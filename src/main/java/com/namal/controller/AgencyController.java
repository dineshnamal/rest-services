package com.namal.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.namal.agency.model.Consultant;
import com.namal.dao.ConsultantDaoService;
import com.namal.exception.UserNotFoundException;

/**
 * Operations - GetConsultants - http://localhost:8080/consultants - by id -
 * http://localhost:8080/consultants/3
 * 
 * 
 * @author Namal Dinesh
 *
 */

@RestController
public class AgencyController {
	@Autowired
	private ConsultantDaoService consultantDaoService;

	@GetMapping("/consultants")
	public List<Consultant> getConsultants() {
		return consultantDaoService.findAll();
	}

	@GetMapping("/consultants/{id}")
	public Consultant getConsultant(@PathVariable Integer id) {
		Consultant consultant = consultantDaoService.findOne(id);
		if (consultant == null) {
			throw new UserNotFoundException("id " + id);
		}
		return consultant;
	}

	@PostMapping("/consultants")
	public ResponseEntity<Object> saveConsultant(@RequestBody Consultant consultant) {
		Consultant savedConsultant = consultantDaoService.save(consultant);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedConsultant.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

}
