package com.project.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.model.Cplus;
import com.project.service.CodeService;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/cplus")
public class CplusController {

	@Autowired
	private CodeService empService;

	@PostMapping("/save")
	public ResponseEntity<Cplus> createEmp(@RequestBody Cplus emp) {
		return new ResponseEntity<Cplus>(empService.createcplus(emp), HttpStatus.CREATED);
	}

	@GetMapping("/allcode")
	public ResponseEntity<List<Cplus>> getAllEmp() {
		return new ResponseEntity<List<Cplus>>(empService.getAllCplus(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cplus> getEmpById(@PathVariable int id) {
		return new ResponseEntity<Cplus>(empService.getcplusById(id), HttpStatus.OK);
	}
	
}

	
