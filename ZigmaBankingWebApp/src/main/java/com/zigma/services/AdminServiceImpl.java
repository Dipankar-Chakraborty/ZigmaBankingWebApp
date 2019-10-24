package com.zigma.services;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zigma.daos.AdminDao;
import com.zigma.daos.AdminDaoImpl;
import com.zigma.entities.Admin;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;

	public AdminServiceImpl() {
		// TODO Auto-generated constructor stub
		adminDao = new AdminDaoImpl();
	}

	@Override
	public Admin findAdminById(long adminId) {
		// TODO Auto-generated method stub
		return adminDao.findAdminById(adminId);
	}

	@Override
	public boolean isExistBeneficiary(String ifsc, long beneficiaryId) {
		// TODO Auto-generated method stub
		if(ifsc!=null && beneficiaryId!=0) {
		return false;
	}
		else
			return true;
	}



	@Override
	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminDao.update(admin);
	}

	

}
