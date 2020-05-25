package com.inetbanking.pageOjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	@FindBy(how=How.NAME, using ="name")
	@CacheLookup
	WebElement CustomerName;
	
	@FindBy(how=How.CSS, using="[name='rad1'][value='m']")
	@CacheLookup
	WebElement MaleGender;
	
	@FindBy(how=How.CSS, using="[name='rad1'][value='f']")
	@CacheLookup
	WebElement FemaleGender;
	
	@FindBy(how=How.ID_OR_NAME, using="dob")
	@CacheLookup
	WebElement DateOfBirth;
	
	@FindBy(how=How.NAME, using="addr")
	@CacheLookup
	WebElement CustomerAddress;
	
	@FindBy(how=How.NAME, using="city")
	@CacheLookup
	WebElement CustomerCity;
	
	@FindBy(how=How.NAME, using="state")
	@CacheLookup
	WebElement CustomerState;
	
	@FindBy(how=How.NAME, using="pinno")
	@CacheLookup
	WebElement CustomerPincode;
	
	@FindBy(how=How.NAME, using="telephoneno")
	@CacheLookup
	WebElement CustomerTelephone;
	
	@FindBy(how=How.NAME, using="emailid")
	@CacheLookup
	WebElement CustomerEmailId;
	
	@FindBy(how=How.NAME,using="password")
	@CacheLookup
	WebElement CustomerPassword;
	
	@FindBy(how=How.NAME, using = "sub")
	@CacheLookup
	WebElement SubmitButton;
	
	@FindBy(how=How.NAME, using = "res")
	@CacheLookup
	WebElement ResetButton;

	public void enterUserName(String UName) {
		CustomerName.sendKeys(UName);
	}
	
	public void selectMaleGender() {
		MaleGender.click();
	}
	public void selectfemaleGender() {
		FemaleGender.click();
	}
	
	public void entertDateOfBirth(String mm, String dd, String yyyy) {
		DateOfBirth.sendKeys(mm);
		DateOfBirth.sendKeys(dd);
		DateOfBirth.sendKeys(yyyy);
	}
	public void enterAddr(String addr) {
		CustomerAddress.sendKeys(addr);
	}
	public void enterCity(String city) {
		CustomerCity.sendKeys(city);
	}
	public void enterState(String state) {
		CustomerState.sendKeys(state);
	}
	public void enterPincoe(Number pincode) {
		CustomerPincode.sendKeys(String.valueOf(pincode));
	}
	public void enterMob(Number mob) {
		CustomerTelephone.sendKeys(String.valueOf(mob));
	}
	public void enterEmail(String email) {
		CustomerEmailId.sendKeys(email);
	}
	public void enterPassword(String pwd) {
		CustomerPassword.sendKeys(pwd);
	}
	public void submit() {
		SubmitButton.click();
	}
	public void reset() {
		ResetButton.click();
	}
	
	
}


