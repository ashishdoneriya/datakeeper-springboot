package com.csetutorials.models;

import com.csetutorials.models.beans.RequestType;
import com.csetutorials.models.beans.UserIdTableIdKey;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dataRequests")
@IdClass(UserIdTableIdKey.class)
@Getter
@Setter
public class DataRequest {

	@Id
	@GeneratedValue
	Long reqId;

	@Column(nullable = false)
	Long userId;

	@Column(nullable = false)
	Long tableId;

	@Column(nullable = false)
	RequestType requestType;

	@Column(nullable = false)
	Long rowId;

	@Column(nullable = false, columnDefinition = "json")
	String fields;

}
