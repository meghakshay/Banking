package com.inetbanking.testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.inetbanking.helper.HelperClass;
import com.inetbanking.pageOjects.DeleteAccountPage;
import com.inetbanking.pageOjects.HomePage;

import junit.framework.Assert;

public class DeleteAcountTest extends BaseTest{
	@Test
	public void deleteaccount() throws InterruptedException {
	//Login, Create Account to Delete 
		String AcntNo = HelperClass.CreateAccount();
		
	//Click On Delete Tab
		HomePage hmpg = HelperClass.HomePageObj();
		hmpg.deleteact();
		if(driver.getPageSource().contains("Delete Account Form")) {
			//Enter Acnt No to delete
			DeleteAccountPage dltacntpg = new DeleteAccountPage(driver);
			dltacntpg.enterAccountNO(AcntNo);
			log.info("Account No Entered");
			dltacntpg.submit();
			if(isAlertPresent()==true) {
				Thread.sleep(3000);
				driver.switchTo().alert().accept();
				Thread.sleep(3000);
				if(isAlertPresent()==true) {
					Thread.sleep(3000);
					Alert successAlert= driver.switchTo().alert();
					log.info(successAlert.getText());
					successAlert.accept();
					Assert.assertTrue(true);
				}
				
			}
		}
		else {
			log.error("Not Directed to Delete Page");
			Assert.assertTrue(false);
		}
	
	}
	
	@Test
	public void deleteaccoun_with_emptyAccountNo() throws InterruptedException {
	//Login
		HelperClass.correctlogin();
	//Click On Delete Tab
		HomePage hmpg = HelperClass.HomePageObj();
		hmpg.deleteact();
		if(driver.getPageSource().contains("Delete Account Form")) {
			DeleteAccountPage dltacntpg = new DeleteAccountPage(driver);
			dltacntpg.enterAccountNO("");
			dltacntpg.submit();
			boolean verifytext = driver.findElement(By.xpath("//label[@id='message2']")).isDisplayed();
			log.info(driver.findElement(By.xpath("//label[@id='message2']")).getText());
			Assert.assertTrue(verifytext);
			dltacntpg.submit();
			if(isAlertPresent()==true) {
				Thread.sleep(3000);
				driver.switchTo().alert().accept();
				Assert.assertTrue(true);
			}
			else {
				log.info("Field Alert not displayed");
				Assert.assertTrue(false);
			}
			}
		else {
			log.error("Not Directed to Delete Page");
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void deleteaccoun_with_Char_as_AccountNo() throws InterruptedException {
	//Login
		HelperClass.correctlogin();
	//Click On Delete Tab
		HomePage hmpg = HelperClass.HomePageObj();
		hmpg.deleteact();
		if(driver.getPageSource().contains("Delete Account Form")) {
			DeleteAccountPage dltacntpg = new DeleteAccountPage(driver);
			dltacntpg.enterAccountNO("AnyChar");
			log.info("Entered Char in Account No Field");
			boolean verifytext = driver.findElement(By.xpath("//label[@id='message2']")).isDisplayed();
			Assert.assertTrue(verifytext);
			log.info(driver.findElement(By.xpath("//label[@id='message2']")).getText());
			dltacntpg.submit();
			if(isAlertPresent()==true) {
				Thread.sleep(3000);
				Alert successAlert= driver.switchTo().alert();
				String FieldAlertText =successAlert.getText(); 
				if(FieldAlertText.equals("Please fill all fields")) {
					successAlert.accept();
					Assert.assertTrue(true);
				}
				else {
					log.info("Text = 'Please fill all fields' is not present on alert");
					Assert.assertTrue(false);
				}
			}
		}
	}
}
