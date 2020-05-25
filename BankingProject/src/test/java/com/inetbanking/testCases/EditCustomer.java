package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageOjects.EditCustomerPage;
import com.inetbanking.pageOjects.HomePage;
import com.inetbanking.pageOjects.LoginPage;

public class EditCustomer extends BaseTest{
	@Test
	public void editcutomer() throws InterruptedException, IOException {
		  LoginPage lgn= new LoginPage(driver);
		  lgn.userid().sendKeys(prop.getProperty("UserId"));
		  log.info("Enterted UserId");
		  lgn.pwd().sendKeys(prop.getProperty("Password"));
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
		  	  
		  	  HomePage hmpg=new HomePage(driver);
		  	  hmpg.editcust();
		  	  log.info("Click on Edit Customer Tab");
		  	  
		  	  
		  	  EditCustomerPage editcstmr = new EditCustomerPage(driver);
		  	  editcstmr.custmid(prop.getProperty("customerid"));
		  	  editcstmr.Acntsubmit();
		  	  editcstmr.enterAddr("House No. 5555");
		  	  editcstmr.enterCity("saskatchewan");
		  	  editcstmr.enterState("canada");
		  	  editcstmr.enterPincoe(202020);
		  	  editcstmr.enterMob(1234567890);
		  	  String rndmstring =randomAlphaString();
		  	  editcstmr.enterEmail(rndmstring+"@gmail.com");
		  	  editcstmr.submit();
		  	  if(isAlertPresent()==true) {
		  		log.info("Alert present capturing screenshot"); 
		  		CaptureScrsht(driver,"new");
		  	  }
		  	  
		  	  boolean res =driver.getPageSource().contains("Customer details updated Successfully!!!");
		  	  if (res==true) {
				Assert.assertTrue(true);
			} else {
				CaptureScrsht(driver,"new");
				Assert.assertTrue(false);
			}
		  }
	
	
}
