package com.zigma.daos;

import java.util.List;
import com.zigma.entities.Account;
import com.zigma.entities.Admin;

public interface AdminDao {

    public List<Account> getAllPendingAuthorization(long crn);
	public List<Account> getAllCompleteAuthorization(long crn);

	Admin findAdminById(long adminId);
	void update(Admin admin);


}
