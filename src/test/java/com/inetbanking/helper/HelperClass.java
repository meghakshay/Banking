package com.inetbanking.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.inetbanking.pageOjects.AddCustomerPage;
import com.inetbanking.pageOjects.HomePage;
import com.inetbanking.pageOjects.LoginPage;
import com.inetbanking.pageOjects.NewAccountPage;
import com.inetbanking.testCases.BaseTest;

public class HelperClass extends BaseTest{

	public static String newcstmr(AddCustomerPage addcstmr) {
	  	  addcstmr.enterUserName("local");
	  	  addcstmr.selectfemaleGender();
	  	  addcstmr.entertDateOfBirth("08","08","1900");
	  	  addcstmr.enterAddr("House No 500");
	  	  addcstmr.enterCity("Bangluru");
	  	  addcstmr.enterState("India");
	  	  addcstmr.enterPincoe(202020);
	  	  addcstmr.enterMob(1234567890);
	  	  String rndmstring =randomAlphaString();
	  	  addcstmr.enterEmail(rndmstring+"@gmail.com");
	  	  addcstmr.enterPassword(randomAlphaNumericString());
	  	  addcstmr.submit();
	  	  String CustomerId = driver.findElement(By.xpath("//td[text()='Customer ID']/..//td[2]")).getText();
	  	  return CustomerId;
	}
	public static void correctlogin() {
		  LoginPage lgn= new LoginPage(driver);
		  lgn.userid().sendKeys("mngr261370");
		  log.info("Enterted UserId");
		  lgn.pwd().sendKeys("vazypes");
		  log.info("Entered Password");
		  lgn.submit().click();
		  log.info("Clicked on Login Button");
	  	  if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			  log.info("HomePage Title is matched");
			  Assert.assertTrue(true);
			  
		  }
		  else {
			log.info("HomePage Title is not matched");
			Assert.assertTrue(false);
			
		  }
	}
	public static String  CreateAccount() {
		correctlogin();
		HomePage hmpg = new HomePage(driver);
		hmpg.newacnt();
		String AccntNo =" ";
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
				AccntNo = driver.findElement(By.xpath("//td[text()='Account ID']/..//td[2]")).getText();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}  
		else {
			  log.info("Not directed to New Account Page");
		  }
		return AccntNo;
		
	}
	public static HomePage HomePageObj() {
		HomePage hmpg = new HomePage(driver);
		return hmpg;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
