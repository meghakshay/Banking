package com.inetbanking.pageOjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;


public class NewAccountPage {
	WebDriver ldriver;
	public NewAccountPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(how=How.NAME, using="cusid")
	@CacheLookup
	WebElement CustomerId;
	
	@FindBy(how=How.NAME, using="inideposit")
	@CacheLookup
	WebElement Inideposite;
	
	@FindBy(how=How.NAME, using="selaccount")
	@CacheLookup
	WebElement selaccount;
	
	@FindBy(how=How.CSS, using="[value='Savings']")
	@CacheLookup
	WebElement Saving;
	
	@FindBy(how=How.CSS, using="['Current']")
	@CacheLookup
	WebElement Current;
	
	@FindBy(how=How.NAME, using = "button2")
	@CacheLookup
	WebElement SubmitButton;
	
	@FindBy(how=How.NAME, using = "reset")
	@CacheLookup
	WebElement ResetButton;

	public void enterCustomerId(Number Customerid) {
		CustomerId.sendKeys(String.valueOf(Customerid));
	}

	public void enterInideposite(Number inideposit) {
		Inideposite.sendKeys(String.valueOf(inideposit));
	}
	
	public void getSaving() {
		  Select saving = new Select(selaccount);
		  saving.selectByVisibleText("Savings");
		  
	}
	public void getCurrent() {
		Select current = new Select(selaccount);
		current.selectByValue("Current");
	}
	public void submit() {
		SubmitButton.click();
	}
	public void reset() {
		ResetButton.click();
	}
	
	
}


