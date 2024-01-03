package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.listeners.RetryAnalyzer;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
public class LoginTest extends Base{
	LoginPage loginpage;
	HomePage homepage;
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
		Faker faker = new Faker();
		String name = faker.name().fullName();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
         System.out.println(name);
         System.out.println(firstName);
         System.out.println(lastName);
		String streetAddress = faker.address().streetAddress();
		System.out.println(streetAddress);
		loginpage=new LoginPage(driver);
		loginpage.login("chithira","chithira");
		//String print=loginpage.get_ErrorMessage();
		//System.out.println(print);
		boolean actualResult=loginpage.check_ErrorMessage("Invalid Username/Password");
		Assert.assertTrue(actualResult);
		
	}
	
	}
	
	

