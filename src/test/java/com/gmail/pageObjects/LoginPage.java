package com.gmail.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
		WebDriver ldriver;
		
		public LoginPage(WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		@FindBy(name="identifier")
		@CacheLookup
		WebElement txtUsername;

		@FindBy(xpath = "//span[@class='CwaK9']/span" )
		@CacheLookup
		WebElement buttonemailNext;
		
		@FindBy(xpath = "//input[@name='password']")
		@CacheLookup
		WebElement txtPassword;
		
		@FindBy(xpath = "//span[@class='CwaK9']/span" )
		@CacheLookup
		WebElement buttonpwdNext;
		
		@FindBy(xpath = "//a[@class='gb_D gb_Ha gb_i']")
		@CacheLookup
		WebElement buttonAccount;
		
		@FindBy(id = "gb_71")
		@CacheLookup
		WebElement buttonSignout;
		
		@FindBy(xpath = "//div[@class='o6cuMc']")
		@CacheLookup
		WebElement failedMessage;
		
		@FindBy(xpath = "//div[text()='Use another account']")
		@CacheLookup
		WebElement buttonAnotherAccount;
		
	public void clearUserName()
	{
		txtUsername.clear();
	}	

	public void setUserName(String uname)
	{
		txtUsername.sendKeys(uname);
	}
	
	public void clickUsernameNext()
	{
		buttonemailNext.click();
	}
	
	public String getfailedMessage()
	{
		String msg=failedMessage.getText();
		return msg;
	}
	
	public void clearPassword()
	{
		txtPassword.clear();
	}
	
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickPasswordNext()
	{
		buttonpwdNext.click();
	}
	
	public void clickonAccount()
	{
		buttonAccount.click();
	}
	
	public void clickLogout()
	{
		buttonSignout.click();
	}
	
	public void clickAnotherAccount()
	{
		buttonAnotherAccount.click();
	}
	
		
	
    
}
