package com.zigma.entities;

/**
 * @author Dipankar Chakraborty
 * @creation_date 5th Oct 2019 6:00PM
 * @modification_date 5th Oct 2019 6:00PM
 * @version 1.0
 * @copyright Zensar Technologies.All rights reserved
 * @description It is a POJO Class.
 */

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long accountNo;
	private LocalDateTime date;
	private double totalBalance;
	private String accountType; //to be modified

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "crn")
	private Customer customer;
	@OneToMany(mappedBy = "account")
	private List<Beneficiary> beneficiary;
	@OneToMany(mappedBy = "account")
	private List<Transaction> transaction;

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getTotalBalance() {
		return totalBalance;
	}

	public double setTotalBalance(double totalBalance) {
		return this.totalBalance = totalBalance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public List<Beneficiary> getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(List<Beneficiary> beneficiary) {
		this.beneficiary = beneficiary;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", date=" + date + ", totalBalance=" + totalBalance
				+ ", accountType=" + accountType + ", customer=" + customer + ", beneficiary=" + beneficiary
				+ ", transaction=" + transaction + "]";
	}
}
