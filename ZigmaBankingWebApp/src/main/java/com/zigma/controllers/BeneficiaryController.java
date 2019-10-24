package com.zigma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zigma.entities.Beneficiary;
import com.zigma.services.BeneficiaryService;

/**
 * @author Arib 
 * @creation_date 12th Oct 2019 15:44
 * @modification_date 21th Oct 2019 17:44
 * @version 1.0
 * @copyright Zensar Tech
 * @description This is a RESTful Webservice.
 */

@RestController
public class BeneficiaryController {
@Autowired
	private BeneficiaryService beneficiaryService;
	@GetMapping("/beneficiary")
	public List<Beneficiary> getAllBeneficiary(){
		
		return beneficiaryService.findAllBeneficiary();
	}
	
	
	@GetMapping("/beneficiary/{id}")
	public Beneficiary getBeneficiary(@PathVariable("id")long beneficiaryAccNo) {
		return beneficiaryService.findBeneficiaryByAccountNo(beneficiaryAccNo);
	}
	
	@PostMapping("/beneficiary/add")
	public String addBeneficiary(@RequestBody Beneficiary beneficiary) {
		beneficiaryService.addBeneficiary(beneficiary);
	return "New Beneficiary added "+beneficiary.getBeneficiaryId()+" is added!";
	}
}