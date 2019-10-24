package com.zigma.daos;

import java.util.List;

import com.zigma.entities.Customer;

/**
 * @author Arib
 * @creation_date 4th Oct 2019 10:07
 * @modificationDate 20th Oct 2019 16:00
 * @version 3.0
 * @copyright Zensar Tech
 * @description It is Product Dao Interface
 *				This uses persistent Layer.
 *
 */
public interface CustomerDao {
	 List<Customer> getAllCustomer();
	Customer getCrn(long crn);
	void update(Customer customer);
	void delete(Customer customer);
	
}

