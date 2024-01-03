package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageDeliveryBoyPage {
	WebDriver driver;
	GeneralUtility generalutility=new GeneralUtility(driver);
	PageUtility pageutility;
	
	@FindBy(xpath="(//a[@class='small-box-footer'])[8]")
	WebElement manageDeliveryBoyElement;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newElement;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchElement;
	@FindBy(xpath="//input[@id='name']")
	WebElement nameElement;
	@FindBy(xpath="//input[@id='email']")
	WebElement emailElement;
	@FindBy(xpath="//input[@id='phone']")
	WebElement phnoneElement;
	@FindBy(xpath="//textarea[@id='address']")
	WebElement addressElement;
	@FindBy(xpath="//input[@id='username']")
	WebElement userNameElement;
	@FindBy(xpath="//input[@id='password']")
	WebElement passwordElement;
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveElement;
	@FindBy(xpath="//input[@id='un']")
	WebElement nameSearchElement;
	@FindBy(xpath="//table//tbody//tr//td[1]")
    List<WebElement> tableNameElement;
	@FindBy(xpath="//button[@type='submit']")
	WebElement searchButtonElement;
	@FindBy(xpath="//a[text()='Reset']")
	WebElement resetSearchElement;
	//@FindBy(xpath="//i[@class='fas fa-trash-alt']")
	//List<WebElement> deleteButtonElement;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tr//td[1]")
	List<WebElement> namesElement;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertElement;
	@FindBy(xpath="//h4[text()='Search List Delivery Boy']")
	WebElement searchDeliveryBoy;
	@FindBy(xpath="//h1[text()='List Delivery Boy']")
	WebElement listDeliveryBoy;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertDeleteElement;
	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	WebElement editDeliveryBoyElement;
	public ManageDeliveryBoyPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void clickOnManageDeliveryBoy()
	{
		manageDeliveryBoyElement.click();
		
	}
	public void clickNewButton()
	{
		newElement.click();
	}
	public void enterName(String name)
	{
		nameElement.sendKeys(name);
	}
	public void enteremail(String email)
	{
		emailElement.sendKeys(email);
	}
	
	public void enterPhone(String no)
	{
		phnoneElement.sendKeys(no);
	}
	public void enterAddress(String address)
	{
		addressElement.sendKeys(address);
	}
	public void enterUserName(String userName)
	{
		userNameElement.sendKeys(userName);
	}
	public void enterPassword(String password)
	{
		passwordElement.sendKeys(password);	
	}
	public void saveAll()
	{
		pageutility=new PageUtility(driver);
		
		pageutility.scrollAndClick(saveElement);
		//saveElement.click();
	}
		
		 
	public void clickonSearchDeliveryBoy()
	{
		searchElement.click();
		
	}
	public void createDeliveryBoy(String name,String email,String no,String address,String userName,String password)
	{
		enterName(name);
		enteremail(email);
		enterPhone(no);
		enterAddress(address);
		enterUserName(userName);
		enterPassword(password);
		
		saveAll();
	}
	public void enterSearchName(String searchName)
	{
		nameSearchElement.sendKeys(searchName);
		searchButtonElement.click();
		
		
	}
	public void resetSearch()
	{
		resetSearchElement.click();
	}

	/*
	 * public void clickDelete() { deleteButtonElement.get(0).click();
	 * driver.switchTo().alert().accept(); }
	 */
	public void clickNameDelete(String name)
	{
		pageutility=new PageUtility(driver);
		List<String> names=new ArrayList<String>();
        names=generalutility.getTextOfElements(namesElement);
        //System.out.println(names);
        //for(String name:names)
        //{
        	//System.out.println(name);
        //}
        int index=0;
        for(index=0;index<names.size();index++)
        {
        	if(name.equals(names.get(index)))
        	{
                index++;
        		break;
        	}
        }
        WebElement deleteButtonElement1=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tr["+index+"]//td[8]//a[2]"));
        pageutility.scrollAndClick(deleteButtonElement1);
        driver.switchTo().alert().accept();
    
       
	}
	public void editUser(String editingPerson)
	{ int index=0;
		List<String> names = new ArrayList<String>();
		generalutility = new GeneralUtility(driver);
		pageutility=new PageUtility(driver);
		names = generalutility.getTextOfElements(namesElement);
		System.out.println(names);	
		for(index=0;index<names.size();index++)
		{
			if(editingPerson.equals(names.get(index)))
			{
				index++;
				break;
			}
		}
		
			WebElement editButton=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tr["+index+"]//td[8]//a[1]"));
	pageutility.scrollAndClick(editButton);	
	
	}
	public boolean alertMessage(String message)
	{
		generalutility=new GeneralUtility(driver);
		return generalutility.is_WordPresent(alertElement,message);	
	}
	public String getTextOfSearchDeliveryBoy()
	{
		return searchDeliveryBoy.getText();	
	}
	public String listDeliveryBoygetText()
	{
		return listDeliveryBoy.getText();
	}
	public boolean alertDeleteMessage(String message)
	{
		generalutility=new GeneralUtility(driver);
		return generalutility.is_WordPresent(alertDeleteElement,message);	
	}
	public String editDeliveryBoygetText()
	{
	return editDeliveryBoyElement.getText();
	}
	
}
