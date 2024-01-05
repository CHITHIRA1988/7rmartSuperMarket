package com.sevenrmartsupermarket.base;

import org.testng.annotations.DataProvider;

import com.sevenrmartsupermarket.utilities.ExcelRead;

public class DataProviders {
	ExcelRead excelread=new ExcelRead();
	
	@DataProvider(name="LoginData")
	public Object[][] UserLogin()
	{
		return new Object [][] {{"gopi","gopi","Brent"},{"suresh","hema","qwe"},{"Herta2023","Durgan123","Vern"}};
	}

	@DataProvider(name="LoginDataExcel")
	public Object[][] UserLogin1()
	{
		excelread.setExcelFile("LoginData","LoginCredentials");
		Object data[][] = excelread.getMultidimentionalData(3,3);
		return data;
		
	}
}
