package com.zigma.daos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.zigma.entities.Beneficiary;

/**
 * @author Arib
 * @creation_date 4th Oct 2019 10:23
 * @modificationDate 19thOct 2019 10:09
 * @version 2.0
 * @copyright Zensar Tech
 * @description It is Beneficiary Dao Class. This uses persistent Layer.
 *
 */
@Repository
public class BeneficiaryDaoImpl implements BeneficiaryDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<Beneficiary> getAllBeneficiary() {
		// TODO Auto-generated method stub
		return (List<Beneficiary>) hibernateTemplate.find("from Beneficiary");
	}

	@Override
	public Beneficiary getBeneficiaryById(int beneficiaryId) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Beneficiary.class, beneficiaryId);
	}

	@Override
	public void insert(Beneficiary beneficiary) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(beneficiary);
	}

}
