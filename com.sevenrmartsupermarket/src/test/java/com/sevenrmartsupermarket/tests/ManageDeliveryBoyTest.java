package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageDeliveryBoyPage;

public class ManageDeliveryBoyTest extends Base {
	LoginPage loginpage;
	ManageDeliveryBoyPage managedeliveryboypage;
	@Test
	public void createManageDeliveryBoy()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		managedeliveryboypage=new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.clickOnManageDeliveryBoy();
		managedeliveryboypage.clickNewButton();
		managedeliveryboypage.createDeliveryBoy("name6","name6@gmail.com","9999","name6","name6","name6");
		managedeliveryboypage.saveAll();
		boolean actualResult=managedeliveryboypage.alertMessage("Delivery Boy Details Created Successfully");
		Assert.assertTrue(actualResult);
		
	}
	@Test
	public void verify_SearchDeliveryBoy() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		managedeliveryboypage=new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.clickOnManageDeliveryBoy();
		managedeliveryboypage.clickonSearchDeliveryBoy();
		managedeliveryboypage.enterSearchName("name6");
		String expectedText="Search List Delivery Boy";
		String actualText=managedeliveryboypage.getTextOfSearchDeliveryBoy();
		Assert.assertEquals(actualText, expectedText);
		}

@Test
public void verify_SearchReset() {
	loginpage=new LoginPage(driver);
	loginpage.login();
	managedeliveryboypage=new ManageDeliveryBoyPage(driver);
	managedeliveryboypage.clickOnManageDeliveryBoy();
	managedeliveryboypage.clickonSearchDeliveryBoy();
	managedeliveryboypage.enterSearchName("name6");	
	managedeliveryboypage.resetSearch();
	String actualText="List Delivery Boy";
	String expectedText=managedeliveryboypage.listDeliveryBoygetText();
			Assert.assertEquals(actualText, expectedText);
}



@Test

public void verify_ClickNameDelete()
{
	loginpage=new LoginPage(driver);
	loginpage.login();
	managedeliveryboypage=new ManageDeliveryBoyPage(driver);
	managedeliveryboypage.clickOnManageDeliveryBoy();
	managedeliveryboypage.clickNameDelete("a");
	boolean actualResult=managedeliveryboypage.alertDeleteMessage("Delivery Boy Informations Deleted Successfully");
	Assert.assertTrue(actualResult);
	
}
@Test
public void verify_editUser()
{
	loginpage=new LoginPage(driver);
	loginpage.login();
	managedeliveryboypage=new ManageDeliveryBoyPage(driver);
	managedeliveryboypage.clickOnManageDeliveryBoy();
	managedeliveryboypage.editUser("Shameer");
	String actualText="Edit-Delivery Boy";
	String expectedText=managedeliveryboypage.editDeliveryBoygetText();
	Assert.assertEquals(actualText, expectedText);
}
}
