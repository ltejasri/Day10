package com.capgemini.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.capgemini.bankapp.exception.LowAccountBalanceException;
import com.capgemini.bankapp.service.BankAccountService;

@Controller
public class BankAccountController {
	@Autowired
	private BankAccountService bankAccountService ;
	
	/*public void setBankAccountService(BankAccountService bankAccountService) {
		this.bankAccountService = bankAccountService;
	}*/
	
	
	
	
	public double getBalance(long accountId)
	{
		return bankAccountService.getBalance(accountId) ;
	}
	
	public double deposit(long accountId,double amount)
	{
		return bankAccountService.deposit(accountId, amount) ;
	}
	
	public boolean fundTransfer(long fromAccount,long toAccount,double amount) throws LowAccountBalanceException
	{
		return bankAccountService.fundTransfer(fromAccount, toAccount, amount) ;
	}
}