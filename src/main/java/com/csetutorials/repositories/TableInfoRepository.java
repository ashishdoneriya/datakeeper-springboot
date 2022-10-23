package com.csetutorials.repositories;

import com.csetutorials.models.TableInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableInfoRepository extends JpaRepository<TableInfo, Long> {

}