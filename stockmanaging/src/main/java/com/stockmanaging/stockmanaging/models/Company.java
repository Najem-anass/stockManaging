package com.stockmanaging.stockmanaging.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "company")
@Data
@NoArgsConstructor
public class Company implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	private String mail;

	private String picture;

	private String phone;

	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "company")
	private List<Employee> employees;

	public Company(String name, String mail, String picture, String phone, String description) {
		super();
		this.name = name;
		this.mail = mail;
		this.picture = picture;
		this.phone = phone;
		this.description = description;
	}

	public Company(String name, String mail, String picture, String phone, String description,
			List<Employee> employees) {
		super();
		this.name = name;
		this.mail = mail;
		this.picture = picture;
		this.phone = phone;
		this.description = description;
		this.employees = employees;
	}
	
	
	
	
}
