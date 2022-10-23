package com.csetutorials.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "autoGeneratedIdRecords")
@Getter
@Setter
public class AutoGeneratedIdRecord {

	@Id
	@GeneratedValue
	Long rowId;

	@Column(nullable = false, columnDefinition = "json")
	String fields;

	@Column(nullable = false)
	Long tableId;

}