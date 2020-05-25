package com.inetbanking.pageOjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DepositePage {
	WebDriver ldriver;
	public DepositePage(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(how=How.NAME, using ="accountno")
	@CacheLookup
	WebElement AccountNO;
	
	@FindBy(how=How.NAME, using ="ammount")
	@CacheLookup
	WebElement Amount;
	
	@FindBy(how=How.NAME, using ="desc")
	@CacheLookup
	WebElement Description;
	
	@FindBy(how=How.NAME, using = "AccSubmit")
	@CacheLookup
	WebElement SubmitButton;
	
	@FindBy(how=How.NAME, using = "res")
	@CacheLookup
	WebElement ResetButton;
	
	public void enterAccountNO(Number AcnNo) {
		AccountNO.sendKeys(String.valueOf(AcnNo));
	}
	public void enterAmount(Number Amnt) {
		Amount.sendKeys(String.valueOf(Amnt));
	}
	public void enterDescription(String Desc) {
		Description.sendKeys(Desc);
	}
	public void submit() {
		SubmitButton.click();
	}
	public void reset() {
		ResetButton.click();
	}
	
}
