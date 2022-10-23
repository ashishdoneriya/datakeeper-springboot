package com.csetutorials.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue
	Long userId;

	@Column(nullable = false)
	String name;

	@Column(nullable = false)
	String email;

	@Column(nullable = false)
	String password;

}
