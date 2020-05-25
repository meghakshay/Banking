package com.inetbanking.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageOjects.EditAccountDetailPage;
import com.inetbanking.pageOjects.EditAccountPage;
import com.inetbanking.pageOjects.HomePage;
import com.inetbanking.pageOjects.LoginPage;
import com.inetbanking.pageOjects.NewAccountPage;
import com.inetbanking.helper.HelperClass;;

public class EditAccountTest extends  BaseTest{
	@Test
	public void editAccount() {
		String AccntNO = HelperClass.CreateAccount();
		HomePage hmpg = new HomePage(driver);
		hmpg.editacnt();
		if(driver.getPageSource().contains("Edit Account Form")) {
			EditAccountPage edtacnt= new EditAccountPage(driver);
			edtacnt.AccountNo(AccntNO);
			edtacnt.submit();
			EditAccountDetailPage edtacnt1= new EditAccountDetailPage(driver);
			edtacnt1.getSaving();
			edtacnt1.submit();
			if(driver.getPageSource().contains("Account details updated Successfully!!!")) {
				log.info(driver.getPageSource());
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		else {
			Assert.assertTrue(false);
		}
		}
		
	}