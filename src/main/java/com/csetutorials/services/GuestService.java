package com.csetutorials.services;

import com.csetutorials.exceptions.AuthorizationException;
import com.csetutorials.models.GuestPermission;
import com.csetutorials.models.QDataRequest;
import com.csetutorials.models.QGuestPermission;
import com.csetutorials.repositories.GuestPermissionRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GuestService {

	@Autowired
	GuestPermissionRepository guestPermissionRepository;

	@Autowired
	AdminService adminService;

	@Autowired
	JPAQueryFactory queryFactory;
	QGuestPermission guestPermission = QGuestPermission.guestPermission;
	QDataRequest dataRequest = QDataRequest.dataRequest;

	public void addGuest(long adminId, long guestId, long tableId, String permissions) {
		if (!adminService.isAdmin(adminId, tableId)) {
			throw new AuthorizationException("You are not allowed to add guest");
		}
		GuestPermission permission = new GuestPermission();
		permission.setUserId(guestId);
		permission.setTableId(tableId);
		permission.setPermissions(permissions);
		guestPermissionRepository.save(permission);
	}

	public void removeGuest(long adminId, long guestId, long tableId) {
		if (!adminService.isAdmin(adminId, tableId)) {
			throw new AuthorizationException("You are not allowed to add guest");
		}
		// removing user from guest
		queryFactory
			.delete(guestPermission)
			.where(guestPermission.userId.eq(guestId)
				.and(guestPermission.tableId.eq(tableId)))
			.execute();
		// removing data requests created by user
		queryFactory
			.delete(dataRequest)
			.where(dataRequest.userId.eq(guestId)
				.and(dataRequest.tableId.eq(tableId)))
			.execute();
	}

	public void updateGuestPermissions(long adminId, long guestId, long tableId, String permissions) {
		if (!adminService.isAdmin(adminId, tableId)) {
			throw new AuthorizationException("You are not allowed to update guest permissions");
		}
		/*-Need to convert this function
		function isPermissionValid($permissions) {
		if (!$permissions) {
				return false;
		}
		foreach ($permissions as $key => $value) {
				if ($key != "read" && $key != "add" && $key != "update" &&
						$key != "delete") {
						return false;
				}
				foreach ($value as $subKey => $subValue) {
						if ($subKey != "allowed" && $subKey != "approval" &&
								$subKey != "loginRequired") {
								return false;
						}
						if (gettype($subValue) != "boolean") {
								return false;
						}
				}
		}
		return true;
	}

		 */
		queryFactory
			.update(guestPermission)
			.set(guestPermission.permissions, permissions)
			.where(guestPermission.userId.eq(guestId)
				.and(guestPermission.tableId.eq(tableId)))
			.execute();
	}

}
