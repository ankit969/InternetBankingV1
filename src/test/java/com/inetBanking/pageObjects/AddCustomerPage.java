package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	//Constructor:
	public AddCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(name="name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(name="rad1")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(name="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(name="addr")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(name="city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(name="state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(name="pinno")
	@CacheLookup
	WebElement txtPIN;
	
	@FindBy(name="telephoneno")
	@CacheLookup
	WebElement txtTelNumber;
	
	@FindBy(name="emailid")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="sub")
	@CacheLookup
	WebElement clkSubmit;
	
	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
	}
	public void custName(String cName) {
		txtCustomerName.sendKeys(cName);
	}
	public void custGender(String cgender) {
		rdGender.click();
	}
	public void cusdob(String mm, String dd, String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	public void custAddress(String caaddress) {
		txtAddress.sendKeys(caaddress);
	}
	public void cuCity(String cCity) {
		txtCity.sendKeys(cCity);
	}
	public void custState(String cState) {
		txtState.sendKeys(cState);
	}
	public void custPIN(String pin) {
		txtPIN.sendKeys(String.valueOf(pin));//pin should be required in string format so we are parsing it to string
	}
	public void custMobNumber(String mNumber) {
		txtTelNumber.sendKeys(mNumber);
	}
	public void custEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void custPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	public void custSubmitBtn() {
		clkSubmit.click();
	}
}
