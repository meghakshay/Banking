package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageOjects.AddCustomerPage;
import com.inetbanking.pageOjects.HomePage;
import com.inetbanking.pageOjects.LoginPage;

public class AddCustomer extends BaseTest{
	@Test
	public void addcutomer() throws InterruptedException, IOException {
		  String method_name=new Object(){}.getClass().getEnclosingMethod().getName();
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
		  	  hmpg.newcust();
		  	  log.info("Click on New Customer to Add new One");
		  	
		  	  AddCustomerPage addcstmr = new AddCustomerPage(driver);
		  	  addcstmr.enterUserName("Megha");
		  	  addcstmr.selectfemaleGender();
		  	  addcstmr.entertDateOfBirth("28","08","1991");
		  	  addcstmr.enterAddr("House No 500");
		  	  addcstmr.enterCity("saskatchewan");
		  	  addcstmr.enterState("canada");
		  	  addcstmr.enterPincoe(202020);
		  	  addcstmr.enterMob(1234567890);
		  	  String rndmstring =randomAlphaString();
		  	  addcstmr.enterEmail(rndmstring+"@gmail.com");
		  	  addcstmr.enterPassword(randomAlphaNumericString());
		  	  addcstmr.submit();
		  	  if(isAlertPresent()==true) {
		  		log.info("Alert present capturing screenshot"); 
		  		CaptureScrsht(driver,method_name);
		  	  }
		  	  
		  	  boolean res =driver.getPageSource().contains("Customer Registered Successfully");
		  	  if (res==true) {

				String Customer_ID = driver.findElement(By.xpath("//td[text()=\"Customer ID\"]/..//td[2]")).getText();
				String Customer_Name = driver.findElement(By.xpath("//td[text()=\"Customer Name\"]/..//td[2]")).getText();
				String data[]= {Customer_Name,Customer_ID};
				SetcutomerdetailsTest setcstmdt = new SetcutomerdetailsTest(data);
				Assert.assertTrue(true);
			} else {
				CaptureScrsht(driver,method_name);
				Assert.assertTrue(false);
			}
		  }
	
	
}
