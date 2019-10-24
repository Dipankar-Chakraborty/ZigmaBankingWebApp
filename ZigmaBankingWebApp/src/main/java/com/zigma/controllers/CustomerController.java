package com.zigma.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.zigma.entities.Customer;
import com.zigma.services.CustomerService;
/**
 * @author Arib Anwar
 * @creation_date 12th Oct 2019 15:44
 * @modification_date 21th Oct 2019 17:44
 * @version 1.0
 * @copyright Zensar Tech
 * @description This is a RESTful Webservice.
 */

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@GetMapping("/customers")
	List<Customer> findAllCustomers(){
		
		return customerService.findAllCustomers();
	}
	
	@GetMapping("/customers/{crn}")
	public Customer getCustomer(@PathVariable("crn")long crn) {
		return customerService.findCustomerById(crn);
	}
	 @PutMapping("/customers/update")
	public String updateCustomer(@RequestBody Customer customer) {
		if (customerService.findCustomerById(customer.getCrn())!=null){
		customerService.updateCustomer(customer);
		return "Customer is updated Successfully";
		}
		else return "Sorry! Customer not found";
	}
}