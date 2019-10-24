package com.zigma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zigma.entities.Admin;
import com.zigma.services.AdminService;

@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/admin/{adminId}")
	public Admin findAdminById(@PathVariable("adminId")long adminId)
	{
		return adminService.findAdminById(adminId);
	}
	
	@PutMapping("/admin/update")
	public String updateAdmin(Admin admin)
	{
		if (adminService.findAdminById(admin.getAdminId())!=null){
			adminService.updateAdmin(admin);
			return "admin is updated Successfully";
			}
			else return "Sorry! admin not found";
	}
	
}
