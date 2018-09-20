package com.capgemini.bankapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.bankapp.config.AppConfig;
import com.capgemini.bankapp.controller.BankAccountController;

public class Application {

	public static void main(String[] args) {
		//ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml") ;
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class) ;
		BankAccountController bankAccountController=context.getBean("bankAccountController", BankAccountController.class) ;
		
		try {
			System.out.println(bankAccountController.fundTransfer(1234, 3990, 11000));	
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage()) ;
		}
		
		System.out.println(bankAccountController.getBalance(1234));

	}

}
