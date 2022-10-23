package com.csetutorials.repositories;

import com.csetutorials.models.CustomIdRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomIdRocordRepository extends JpaRepository<CustomIdRecord, String> {

}