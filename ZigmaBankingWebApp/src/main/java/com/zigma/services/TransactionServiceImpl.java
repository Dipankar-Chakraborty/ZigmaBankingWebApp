package com.zigma.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zigma.entities.Account;
import com.zigma.entities.Beneficiary;
import com.zigma.exceptions.AccountNotFoundException;
import com.zigma.exceptions.InSufficientFundsException;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
	private AccountService accountService;
	private BeneficiaryService beneficiaryService;

	@Override
	public double showBalance(Account account) throws AccountNotFoundException

	{ // TODO Auto-generated method stub
		if (accountService.accountExists(account)) {
			return account.getTotalBalance();

		} else {
			throw new AccountNotFoundException(account.getAccountNo());
		}
	}

	@Override
	public double transferFunds(Account account, Beneficiary beneficiary, double transferAmount)
			throws AccountNotFoundException, InSufficientFundsException {
		// TODO Auto-generated method stub
		double sourceBalance = account.getTotalBalance();
		double targetBalance;
		if (accountService.accountExists(account) && beneficiaryService.beneficiaryExists(beneficiary)) {// to be
																											// modified
			if (transferAmount < sourceBalance) {
				sourceBalance = sourceBalance - transferAmount;
				return account.setTotalBalance(sourceBalance);

			} else
				throw new InSufficientFundsException(transferAmount);
		} else {
			if (accountService.accountExists(account))
				throw new AccountNotFoundException(beneficiary.getBeneficiaryAccNo());
			else
				throw new AccountNotFoundException(account.getAccountNo());
		}

	}

}
