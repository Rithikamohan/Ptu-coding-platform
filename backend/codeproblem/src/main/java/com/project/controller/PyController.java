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
import com.project.model.Pycode;
import com.project.service.CodeService;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/py")
public class PyController {

	@Autowired
	private CodeService empService;

	@PostMapping("/save")
	public ResponseEntity<Pycode> createEmp(@RequestBody Pycode emp) {
		return new ResponseEntity<Pycode>(empService.createpy(emp), HttpStatus.CREATED);
	}

	@GetMapping("/allcode")
	public ResponseEntity<List<Pycode>> getAllEmp() {
		return new ResponseEntity<List<Pycode>>(empService.getAllPy(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pycode> getEmpById(@PathVariable int id) {
		return new ResponseEntity<Pycode>(empService.getpyById(id), HttpStatus.OK);
	}
	
}

	
