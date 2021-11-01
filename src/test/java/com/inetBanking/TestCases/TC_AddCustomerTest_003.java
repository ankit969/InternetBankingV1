package com.inetBanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User Name is provided");
		lp.setPassword(password);
		logger.info("User password is provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		AddCustomerPage addCust = new AddCustomerPage(driver);
		addCust.clickAddNewCustomer();
		logger.info("Providing the customer details");
		
		addCust.custName("Itachi");
		addCust.custGender("male");
		addCust.cusdob("10", "8", "1992");
		Thread.sleep(3000);
		addCust.custAddress("INDIA");
		addCust.cuCity("PUNE");
		addCust.custState("MH");
		addCust.custPIN("441912");
		addCust.custMobNumber("9999999999");
		
		String Email = randomString()+"@gmail.com";
		addCust.custEmail(Email);
		
		addCust.custPassword("abcdef");
		addCust.custSubmitBtn();
		Thread.sleep(3000);
		logger.info("Validation is started...");
		//If the new customer is created it will give message for suucessful
		//So write assertion to check the test case passed or failed
		
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(result==true) {
			Assert.assertTrue(true);
			logger.info("Test case is passed");
		}
		else {
			logger.info("Test case is failed...");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}
	
	

}
