package com.sevenrmartsupermarket.tests;

//import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
//import com.sevenrmartsupermarket.utilities.ScreenShot;

public class LoginTest extends Base{
	LoginPage loginpage;
	HomePage homepage;
	@Test
	public void verify_Login()
	{
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		String expectedProfileName="Admin";
		loginpage.login();
		String actualProfileName=homepage.get_ProfileName();
		Assert.assertEquals(actualProfileName,expectedProfileName);
	}
	@Test
	public void verify_InvalidLogin()
	{
		loginpage=new LoginPage(driver);
		loginpage.login("chithira","chithira");
		//String print=loginpage.get_ErrorMessage();
		//System.out.println(print);
		boolean actualResult=loginpage.check_ErrorMessage("Invalid Username/Password");
		Assert.assertTrue(actualResult);
		
	}
	
	}
	
	

