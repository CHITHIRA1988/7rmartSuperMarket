package com.sevenrmartsupermarket.base;

import org.testng.annotations.DataProvider;

import com.sevenrmartsupermarket.utilities.ExcelRead;

public class DataProviders {
	ExcelRead excelread=new ExcelRead();
	
	@DataProvider(name="LoginData")
	public Object[][] UserLogin()
	{
		return new Object [][] {{"Sheila2023","Runolfsson123","Sheila2023"},{"gopi","gopi","Gopi"},{"suresh","suresh","Suresh"}};
	}

	@DataProvider(name="LoginDataExcel")
	public Object[][] UserLogin1()
	{
		excelread.setExcelFile("LoginData","LoginCredentials");
		Object data[][] = excelread.getMultidimentionalData(3,3);
		return data;
		
	}
}
