package com.csetutorials.repositories;

import com.csetutorials.models.DataRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRequestRepository extends JpaRepository<DataRequest, Long> {

}