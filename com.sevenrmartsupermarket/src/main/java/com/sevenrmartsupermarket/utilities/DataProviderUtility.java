package com.sevenrmartsupermarket.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {
	@DataProvider(name="AddOffer")
	public Object[][] addOfferCode()
	{
		return new Object [][] {{"TestC001","25%","250","TestC001"}};
	}
}
