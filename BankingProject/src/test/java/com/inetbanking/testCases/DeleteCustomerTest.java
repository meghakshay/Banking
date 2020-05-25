package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageOjects.AddCustomerPage;
import com.inetbanking.pageOjects.DeleteCustomerPage;
import com.inetbanking.pageOjects.HomePage;
import com.inetbanking.helper.HelperClass;
public class DeleteCustomerTest extends BaseTest{
	private static final String priority = null;

	@Test(priority=1)
	public void delete_Existing_Customer() throws IOException {
		 String method_name=new Object(){}.getClass().getEnclosingMethod().getName();
		 HelperClass.correctlogin();
	  	 HomePage hmpg = new HomePage(driver);
	  	 hmpg.newcust();
	  	 String Customerid = HelperClass.newcstmr(new AddCustomerPage(driver));
	  	 System.out.println(Customerid);
	  	 hmpg.deletecust();
	  	 log.info("clicked on Delete Customer Tab");
	  	 if(driver.getPageSource().contains("Delete Customer Form")) {
	 	  	DeleteCustomerPage dltcstmr = new DeleteCustomerPage(driver);
		  	dltcstmr.enterCstmrId(Customerid);
		  	dltcstmr.submit();
		  	if(isAlertPresent()==true){
		  		driver.switchTo().alert().accept();
		  		if(isAlertPresent()==true) {
		  			Alert successAlert= driver.switchTo().alert();
		  			log.info(successAlert.getText());
		  			//System.out.println("successAlert of = delete_Existing_Customer"+successAlert.getText());
		  			successAlert.accept();
		  		}
		  	}
	  	 }
	  	 else {
	  		log.info("Delete Tab directed to Other Page");
	  		CaptureScrsht(driver,method_name);
	  		Assert.assertTrue(false); 
	  	 }

	}
	
	@Test(priority=2)
	public void delete_NotExisting_Customer() throws IOException{
		String method_name = new Object(){}.getClass().getEnclosingMethod().getName();
		HelperClass.correctlogin();
	  	HomePage hmpg = new HomePage(driver);
	  	hmpg.deletecust();
	  	log.info("clicked on Delete Customer Tab");
	  	 if(driver.getPageSource().contains("Delete Customer Form")) {
	 	  	DeleteCustomerPage dltcstmr = new DeleteCustomerPage(driver);
		  	dltcstmr.enterCstmrId("797225");
		  	dltcstmr.submit();
		  	if(isAlertPresent()==true){
		  		driver.switchTo().alert().accept();
		  		if(isAlertPresent()==true) {
		  			Alert successAlert= driver.switchTo().alert();
		  			log.info(successAlert.getText());
		  			//System.out.println("successAlert = delete_NotExisting_Customer"+successAlert.getText());
		  			successAlert.accept();
		  		}
		  	}
	  	 }
	  	 else {
	  		log.info("Delete Tab directed to Other Page");
	  		CaptureScrsht(driver,method_name);
	  		Assert.assertTrue(false); 
	  	 }
	}
	
	@Test(priority=3)
	public void delete_Customer_With_Unauthorized_Login() throws IOException{
		String method_name = new Object(){}.getClass().getEnclosingMethod().getName();
		HelperClass.correctlogin();
	  	HomePage hmpg = new HomePage(driver);
	  	hmpg.deletecust();
	  	log.info("clicked on Delete Customer Tab");
	  	 if(driver.getPageSource().contains("Delete Customer Form")) {
	 	  	DeleteCustomerPage dltcstmr = new DeleteCustomerPage(driver);
		  	dltcstmr.enterCstmrId("33023");
		  	dltcstmr.submit();
		  	if(isAlertPresent()==true){
		  		driver.switchTo().alert().accept();
		  		if(isAlertPresent()==true) {
		  			Alert successAlert= driver.switchTo().alert();
		  			//System.out.println("successAlert = delete_Customer_With_Unauthorized_Login"+successAlert.getText());
		  			log.info(successAlert.getText());
		  			successAlert.accept();
		  		}
		  	}
	  	 }
	  	 else {
	  		log.info("Delete Tab directed to Other Page");
	  		CaptureScrsht(driver,method_name);
	  		Assert.assertTrue(false); 
	  	 }
	}
}
