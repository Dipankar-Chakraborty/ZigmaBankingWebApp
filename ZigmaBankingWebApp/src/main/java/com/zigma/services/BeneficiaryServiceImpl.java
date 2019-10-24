package com.zigma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zigma.daos.BeneficiaryDao;
import com.zigma.entities.Beneficiary;

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
public class BeneficiaryServiceImpl implements BeneficiaryService {
	@Autowired
	private BeneficiaryDao beneficiaryDao;

	@Override
	public List<Beneficiary> findAllBeneficiary() {

		return beneficiaryDao.getAllBeneficiary();
	}

	@Override
	public Beneficiary findBeneficiaryByAccountNo(long beneficiaryAccNo) {

		return beneficiaryDao.getBeneficiaryByAccountNo(beneficiaryAccNo);
	}
	
	@Override
	public void addBeneficiary(Beneficiary beneficiary) {
		beneficiaryDao.insert(beneficiary);

	}
	@Override
	public boolean beneficiaryExists(Beneficiary beneficiary) {
		// TODO Auto-generated method stub
		if(beneficiary.getBeneficiaryAccNo() !=0) {
			return true;
		}
		else
			return false;	
	}


}
