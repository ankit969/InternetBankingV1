package com.inetBanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtility;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		Thread.sleep(2000);
		
		if(isAlertPresent()==true) {//If the test case gets failed
			Thread.sleep(2000);
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();//this will show default content of login page
			Assert.assertTrue(true);
			logger.warn("Login Failed");
		}
		else {
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			driver.switchTo().alert().accept();//This will switch tp logout alert
			driver.switchTo().defaultContent();//This will take us to default login page after logout
		}
	}
	
	public boolean isAlertPresent() {//If the test case gets failed on login screen then alert window will open(Negative test case) 
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException{
		String path = System.getProperty("user.dir")+"\\src\\test\\java\\com\\inetBanking\\testData\\LoginData.xlsx";
		XLUtility xlutil = new XLUtility();
		int rowNum = xlutil.getRowCount(path, "Sheet1");
		int colCount = xlutil.getCellCount(path, "Sheet1", 1);
		String logindata[][] = new String[rowNum][colCount];
		
		for(int i=1; i<=rowNum; i++) {
			for(int j=0; j<colCount; j++) {
				logindata[i-1][j] = xlutil.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}

}
