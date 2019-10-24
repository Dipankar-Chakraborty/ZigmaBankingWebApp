package com.zigma.daos;

import java.util.List;



import com.zigma.entities.Beneficiary;

/**
 * @author Arib Anwar
 * @creation_date 4th Oct 2019 10:07
 * @modificationDate 10th Oct 2019 16:00
 * @version 3.0
 * @copyright Zensar Tech
 * @description It is Beneficiary Dao Interface
 *				This uses persistent Layer.
 *
 */
public interface BeneficiaryDao {
	List<Beneficiary> getAllBeneficiary();
	
	Beneficiary getBeneficiaryByAccountNo(long beneficiaryAccNo);
	
	
	void insert(Beneficiary beneficiary);
	
}

