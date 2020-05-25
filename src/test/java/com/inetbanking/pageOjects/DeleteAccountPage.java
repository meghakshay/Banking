package com.inetbanking.pageOjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DeleteAccountPage {
	WebDriver ldriver;
	public DeleteAccountPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how=How.NAME, using="accountno")
	@CacheLookup
	WebElement AccountNO;
	
	@FindBy(how=How.NAME, using = "AccSubmit")
	@CacheLookup
	WebElement SubmitButton;
	
	@FindBy(how=How.NAME, using = "res")
	@CacheLookup
	WebElement ResetButton;
	
	public void enterAccountNO(String acntno) {
		AccountNO.sendKeys(acntno);
	}
	public void submit() {
		SubmitButton.click();
	}
	public void reset() {
		ResetButton.click();
	}
}
