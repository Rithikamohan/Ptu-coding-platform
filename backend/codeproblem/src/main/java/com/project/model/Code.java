package com.project.model;
import javax.persistence.Table;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "code")

public class Code 
{
@Id
@GeneratedValue
private int id;

private String Codetype;

private String question;

private String testcase1;
 }