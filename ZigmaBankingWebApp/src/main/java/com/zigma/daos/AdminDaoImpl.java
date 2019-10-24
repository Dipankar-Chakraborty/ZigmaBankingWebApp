package com.zigma.daos;

/**
 * @author Dipankar Chakraborty
 * @creation_date 5th Oct 2019 6:00PM
 * @modification_date 5th Oct 2019 6:00PM
 * @version 1.0
 * @copyright Zensar Technologies.All rights reserved
 * @description It is a Dao Interface and used in persistence layer.
 */

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.zigma.entities.Account;
import com.zigma.entities.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public Admin findAdminById(long adminId) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Admin.class, adminId);
	}

	public void update(Admin admin) {
		hibernateTemplate.update(admin);
	}
	
	@Override
	public List<Account> getAllPendingAuthorization(long crn) {
		// TODO Auto-generated method stub
		return (List<Account>) hibernateTemplate.find("from Account");
	}

	@Override
	public List<Account> getAllCompleteAuthorization(long crn) {
		// TODO Auto-generated method stub
		return (List<Account>) hibernateTemplate.find("from Account");
	}
}
