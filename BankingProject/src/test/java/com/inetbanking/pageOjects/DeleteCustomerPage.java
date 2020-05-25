package com.inetbanking.pageOjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {
	WebDriver ldriver;
	public DeleteCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	@FindBy(how=How.NAME, using ="cusid")
	@CacheLookup
	WebElement CustomerID;
	
	@FindBy(how=How.NAME, using = "AccSubmit")
	@CacheLookup
	WebElement SubmitButton;
	
	public void enterCstmrId(String customerid) {
		CustomerID.sendKeys(customerid);
	}
	public void submit() {
		SubmitButton.click();
	}
}
