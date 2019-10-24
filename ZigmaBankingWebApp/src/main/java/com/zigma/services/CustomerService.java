package com.zigma.services;

import java.time.LocalDateTime;
import java.util.List;

import com.zigma.entities.Customer;

/**
 * @author Arib
 * @creation_date 4th Oct 2019 11:39
 * @creation_date 20th Oct 2019 17:39
 * @version 3.0
 * @copyright Zensar Tech
 * @description It is Product Service Class This is used in Business Layer.
 *
 */
public interface CustomerService {
	List<Customer> findAllCustomers();

	Customer findCustomerById(long crn);

	void updateCustomer(Customer customer);


	// Any other Business Logic
	// Examples:
	List<Customer> findCustomerByTimeRange(LocalDateTime minTime, LocalDateTime  maxTime);

	List<Customer> findCustomerByName(String name);

	List<Customer> findProductsByEmail(String email);

	long getCustomerCount();// returns count of Customer in table.
}
