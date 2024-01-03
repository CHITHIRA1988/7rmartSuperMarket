package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageOrdersPage;

public class ManageOrdersTest extends Base{

	LoginPage loginpage;
	ManageOrdersPage manageorderspage;
	
	@Test
	public void verify_clickChangeStatus()
	{
		loginpage=new LoginPage(driver);
		manageorderspage=new ManageOrdersPage(driver);
		loginpage.login();
		manageorderspage.clickOnManageOrders();
		manageorderspage.clickChangeStatus("168");
		manageorderspage.checkStatus("UnPaid");
		manageorderspage.click_Update();
		boolean actualResult=manageorderspage.checkStatusMessage("UNPAID");
		Assert.assertTrue(actualResult);
	}
	
	
}
