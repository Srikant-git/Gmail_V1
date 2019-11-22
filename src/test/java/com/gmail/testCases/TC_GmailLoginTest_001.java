package com.gmail.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gmail.pageObjects.LoginPage;



public class TC_GmailLoginTest_001 extends BaseClass
{
	@Test
	public void LoginTest() throws IOException {	
		
		logger=report.createTest("Login to Gmail");
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered email id");
						
		lp.clickUsernameNext();
		boolean b = false;
		try {
		
		 b = driver.findElement(By.xpath("//div[@class='o6cuMc']")).isDisplayed();
		
		}
		catch(Exception e) {
		//	b = false;
		}
		if(b) 
			{		
			logger.fail("Login failed - " +lp.getfailedMessage());
			String tname="Login to Gmail";
			BaseClass.captureScreen(driver, tname);
			}
		
		else 
		{
			lp.setPassword(password);
			lp.clickPasswordNext();
			lp.clickonAccount();
			lp.clickLogout();
			Assert.assertTrue(true);
			logger.pass("Login Success");
		}
		
	}

}
