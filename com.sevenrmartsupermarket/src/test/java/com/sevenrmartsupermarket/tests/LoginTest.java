package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.base.DataProviders;
import com.sevenrmartsupermarket.listeners.RetryAnalyzer;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelRead;
public class LoginTest extends Base{
	LoginPage loginpage;
	HomePage homepage;
	ExcelRead excelread=new ExcelRead();
	@Test(groups = "smoke",retryAnalyzer = RetryAnalyzer.class)
	public void verify_Login()
	{
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		String expectedProfileName="Admin";
		loginpage.login();
		String actualProfileName=homepage.get_ProfileName();
		Assert.assertEquals(actualProfileName,expectedProfileName);
	}
	@Test(groups = "regression")
	public void verify_InvalidLogin()
	{
		loginpage=new LoginPage(driver);
		loginpage.login("chithira","chithira");
		//String print=loginpage.get_ErrorMessage();
		//System.out.println(print);
		boolean actualResult=loginpage.check_ErrorMessage("Invalid Username/Password");
		Assert.assertTrue(actualResult);
		
	}
	@Test(dataProvider = "LoginDataExcel",dataProviderClass =DataProviders.class )
	public void loginCredentialsExcelProvider(String userName,String password,String expectedProfileName)
	{
		
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.login(userName,password);
		String actualProfileName=homepage.get_ProfileName();
		Assert.assertEquals("actualProfileName","expectedProfileName");
		
		
		
		
	}
	
	}
	
	

