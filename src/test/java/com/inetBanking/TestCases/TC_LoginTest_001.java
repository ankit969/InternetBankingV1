package com.inetBanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws IOException {
		
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("UserName is entered");
		
		lp.setPassword(password);
		logger.info("Password is entered");
		
		lp.clickSubmit();
		
		String loginPageTitle = driver.getTitle();
		captureScreen(driver, "loginTest");
		Assert.assertEquals(loginPageTitle, "Guru99 Bank Manager HomePage", "This is not a correct title");
		logger.info("Landed to Home Page");
		
	}

}
