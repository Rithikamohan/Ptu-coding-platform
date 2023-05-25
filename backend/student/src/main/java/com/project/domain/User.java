package com.project.domain;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.PrePersist;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_user")
public class User extends Auditable<String> implements Serializable{
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String mobile;
	@Column(nullable = false)
	private String password;
	@Column 
	private String lastlogindate; 
	@Column 
	private String faculty; 
	@Column(nullable = true)
	private int points;
	@Column(nullable = true)
	private int c;
	@Column(nullable = true)
	private int cplus;
	@Column(nullable = true)
	private int python;

	@Column(nullable = true)
	private int cbasic;
	@Column(nullable = true)
	private int cinter;
	@Column(nullable = true)
	private int cadv;
	
	@Column(nullable = true)
	private int cpbasic;
	@Column(nullable = true)
	private int cpinter;
	@Column(nullable = true)
	private int cpadv;
	
	@Column(nullable = true)
	private int pybasic;
	@Column(nullable = true)
	private int pyinter;
	@Column(nullable = true)
	private int pyadv;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String regno) {
		this.mobile = regno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastlogindate() {
		return lastlogindate;
	}

	public void setLastlogindate(String lastlogindate) {
		this.lastlogindate = lastlogindate;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@PrePersist
    public void prePersist() {
        this.points = 0;
        this.c=0;
        this.cplus=0;
        this.python=0;
        
        this.cbasic=0;
        this.cinter=0; 
        this.cadv=0;
        this.cpbasic=0;
        this.cpinter=0;
        this.cpadv=0;
    }

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getCplus() {
		return cplus;
	}

	public void setCplus(int cplus) {
		this.cplus = cplus;
	}

	public int getPython() {
		return python;
	}

	public void setPython(int python) {
		this.python = python;
	}

	public int getCbasic() {
		return cbasic;
	}

	public void setCbasic(int cbasic) {
		this.cbasic = cbasic;
	}

	public int getCinter() {
		return cinter;
	}

	public void setCinter(int cinter) {
		this.cinter = cinter;
	}

	public int getCadv() {
		return cadv;
	}

	public void setCadv(int cadv) {
		this.cadv = cadv;
	}

	public int getCpbasic() {
		return cpbasic;
	}

	public void setCpbasic(int cpbasic) {
		this.cpbasic = cpbasic;
	}

	public int getCpinter() {
		return cpinter;
	}

	public void setCpinter(int cpinter) {
		this.cpinter = cpinter;
	}

	public int getCpadv() {
		return cpadv;
	}

	public void setCpadv(int cpadv) {
		this.cpadv = cpadv;
	}

	public int getPybasic() {
		return pybasic;
	}

	public void setPybasic(int pybasic) {
		this.pybasic = pybasic;
	}

	public int getPyinter() {
		return pyinter;
	}

	public void setPyinter(int pyinter) {
		this.pyinter = pyinter;
	}

	public int getPyadv() {
		return pyadv;
	}

	public void setPyadv(int pyadv) {
		this.pyadv = pyadv;
	}


}