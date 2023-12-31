package com.sevenrmartsupermarket.tests;

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
	}
	@Test
	public void verify_SearchDeliveryBoy() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		managedeliveryboypage=new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.clickOnManageDeliveryBoy();
		
		managedeliveryboypage.clickonSearchDeliveryBoy();
		managedeliveryboypage.enterSearchName("client29/12/2023 11:57:28");	
		
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
}

//@Test
/*
 * public void verify_clickDelete() { loginpage=new LoginPage(driver);
 * loginpage.login(); managedeliveryboypage=new ManageDeliveryBoyPage(driver);
 * managedeliveryboypage.clickOnManageDeliveryBoy();
 * managedeliveryboypage.clickDelete(); }
 */

@Test

public void verify_ClickNameDelete()
{
	loginpage=new LoginPage(driver);
	loginpage.login();
	managedeliveryboypage=new ManageDeliveryBoyPage(driver);
	managedeliveryboypage.clickOnManageDeliveryBoy();
	managedeliveryboypage.clickNameDelete("client29/12/2023 11:52:17");
}
@Test
public void verify_editUser()
{
	loginpage=new LoginPage(driver);
	loginpage.login();
	managedeliveryboypage=new ManageDeliveryBoyPage(driver);
	managedeliveryboypage.clickOnManageDeliveryBoy();
	managedeliveryboypage.editUser("client29/12/2023 11:43:43");
	
}
}
