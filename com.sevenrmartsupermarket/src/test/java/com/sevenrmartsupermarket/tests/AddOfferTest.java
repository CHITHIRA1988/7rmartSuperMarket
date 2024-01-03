package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AddOfferPage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class AddOfferTest extends Base{
	LoginPage loginpage;
	AddOfferPage addofferpage;
	@Test
	public void verify_createNewManageOfferCode()
	{
		loginpage=new LoginPage(driver);
		addofferpage=new AddOfferPage(driver);
		loginpage.login();
		addofferpage.manageOfferCode();
		addofferpage.createNewManageOfferCode("TestOfferC002","25%","250","abcd");
		boolean actualResult=addofferpage.alertsuccessMessage("Offer Created Successfully");
		Assert.assertTrue(actualResult);
	}
}
