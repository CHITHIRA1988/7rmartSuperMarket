package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class HomePage {
	public WebDriver driver;
	GeneralUtility generalutility;
	WaitUtility waitutility;
	
	@FindBy(xpath = "//a[@class='d-block']")
	WebElement profile_Name;
	@FindBy(xpath = "(//a[@class='nav-link'])[2]")
	WebElement adminElement;
	@FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
	WebElement signoutElement;
	@FindBy(xpath="//b[text()='7rmart supermarket']")
	WebElement superMarket;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;

	PageFactory.initElements(driver, this);
}
public String get_ProfileName()
{
	generalutility=new GeneralUtility(driver);
	String profileName= generalutility.get_TextOfElement(profile_Name);
	return profileName;
}
public String superMarketGetext()
{
	return superMarket.getText();
}
public void logout()
{
	
  adminElement.click();
  signoutElement.click();
	
}
}
