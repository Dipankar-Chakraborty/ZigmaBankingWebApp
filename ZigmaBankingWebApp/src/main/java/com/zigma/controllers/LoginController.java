package com.zigma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zigma.entities.Admin;
import com.zigma.entities.Customer;
import com.zigma.entities.Login;
import com.zigma.services.AdminService;
import com.zigma.services.CustomerService;
import com.zigma.services.LoginService;

@RestController
public class LoginController {
@Autowired
	private CustomerService customerService;
@Autowired
	private AdminService adminService;
	@Autowired
	private LoginService loginService;

	@GetMapping("/log/{id}")
	public Login findLoginById(@PathVariable("id")long crn) {
		return loginService.findLoginById(crn);
	}

	@PostMapping("/log/addcustomer/{crn}")
	public String addCustomer(@RequestBody Login login,@PathVariable("crn") long crn) {
		
		loginService.addLogin(login);
		Login log = loginService.findLoginById(login.getId());
		Customer cust =customerService.findCustomerById(crn);
		log.setCustomer(cust);
		loginService.updateLogin(log);
		System.out.println(login);
		return "new customer logged in: " + login.getId();

	}
	@PostMapping("/log/addadmin/{adminId}")
	public String addAdmin(@RequestBody Login login,@PathVariable("adminId") long id) {
		loginService.addLogin(login);
		Login log = loginService.findLoginById(login.getId());
		Admin admin= adminService.findAdminById(id);
		log.setAdmin(admin);
		loginService.updateLogin(log);
		System.out.println(login);
		return "admin logged in " + login.getId();
	}

	@PostMapping("/log/update")
	public String update(Login login) {
		if (loginService.findLoginById(login.getId()) != null) {
			loginService.updateLogin(login);

			return "login updated successfuly :" + login.getId();
		} else {
			return "login unsuccessful!";
		}
	}
}
