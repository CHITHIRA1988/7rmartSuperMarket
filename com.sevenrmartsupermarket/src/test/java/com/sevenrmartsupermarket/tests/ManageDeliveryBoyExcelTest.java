package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageDeliveryBoyExcelPage;
import com.sevenrmartsupermarket.utilities.ExcelRead;

public class ManageDeliveryBoyExcelTest extends Base{
	ExcelRead excelread=new ExcelRead();
	ManageDeliveryBoyExcelPage managedeliveryboyexcelpage;
	 LoginPage loginpage;
	 @Test
	 public void verify_CreateDeliveryBoy()
	 {
		 loginpage=new LoginPage(driver);
		 managedeliveryboyexcelpage=new ManageDeliveryBoyExcelPage(driver);
		 loginpage.login();
		 managedeliveryboyexcelpage.clickOnManageDeliveryBoy();
		 managedeliveryboyexcelpage.clickNewButton();
		 excelread.setExcelFile("ManageDeliveryBoy","DeliveryBoyInformations");
		 String name=excelread.getCellData(1,0);
		 String email=excelread.getCellData(1,1);
		 String phNo=excelread.getCellData(1,2);
		 String address=excelread.getCellData(1,3);
		 String userName=excelread.getCellData(1,4);
		 String password=excelread.getCellData(1,5);
		 managedeliveryboyexcelpage.createDeliveryBoy(name, email, phNo, address, userName, password);
		 boolean actualResult=managedeliveryboyexcelpage.alertMessage("Delivery Boy Details Created Successfully");
			Assert.assertTrue(actualResult);
	 }
	@Test
	public void verify_EnterSearchName()
	{
		 loginpage=new LoginPage(driver);
		 managedeliveryboyexcelpage=new ManageDeliveryBoyExcelPage(driver);
		 loginpage.login();
		 managedeliveryboyexcelpage.clickOnManageDeliveryBoy();
		 managedeliveryboyexcelpage.clickOnSearchDeliveryBoy();
		 excelread.setExcelFile("ManageDeliveryBoy","DeliveryBoyInformations");
		 String name=excelread.getCellData(1,0);
		 managedeliveryboyexcelpage.enterSearchName(name);
		 String expectedText="Search List Delivery Boy";
			String actualText=managedeliveryboyexcelpage.getTextOfSearchDeliveryBoy();
			Assert.assertEquals(actualText, expectedText);
		 
	}
	@Test
	public void verify_ClickNameDelete()
	{
		loginpage=new LoginPage(driver);
		 managedeliveryboyexcelpage=new ManageDeliveryBoyExcelPage(driver);
		 loginpage.login();
		 managedeliveryboyexcelpage.clickOnManageDeliveryBoy();
		 excelread.setExcelFile("ManageDeliveryBoy","DeliveryBoyInformations");
		 String name=excelread.getCellData(1,0);
		 managedeliveryboyexcelpage.clickNameDelete(name);
		 boolean actualResult=managedeliveryboyexcelpage.alertDeleteMessage("Delivery Boy Informations Deleted Successfully");
			Assert.assertTrue(actualResult);
	}

}
