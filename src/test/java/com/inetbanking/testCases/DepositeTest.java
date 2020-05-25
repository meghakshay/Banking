package com.inetbanking.testCases;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.helper.HelperClass;
import com.inetbanking.pageOjects.DepositePage;
import com.inetbanking.pageOjects.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Action;

public class DepositeTest extends BaseTest{
	@Test
	public void deposite() throws InterruptedException {
	//Login to website
		HelperClass.correctlogin();
//		String str = driver.getWindowHandle();
//		System.out.println(str);
//		driver.switchTo().frame("flow_close_btn_iframe");
//		driver.findElement(By.xpath("//div[@id='closeBtn']")).click();
//		driver.switchTo().window(str);
		Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath("//a[text()='Deposit']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
//		HomePage hmpg = new HomePage(driver);
//		hmpg.deposit();	
//		
		if(driver.getPageSource().contains("Amount Deposit Form")) {
			DepositePage depo = new DepositePage(driver);
			depo.enterAccountNO(78798);
			depo.enterAmount(500);
			depo.enterDescription("Amount Deposited");
			depo.submit();
			if(driver.findElement(By.xpath("//td[text()='Amount Credited']/..//td[2]")).isDisplayed()) {
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
