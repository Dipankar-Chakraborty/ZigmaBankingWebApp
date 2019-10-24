package com.zigma.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zigma.daos.CustomerDao;
import com.zigma.entities.Customer;

/**
 * @author Arib
 * @creation_date 4th Oct 2019 11:39
 * @modification_date 20th Oct 2019 17:39
 * @version 3.0
 * @copyright Zensar Tech
 * @description It is Customer Service Class This is used in Business Layer.
 *				Creating customerDao Object by Spring and injecting in ProductServiceImpl
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;
	@Override
	public List<Customer> findAllCustomers() {
		// TODO Auto-generated method stub
		return customerDao.getAllCustomer();
	}

	@Override
	public Customer findCustomerById(long crn) {
		// TODO Auto-generated method stub
		return customerDao.getCrn(crn);
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.update(customer);
	}

	@Override
	public List<Customer> findCustomerByTimeRange(LocalDateTime minTime, LocalDateTime  maxTime) {
		List<Customer> myList = new ArrayList<>();
		List<Customer> allCustomer = customerDao.getAllCustomer();
		for (Customer i : allCustomer) {
			//if (i.getLogoutTime() > minTime && i.getLogoutTime() < minTime)
				myList.add(i);
		}
		return myList;
	}

	@Override
	public List<Customer> findCustomerByName(String name) {
		List<Customer> myList = new ArrayList<>();
		List<Customer> allCustomer = customerDao.getAllCustomer();

		for (Customer i : allCustomer) {
			if (i.getName().equalsIgnoreCase(name))
				myList.add(i);
		}
		return myList;
	}

	@Override
	public List<Customer> findProductsByEmail(String emailId) {
		List<Customer> myList = new ArrayList<>();
		List<Customer> allCustomer = customerDao.getAllCustomer();
		for (Customer i : allCustomer) {
			if (i.getEmailId().equalsIgnoreCase(emailId))
				myList.add(i);
		}
		return myList;
	}

	@Override
	public long getCustomerCount() {
		// TODO Auto-generated method stub
		int count = 0;
		List<Customer> allCustomer = customerDao.getAllCustomer();
		for (Customer i : allCustomer) {
			count++;
		}
		return count;
	}


}
