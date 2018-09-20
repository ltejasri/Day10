package com.capgemini.bankapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.bankapp.config.AppConfig;
import com.capgemini.bankapp.controller.BankAccountController;
import com.capgemini.bankapp.dbutil.DbUtil;

public class Application {

	public static void main(String[] args) {
		//ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml") ;
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class) ;
		
		
		BankAccountController bankAccountController=context.getBean("bankAccountController", BankAccountController.class) ;
		DbUtil dbutil = context.getBean("dbUtil", DbUtil.class);
		dbutil.read();
		try {
			System.out.println(bankAccountController.fundTransfer(101,100,200));
			System.out.println(bankAccountController.getBalance(101)) ;
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage()) ;
		}
		
		

	}

}