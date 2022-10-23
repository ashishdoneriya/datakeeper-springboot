package com.csetutorials.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tablesInfo")
@Getter
@Setter
public class TableInfo {

	@Id
	@GeneratedValue
	Long tableId;

	@Column(nullable = false)
	String tableName;

	@Column(nullable = false, columnDefinition = "json")
	String fields;

	@Column(nullable = false, columnDefinition = "json")
	String publicPermissions;

}
