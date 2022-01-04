package com.stockmanaging.stockmanaging.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="employee")
@Entity
@Data
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	
	private String name;
	
	private String mail;
	
	private String phone;
	
	private String picture;
	
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;

	public Employee(String name, String mail, String phone, String picture) {
		super();
		this.name = name;
		this.mail = mail;
		this.phone = phone;
		this.picture = picture;
	}
	
	
}
