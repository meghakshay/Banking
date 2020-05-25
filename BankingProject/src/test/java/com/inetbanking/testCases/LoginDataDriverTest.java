package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageOjects.HomePage;
import com.inetbanking.pageOjects.LoginPage;
import com.inetbanking.utilities.XLutils;

import junit.framework.Assert;

public class LoginDataDriverTest extends BaseTest{
	@Test(dataProvider="LoginData")
	public void loginDDT(String uname, String pwd) {
		LoginPage loginpg = new LoginPage(driver);
		loginpg.userid().sendKeys(uname);
		log.info("User Name provided");
		
		loginpg.pwd().sendKeys(pwd);
		log.info("Password Provided");
		
		loginpg.submit().click();
		
		if(isAlertPresent() ==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			log.warn("Login Failed");
		}
		else {
			HomePage hmpg = new HomePage(driver);
			hmpg.logout().click();
			driver.switchTo().alert().accept();
			log.info("Login Passed");
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
		}
	}
	
	@DataProvider(name="LoginData")
	public String[][] getdata() throws IOException{
		String path = System.getProperty("user.dir")+"\\src\\test\\java\\com\\inetbanking\\testData\\logindata.xlsx";
		int rowcount = XLutils.getRowCount(path, "Sheet1");
		int colcount = XLutils.getCellCouunt(path, "Sheet1", 1);
		String logindata[][] = new String[rowcount][colcount];
		for (int i = 1; i <= rowcount; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i-1][j] = XLutils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
	
	

}
