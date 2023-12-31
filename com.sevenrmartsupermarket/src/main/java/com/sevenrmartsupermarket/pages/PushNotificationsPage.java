package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class PushNotificationsPage {
	public WebDriver driver;
	GeneralUtility generalutility;
	@FindBy(xpath="//p[text()='Push Notifications']")
	WebElement pushNotificationElement;
	@FindBy(xpath="(//input[@class='form-control'])[1]")
	WebElement titleElement;
	@FindBy(xpath="//input[@id='description']")
	WebElement descriptionElement;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")
	WebElement sendButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertElement;
	public PushNotificationsPage(WebDriver driver) {
		this.driver = driver;

	PageFactory.initElements(driver, this);
	}
	public void clickOnPushNotification()
	{
		pushNotificationElement.click();
	}
	
	public void enterTitle(String title)
	{
		
	   titleElement.sendKeys(title);
	}
	public void enterDescription(String description)
	{
		descriptionElement.sendKeys(description);
	}
	public void clickSendKey()
	{
		
		sendButton.click();
	}
	public void sendNotification(String title,String description)
	{
		enterTitle(title);
		enterDescription(description);
		clickSendKey();
	}
	public boolean checkpushNotificationMessage(String message)
	{
		generalutility=new GeneralUtility(driver);
		return generalutility.is_WordPresent(alertElement,message);	
	}
}
