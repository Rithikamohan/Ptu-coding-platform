package com.project.service;

import java.util.List;

import com.project.model.Code;
import com.project.model.Cplus;
import com.project.model.Pycode;

public interface CodeService {

public Code getCodeById(int id);
public Cplus getcplusById(int id);
public Pycode getpyById(int id);

	public Code createEmp(Code emp);
	public Cplus createcplus(Cplus icode);
	public Pycode createpy(Pycode icode);

	public List<Code> getAllEmp();
	public List<Cplus> getAllCplus();

	public List<Pycode> getAllPy();

}
