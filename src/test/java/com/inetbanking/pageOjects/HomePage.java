package com.inetbanking.pageOjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver ldriver;
	
	public HomePage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	By logout = By.xpath("//a[text()='Log out']");
	
	public WebElement logout() {
		return ldriver.findElement(logout);
	}
	
	@FindBy(how=How.XPATH, using="//a[text()='New Customer']")
	@CacheLookup
	WebElement NewCustomer;
	
	@FindBy(how=How.XPATH, using="//a[text()='Edit Customer']")
	@CacheLookup
	WebElement EditCustomer;
	
	@FindBy(how=How.XPATH, using="//a[text()='Delete Customer']")
	@CacheLookup
	WebElement DeleteCustomer;
	
	@FindBy(how=How.XPATH, using="//a[text()='New Account']")
	@CacheLookup
	WebElement NewAccount;
	
	@FindBy(how=How.XPATH, using="//a[text()='Edit Account']")
	@CacheLookup
	WebElement EditAccount;
	
	@FindBy(how=How.XPATH, using="//a[text()='Delete Account']")
	@CacheLookup
	WebElement DeleteAccount;
	
	@FindBy(how=How.XPATH, using="//a[@href='DepositInput.php']")
	@CacheLookup
	WebElement Deposit;
	
	@FindBy(how=How.XPATH, using="//div[@id='closeBtn']")
	WebElement CloseVideo;
	
	
	public void newcust() {
		NewCustomer.click();
	}
	
	public void editcust() {
		EditCustomer.click();
	}
	
	public void deletecust() {
		DeleteCustomer.click();
	}
	public void newacnt() {
		NewAccount.click();
	}
	public void editacnt() {
		EditAccount.click();
	}
	public void deleteact() {
		DeleteAccount.click();
	}
	public void closevideo() {
		CloseVideo.click();
	}
	public void deposit() {
		Deposit.click();
	}
}
