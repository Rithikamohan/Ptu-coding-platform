package com.project.model;
import javax.persistence.Table;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import lombok.Data;
@Entity
@Data
public class Cplus 
{

@Id
@GeneratedValue

private int id;
private String Codetype;
private String question;
private String testcase;

	  }