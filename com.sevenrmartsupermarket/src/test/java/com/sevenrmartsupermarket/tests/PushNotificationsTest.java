package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.PushNotificationsPage;
//import com.sevenrmartsupermarket.pages.LoginPage;
//import com.sevenrmartsupermarket.pages.PushNotificationsPage;
import com.sevenrmartsupermarket.utilities.ExcelRead;

public class PushNotificationsTest extends Base {
	ExcelRead excelread=new ExcelRead();
	PushNotificationsPage pushnotificationspage;
	 LoginPage loginpage;
	@Test(groups = "smoke")
	public void verify_ExcelData()
	{
		pushnotificationspage=new PushNotificationsPage(driver);
	excelread.setExcelFile("PushNotification","Notification");
	String data=excelread.getCellData(0,0);
	System.out.println(data);
	String expectedText="7rmart supermarket";
	String actualText=pushnotificationspage.superMarketGetext();	
    Assert.assertEquals(actualText,expectedText);
	}
	@Test(groups = {"smoke","regression"})
	public void verify_PushNotificationAlertMessage() throws InterruptedException
	{
	   loginpage=new LoginPage(driver);
       pushnotificationspage=new PushNotificationsPage(driver);
       loginpage.login();
       pushnotificationspage.clickOnPushNotification();
       excelread.setExcelFile("PushNotification","Notification");
       String title=excelread.getCellData(1, 0);
       String description=excelread.getCellData(1,1);
       pushnotificationspage.sendNotification(title, description);
       Thread.sleep(3000);
       System.out.println(title);
       System.out.println(description);
       boolean actualResult=pushnotificationspage.checkpushNotificationMessage("Message send successfully");
       Assert.assertTrue(actualResult);
    }
	
}
