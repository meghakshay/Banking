package com.inetbanking.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageOjects.HomePage;
import com.inetbanking.pageOjects.LoginPage;
import com.inetbanking.pageOjects.NewAccountPage;
import com.inetbanking.helper.HelperClass;;

public class NewAccountTest extends  BaseTest{
	@Test
	public void createNewAccount() {
	//Login to website
		HelperClass.correctlogin();
	//Click on NewAccount Tab
		HomePage hmpg = new HomePage(driver);
		hmpg.newacnt();
		if(driver.getPageSource().contains("Add new account form")) {
			//New Account Open
			NewAccountPage newacct = new NewAccountPage(driver);
			newacct.enterCustomerId(11833);
			log.info("CustomerId entered is 11833");
			newacct.getCurrent();
			log.info("current account is selected");
			newacct.enterInideposite(500);
			log.info("initial amount is 500");
			newacct.submit();  
			if(driver.getPageSource().contains("Account Generated Successfully!!!")) {
				log.info("account details are submitted");
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}  
		else {
			  log.info("Not directed to New Account Page");
		  }
		
	}
	@Test
	public void createNewAccounta_With_Saving_Option() {
	//Login to website
		HelperClass.correctlogin();
	//Click on NewAccount Tab
		HomePage hmpg = new HomePage(driver);
		hmpg.newacnt();
		if(driver.getPageSource().contains("Add new account form")) {
			//New Account Open
			NewAccountPage newacct = new NewAccountPage(driver);
			newacct.enterCustomerId(11833);
			log.info("CustomerId entered is 11833");
			newacct.getSaving();
			log.info("Saving account is selected");
			newacct.enterInideposite(500);
			log.info("initial amount is 500");
			newacct.submit();  
			if(driver.getPageSource().contains("Account Generated Successfully!!!")) {
				log.info("account details are submitted");
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}  
		else {
			  log.info("Not directed to New Account Page");
		  }
	}
		
	@Test
	public void CreateAccount_With_Invalid_CustomerId() {
		//Login to website
			HelperClass.correctlogin();
		//Click on NewAccount Tab
			HomePage hmpg = new HomePage(driver);
			hmpg.newacnt();
			if(driver.getPageSource().contains("Add new account form")) {
			//New Account Open
				NewAccountPage newacct = new NewAccountPage(driver);
				newacct.enterCustomerId(45892);
				log.info("Entered Invalid CustomerId is 45892");
				newacct.getCurrent();
				log.info("current account is selected");
				newacct.enterInideposite(500);
				log.info("initial amount is 500");
				newacct.submit();  
				if(isAlertPresent()==true) {
					driver.switchTo().alert().accept();
					Assert.assertTrue(true);
					}
				else {
					Assert.assertTrue(false);
					}
				}  
			else {
					log.info("Not directed to New Account Page");
				  }
	}
	@Test
	public void CreateAccount_With_Less_Amount() {
		//Login to website
			HelperClass.correctlogin();
		//Click on NewAccount Tab
			HomePage hmpg = new HomePage(driver);
			hmpg.newacnt();
			if(driver.getPageSource().contains("Add new account form")) {
			//New Account Open
				NewAccountPage newacct = new NewAccountPage(driver);
				newacct.enterCustomerId(11833);
				log.info("Entered Invalid CustomerId is 11833");
				newacct.getCurrent();
				log.info("current account is selected");
				newacct.enterInideposite(400);
				log.info("initial amount is less than 500");
				newacct.submit();  
				if(isAlertPresent()==true) {
					driver.switchTo().alert().accept();
					Assert.assertTrue(true);
					}
				else {
					Assert.assertTrue(false);
					}
				}  
			else {
					log.info("Not directed to New Account Page");
				  }
	}
}
