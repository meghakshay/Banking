package com.inetbanking.pageOjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.inetbanking.testCases.BaseTest;

public class LoginPage{
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By UserID = By.xpath("//input[@name = 'uid']");
	By PassWord = By.xpath("//input[@name = 'password']");
	By Submit = By.xpath("//input[@name = 'btnLogin']");
	
	public WebElement userid() {
		return driver.findElement(UserID);
	}
	
	public WebElement pwd() {
		return driver.findElement(PassWord);
	}
	
	public WebElement submit() {
		return driver.findElement(Submit);
	}
}
