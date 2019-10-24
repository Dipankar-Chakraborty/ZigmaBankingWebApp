package com.zigma.services;

import com.zigma.entities.Admin;

public interface AdminService {

	Admin findAdminById(long adminId);

	public boolean isExistBeneficiary(String crn, long beneficiaryId);

	void updateAdmin(Admin admin);
}
