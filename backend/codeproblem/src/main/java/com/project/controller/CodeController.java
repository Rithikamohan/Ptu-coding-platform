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

import com.project.model.Code;
import com.project.service.CodeService;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/codec")
public class CodeController {

	@Autowired
	private CodeService empService;

	@PostMapping("/save")
	public ResponseEntity<Code> createEmp(@RequestBody Code emp) {
		return new ResponseEntity<Code>(empService.createEmp(emp), HttpStatus.CREATED);
	}

	@GetMapping("/allcode")
	public ResponseEntity<List<Code>> getAllEmp() {
		return new ResponseEntity<List<Code>>(empService.getAllEmp(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Code> getEmpById(@PathVariable int id) {
		return new ResponseEntity<Code>(empService.getCodeById(id), HttpStatus.OK);
	}
	
}

	
