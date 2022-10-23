package com.csetutorials.models;

import com.csetutorials.models.beans.UserIdTableIdKey;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tableAdmins")
@IdClass(UserIdTableIdKey.class)
@Getter
@Setter
public class TableAdmin {

	@Id
	Long userId;

	@Id
	Long tableId;

	@Column(nullable = false)
	boolean isOwner;

}
