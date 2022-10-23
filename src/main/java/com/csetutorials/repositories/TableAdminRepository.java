package com.csetutorials.repositories;

import com.csetutorials.models.TableAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableAdminRepository extends JpaRepository<TableAdmin, Long> {

}