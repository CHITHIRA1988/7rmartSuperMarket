package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AddOfferPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.DataProviderUtility;

public class DataProviderAddOfferTest extends Base{
	LoginPage loginpage;
	AddOfferPage addofferpage;
	@Test(dataProvider = "AddOffer",dataProviderClass = DataProviderUtility.class)
	public void verify_createNewManageOfferCode(String offerCode,String percentage,String amount,String description)
	{
		loginpage=new LoginPage(driver);
		addofferpage=new AddOfferPage(driver);
		loginpage.login();
		addofferpage.manageOfferCode();
		addofferpage.enter_addnew();
		addofferpage.dataProviderAddOffer(offerCode, percentage, amount, description);
		addofferpage.image_Upload();
		addofferpage.click_saveButton();
		boolean actualResult=addofferpage.alertsuccessMessage("Offer Created Successfully");
		Assert.assertTrue(actualResult);
	}
}


