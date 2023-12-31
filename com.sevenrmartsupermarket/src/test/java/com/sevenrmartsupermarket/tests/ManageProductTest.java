package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageProductPage;

public class ManageProductTest extends Base{
	LoginPage loginpage;
	ManageProductPage manageproductpage;
	@Test
	public void addProduct()
	{   loginpage=new LoginPage(driver);
	    manageproductpage=new ManageProductPage(driver);
		loginpage.login();
		manageproductpage.manageProduct();
		manageproductpage.enterTitle("Title1");
		manageproductpage.vegMethod();
		//manageproductpage.categoriesMethod("Tomato","Onion");
		manageproductpage.weightMethod("2","kg");
		//manageproductpage.maxQtymethod("5");
		manageproductpage.elementClickable();
		
	}

}
