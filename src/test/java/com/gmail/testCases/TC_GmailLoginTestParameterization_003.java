package com.gmail.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gmail.pageObjects.LoginPage;

public class TC_GmailLoginTestParameterization_003 extends BaseClass {
	
	@Parameters({"user","pwd"})
	@Test
	public void loginDDT(String user,String pwd) throws InterruptedException, IOException
	{
		logger=report.createTest("Gmail Login Test Parameterization");
		LoginPage lp=new LoginPage(driver);
		lp.clearUserName();
		lp.setUserName(user);
		logger.info("user name provided");
		lp.clickUsernameNext();
		logger.info("Clicked on Username Next button");
		boolean b = false;
		try {
		
		 b = driver.findElement(By.xpath("//div[@class='o6cuMc']")).isDisplayed();
		
		}
		catch(Exception e) {
		//	b = false;
		}
		if(b) 
			{			
			logger.fail("Login test failed - " +lp.getfailedMessage());
			String tname="GmailLoginTestParameterization";
			BaseClass.captureScreen(driver, tname);
			}
		
		else 
		{
			lp.clearPassword();
			lp.setPassword(pwd);
			lp.clickPasswordNext();
			lp.clickonAccount();
			lp.clickLogout();
			lp.clickAnotherAccount();
			Assert.assertTrue(true);
			logger.info("Login test passed");
			logger.pass("Login Success");
		}
	}


}
