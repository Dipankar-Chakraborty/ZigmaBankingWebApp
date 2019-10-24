package com.zigma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zigma.daos.LoginDao;
import com.zigma.daos.LoginDaoImpl;
import com.zigma.entities.Login;
@Service
@Transactional
public class LoginServiceImpl implements LoginService {
@Autowired
	private LoginDao loginDao;

	public LoginServiceImpl() {
		loginDao = new LoginDaoImpl();
	}

	@Override
	public List<Login> findAllLogin() {
		return loginDao.getAll();
	}

	@Override
	public Login findLoginById(long crn) {
		Login login = loginDao.getById(crn);
		return login;
	}

	@Override
	public void addLogin(Login login) {
		loginDao.insert(login);
	}

	@Override
	public void updateLogin(Login login) {
		loginDao.update(login);

	}

}
