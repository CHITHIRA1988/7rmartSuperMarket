package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class ManageOrdersPage {
	WebDriver driver;

	PageUtility pageutility;
	GeneralUtility generalutility = new GeneralUtility(driver);
	WaitUtility waitutility;

	@FindBy(xpath = "(//a[@class='small-box-footer'])[10]")
	WebElement manageOrdersElement;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tr//td[1]")
	List<WebElement> orderIdElement;
	@FindBy(xpath = "(//select[@id='status'])[8]")
	WebElement updateStatusElement;
	@FindBy(xpath = "(//button[@class='btn btn-info'])[22]")
	WebElement updateElement;
	@FindBy(xpath="(//span[@style='text-transform: uppercase;'])[8]")
	WebElement statusElement;

	public ManageOrdersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageOrders() {
		manageOrdersElement.click();

	}

	public void clickChangeStatus(String orderId) {
		pageutility = new PageUtility(driver);
		List<String> orderIds = new ArrayList<String>();
		orderIds = generalutility.getTextOfElements(orderIdElement);
		int index = 0;
		for (index = 0; index < orderIds.size(); index++) {
			if (orderId.equals(orderIds.get(index))) {
				index++;
				break;
			}
		}
		WebElement checkStatusElement = driver.findElement(By
				.xpath("//table[@class='table table-bordered table-hover table-sm']//tr[" + index + "]//td[6]//a[1]"));
		pageutility.scrollAndClick(checkStatusElement);

	}

	public void checkStatus(String text) {
		pageutility = new PageUtility(driver);
		pageutility.select_ByVisibleText(updateStatusElement, text);

	}

	public void click_Update() {
		waitutility = new WaitUtility();
		waitutility.waitForButtonToBeClickable(driver, updateElement);
		pageutility.scrollAndClick(updateElement);
		// updateElement.click();
	}
	public boolean checkStatusMessage(String status)

	{
		generalutility=new GeneralUtility(driver);
		return generalutility.is_WordPresent(statusElement,status);	
	}
}
