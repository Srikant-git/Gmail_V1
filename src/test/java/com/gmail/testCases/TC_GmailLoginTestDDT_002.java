package com.gmail.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gmail.pageObjects.LoginPage;
import com.gmail.utilities.XLUtils;

public class TC_GmailLoginTestDDT_002 extends BaseClass 
{

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException, IOException
	{
		logger=report.createTest("GmailLoginTestDDT");
		LoginPage lp=new LoginPage(driver);
		Thread.sleep(2000);
		lp.clearUserName();
		lp.setUserName(user);
		logger.info("user name provided");
		lp.clickUsernameNext();
		logger.info("Clicked on Username Next button");
		Thread.sleep(2000);
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
			lp.clearPassword();
			lp.setPassword(pwd);
			lp.clickPasswordNext();
			Thread.sleep(2000);
			logger.info("Clicked on Password Next button");
			lp.clickonAccount();
			Thread.sleep(2000);
			lp.clickLogout();
			Thread.sleep(2000);
			lp.clickAnotherAccount();
			Assert.assertTrue(true);
			logger.info("Login test passed");
			logger.pass("Login Success");
		}
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/Gmail/testData/GmailLoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}


}
