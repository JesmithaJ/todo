package com.ibm.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

	@Id
	@GeneratedValue
	private int id;
	
	@Size(min = 5, max = 100, message = "Description must be b/w 5-100")
	private String description;
	
	private LocalDate targetDate;
	
	@NotBlank (message = "User name can't be empty!")
	@NotNull (message = "User name can't be null!")
	private String user;
	
	private boolean done;
}

