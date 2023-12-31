package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageLocationPage {
	WebDriver driver;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newElement;
	@FindBy(xpath="//select[@id='country_id']")
	WebElement countryElement;
	@FindBy(xpath="//select[@id='st_id']")
	WebElement stateElement;
	@FindBy(xpath="//input[@id='location']")
	WebElement locationElement;
	@FindBy(xpath="//input[@id='delivery']")
	WebElement deliveryChargeElement;
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveElement;
	
	public ManageLocationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	

}
