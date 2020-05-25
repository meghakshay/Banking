package com.inetbanking.pageOjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;


public class EditAccountPage {
	WebDriver ldriver;
	public EditAccountPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(how=How.NAME, using="accountno")
	@CacheLookup
	WebElement AccountNo;
	
	@FindBy(how=How.NAME, using = "AccSubmit")
	@CacheLookup
	WebElement SubmitButton;
	
	@FindBy(how=How.NAME, using = "res")
	@CacheLookup
	WebElement ResetButton;
	
	@FindBy(how=How.NAME, using="a_type")
	@CacheLookup
	WebElement selaccount;
	
	@FindBy(how=How.CSS, using="[value='Savings']")
	@CacheLookup
	WebElement Saving;

	public void AccountNo(String accntNO) {
		AccountNo.sendKeys(accntNO);
	}
	public void submit() {
		SubmitButton.click();
	}
	public void reset() {
		ResetButton.click();
	}
	public void getSaving() {
		  Select saving = new Select(selaccount);
		  saving.selectByVisibleText("Savings");
		  
	}
	
}


