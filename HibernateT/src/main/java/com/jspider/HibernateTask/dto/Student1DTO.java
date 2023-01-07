package com.jspider.HibernateTask.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student1DTO {
	@Id
	private String name;

	private int rollNo;

	private String email;
}
