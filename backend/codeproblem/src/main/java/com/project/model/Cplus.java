package com.project.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Data;
@Entity
@Data
public class Cplus 
{

@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)

private int id;
private String Codetype;
private String question;
private String testcase;

	  }