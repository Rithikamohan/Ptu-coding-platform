package com.project.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Code;
import com.project.model.Cplus;
import com.project.respository.*;

@Service
public class CodeServiceimpl implements CodeService {

	@Autowired
	private CodeRepository empRepo;
	@Autowired
	private CplusRepository cplusRepo;
	@Override
	public Code createEmp(Code emp) {
		return empRepo.save(emp);
	}

	
	@Override
	public Code getCodeById(int id) {
		return empRepo.findById(id).get();
	}


	@Override
	public List<Code> getAllEmp() {
		return empRepo.findAll();
	}


	@Override
	public Cplus getcplusById(int id) {
		return cplusRepo.findById(id).get();
	}


	@Override
	public Cplus createcplus(Cplus icode) {
		return cplusRepo.save(icode);
	}


	@Override
	public List<Cplus> getAllCplus() {
		return cplusRepo.findAll();
	}

}
