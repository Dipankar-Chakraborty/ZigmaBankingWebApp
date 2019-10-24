package com.zigma.services;

import java.util.List;

import com.zigma.entities.Beneficiary;

/**
 * @author Arib
 * @creation_date 4th Oct 2019 11:39
 * @creation_date 20th Oct 2019 17:39
 * @version 3.0
 * @copyright Zensar Tech
 * @description It is Product Service Class This is used in Business Layer.
 *
 */
public interface BeneficiaryService {
	List<Beneficiary> findAllBeneficiary();
	
	Beneficiary findBeneficiaryById(int beneficiaryId);
	
	void addBeneficiary(Beneficiary beneficiary);
	boolean beneficiaryExists(Beneficiary beneficiary);

}
