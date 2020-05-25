package com.inetbanking.pageOjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	WebDriver ldriver;
	public EditCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	@FindBy(how=How.NAME, using="cusid")
	@CacheLookup
	WebElement Customid;
	
	@FindBy(how=How.NAME, using="AccSubmit")
	@CacheLookup
	WebElement AccSubmit;
	
	@FindBy(how=How.NAME, using ="name")
	@CacheLookup
	WebElement CustomerName;
	
	@FindBy(how=How.CSS, using="[name='rad1'][value='male']")
	@CacheLookup
	WebElement MaleGender;
	
	@FindBy(how=How.CSS, using="[name='rad1'][value='female']")
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

	public void custmid(String Cstmid) {
		Customid.sendKeys(Cstmid);
	}
	public void Acntsubmit() {
		AccSubmit.click();
	}
	public void enterAddr(String addr) {
		CustomerAddress.clear();
		CustomerAddress.sendKeys(addr);
	}
	public void enterCity(String city) {
		CustomerCity.clear();
		CustomerCity.sendKeys(city);
	}
	public void enterState(String state) {
		CustomerState.clear();
		CustomerState.sendKeys(state);
	}
	public void enterPincoe(Number pincode) {
		CustomerPincode.clear();
		CustomerPincode.sendKeys(String.valueOf(pincode));
	}
	public void enterMob(Number mob) {
		CustomerTelephone.clear();
		CustomerTelephone.sendKeys(String.valueOf(mob));
	}
	public void enterEmail(String email) {
		CustomerEmailId.clear();
		CustomerEmailId.sendKeys(email);
	}
	public void submit() {
		SubmitButton.click();
	}
	public void reset() {
		ResetButton.click();
	}
	
	
}


