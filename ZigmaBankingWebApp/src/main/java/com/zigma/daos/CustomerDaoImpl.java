package com.zigma.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zigma.entities.Customer;

/**
 * @author Arib
 * @creation_date 4th Oct 2019 10:23
 * @modificationDate 21thOct 2019 10:09
 * @version 1.0
 * @copyright Zensar Tech
 * @description It is Product Dao Class.
 * 				This uses persistent Layer.
 */

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return (List<Customer>) hibernateTemplate.find("from Customer");
	}

	@Override
	public Customer getCrn(long crn) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Customer.class, crn);
	}


	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(customer);
	}

	@Override
	public void delete(Customer customer) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(customer);
	}
	


}
