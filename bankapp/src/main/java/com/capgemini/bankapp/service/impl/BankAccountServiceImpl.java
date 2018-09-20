package com.capgemini.bankapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bankapp.exception.LowAccountBalanceException;
import com.capgemini.bankapp.repository.BankAccountRepository;
import com.capgemini.bankapp.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService {
	@Autowired
	private BankAccountRepository bankRepository;
	

	/*public void setBankRepository(BankAccountRepository bankRepository) {
		this.bankRepository = bankRepository;
	}*/
	
	@Override
	public double getBalance(long accountId) {
		return bankRepository.getBalance(accountId) ;
	}

	@Override
	public double withdraw(long accountId, double amount) throws LowAccountBalanceException {
		double balance=bankRepository.getBalance(accountId) ;
		if(amount>balance)
			throw new LowAccountBalanceException("You don't have sufficient funds!!") ;
		if(balance==-1)
			return -1 ;
		balance-=amount ;
		bankRepository.updateBalance(accountId, balance) ;
		return balance ;
	}

	@Override
	public double deposit(long accountId, double amount) {
		double balance=bankRepository.getBalance(accountId) ;
		if(balance==-1)
			return -1 ;
		balance+=amount ;
		bankRepository.updateBalance(accountId, balance) ;
		return balance ;
	}

	@Override
	public boolean fundTransfer(long fromAccount, long toAccount, double amount) throws LowAccountBalanceException {
		if(withdraw(fromAccount, amount)!=-1)
		{
			if(deposit(toAccount,amount)!=-1)
				return true ;
			deposit(fromAccount,amount) ;
		}
		return false ;
	}

}