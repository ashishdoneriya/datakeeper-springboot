package com.csetutorials.services;

import com.csetutorials.exceptions.AuthorizationException;
import com.csetutorials.models.QTableAdmin;
import com.csetutorials.models.QUser;
import com.csetutorials.models.TableAdmin;
import com.csetutorials.models.User;
import com.csetutorials.repositories.TableAdminRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminService {

	@Autowired
	TableAdminRepository tableAdminRepository;

	@Autowired
	JPAQueryFactory queryFactory;

	QTableAdmin tableAdmin = QTableAdmin.tableAdmin;
	QUser user = QUser.user;

	public boolean isAdmin(long userId, long tableId) {
		List<TableAdmin> list = queryFactory
			.selectFrom(tableAdmin)
			.where(tableAdmin.userId.eq(userId)
				.and(tableAdmin.tableId.eq(tableId)))
			.limit(1)
			.fetch();
		return list != null && !list.isEmpty();
	}

	public void addAdmin(long currentAdminId, long userToAddAsAdminId, long tableId) {
		if (!isAdmin(currentAdminId, tableId)) {
			throw new AuthorizationException("You don't have sufficient permission to add a admin for this table");
		}
		TableAdmin tableAdmin = new TableAdmin();
		tableAdmin.setUserId(userToAddAsAdminId);
		tableAdmin.setTableId(tableId);
		tableAdmin.setOwner(false);
		this.tableAdminRepository.save(tableAdmin);
	}

	public List<User> getAdmins(long currentAdminId, long tableId) {
		if (!isAdmin(currentAdminId, tableId)) {
			throw new AuthorizationException("You don't have sufficient permission to see admins list for this table");
		}
		return queryFactory
			.selectFrom(user)
			.innerJoin(tableAdmin)
			.on(user.userId.eq(tableAdmin.tableId)
				.and(tableAdmin.tableId.eq(tableId)))
			.fetch();
	}

	public void removeAdmin(long tableOwnerId, long adminToRemoveId, long tableId) {
		if (!isOwnerOfTable(tableOwnerId, tableId)) {
			throw new AuthorizationException("You cannot remove admin as you are not the owner of the table");
		}
		if (tableOwnerId == adminToRemoveId) {
			if (hasMultipleAdmins(tableId)) {
				throw new AuthorizationException(
					"You cannot remove yourself from this table's admin list unless you make someone else as owner of this table");
			} else {
				throw new AuthorizationException("You cannot remove yourself from this table because you are the owner."
					+ " Instead of that, just directly delete the table");
			}
		}
		queryFactory
			.delete(tableAdmin)
			.where(tableAdmin.userId.eq(adminToRemoveId)
				.and(tableAdmin.tableId.eq(tableId)))
			.execute();
	}

	private boolean isOwnerOfTable(long tableOwnerId, long tableId) {
		return queryFactory
			.selectFrom(tableAdmin)
			.where(tableAdmin.userId.eq(tableOwnerId)
				.and(tableAdmin.tableId.eq(tableId))
				.and(tableAdmin.isOwner.eq(true)))
			.fetchFirst() != null;
	}

	private boolean hasMultipleAdmins(long tableId) {
		return queryFactory
			.selectFrom(tableAdmin)
			.where(tableAdmin.tableId.eq(tableId)
				.and(tableAdmin.isOwner.eq(false)))
			.limit(1)
			.fetchFirst() != null;
	}


}
