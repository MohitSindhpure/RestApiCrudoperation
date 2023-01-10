package com.BikkadIT.RestApiCrudoperation.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.sound.midi.Soundbank;

import org.apache.el.parser.AstFalse;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.descriptor.sql.JdbcTypeFamilyInformation.Family;

import lombok.Data;

@Entity
@Data
public class Employee { 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	
	private String empName;
	
	private String empAddress;
	
	private String empEmail;
	
	private Double empsal;
	
	private int empAge;
	

	
	
	@Column(name = "Create_Date",updatable = false)
	@CreationTimestamp
	private LocalDateTime createDate;
	
	@Column(name = "Update_Date",insertable = false)
	@UpdateTimestamp
	private LocalDateTime updateDate;
	

	
	
}
