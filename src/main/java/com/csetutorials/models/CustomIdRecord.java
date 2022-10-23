package com.csetutorials.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customIdRecords")
@Getter
@Setter
public class CustomIdRecord {

	@Id
	String rowId;

	@Column(nullable = false, columnDefinition = "json")
	String fields;

	@Column(nullable = false)
	Long tableId;

}
