package com.csetutorials.repositories;

import com.csetutorials.models.GuestPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestPermissionRepository extends JpaRepository<GuestPermission, Long> {

}