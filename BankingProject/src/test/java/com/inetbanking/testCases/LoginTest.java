package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageOjects.HomePage;
import com.inetbanking.pageOjects.LoginPage;

public class LoginTest extends BaseTest{
  
@Test
  public void validlogin() {
	  driver.get(prop.getProperty("Url"));
	  if(driver.getCurrentUrl().equals(prop.getProperty("Url"))) {
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
	  }
	  else {
		  Assert.assertTrue(false);
		  log.error("Url is not Correct");
	  }
	HomePage homepg = new HomePage(driver);  
	homepg.logout().click();
	String logouttext = driver.switchTo().alert().getText();
	try {
		 Assert.assertEquals(logouttext, prop.getProperty("logouttext")); 
		 driver.switchTo().alert().accept();
	} catch (java.lang.AssertionError e) {
		 driver.switchTo().alert().accept();
		 Assert.assertTrue(false);
	}
	
  }

@Test
  public void InvalidUserLogin() {
	driver.get(prop.getProperty("Url"));
	 LoginPage lgn= new LoginPage(driver);
	  
	  lgn.userid().sendKeys("jhkjhk");
	  log.info("Enterted UserId");
	  
	  lgn.pwd().sendKeys(prop.getProperty("Password"));
	  log.info("Entered Password");
	  
	  lgn.submit().click();
	  
	 String invalidalerttext= driver.switchTo().alert().getText();
	
	 try {
		 Assert.assertEquals(invalidalerttext, prop.getProperty("invalidloginalertmsg")); 
		 driver.switchTo().alert().accept();
	 }
	 catch(java.lang.AssertionError e){
		 driver.switchTo().alert().accept();
		 Assert.assertTrue(false);
	 }
	 	  
  }
@Test
public void InvalidPasswordLogin() {
	driver.get(prop.getProperty("Url"));
	 LoginPage lgn= new LoginPage(driver);
	  
	  lgn.userid().sendKeys(prop.getProperty("UserId"));
	  log.info("Enterted UserId");
	  
	  lgn.pwd().sendKeys("89565876873");
	  log.info("Entered Password");
	  
	  lgn.submit().click();
	  
	 String invalidalerttext= driver.switchTo().alert().getText();
	
	 try {
		 Assert.assertEquals(invalidalerttext, prop.getProperty("invalidloginalertmsg")); 
		 driver.switchTo().alert().accept();
	 }
	 catch(java.lang.AssertionError e){
		 driver.switchTo().alert().accept();
		 Assert.assertTrue(false);
	 }
	 	  
}
}
