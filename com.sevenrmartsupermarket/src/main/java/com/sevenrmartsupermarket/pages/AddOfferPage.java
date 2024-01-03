package com.sevenrmartsupermarket.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.DataProviderUtility;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class AddOfferPage {
	WebDriver driver;
	GeneralUtility generalutility;
	
	PageUtility pageutility;
	DataProviderUtility dataproviderutility=new DataProviderUtility();
	@FindBy(xpath="(//a[@class='small-box-footer'])[6]")
	WebElement addOfferPageElement;		
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newElement;
	@FindBy(xpath="//input[@id='offer_code']")
    WebElement offerCodeElement;
	@FindBy(xpath="//input[@value='yes']")
	WebElement yesElement;
	@FindBy(xpath="//input[@id='offer_per']")
	WebElement percentageElement;
	@FindBy(xpath="//input[@id='offer_price']")
	WebElement amountElement;
	@FindBy(xpath="//div[@class='note-editable card-block']")
	WebElement descriptionElement;
	@FindBy(xpath="//input[@id='main_img']")
	WebElement chooseFileElement;
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveElement;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement alertsuccessElement;	
	public AddOfferPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void manageOfferCode()
	{
		addOfferPageElement.click();	
	}
	public void enter_addnew()
	{
		newElement.click();
	}
	public void enter_OfferCode(String offerCode)
	{
		offerCodeElement.sendKeys(offerCode);
	}
	public void click_FirstOrderUser()
	{
		yesElement.click();
	}
	public void enter_percentage(String percentage)
	{
		percentageElement.sendKeys(percentage);
	}
    public void enter_Amount(String amount)
    {
    	amountElement.sendKeys(amount);
    }
    public void enter_Description(String description)
    {
    	descriptionElement.sendKeys(description);
    }
      public void click_saveButton()
    {
    	pageutility=new PageUtility(driver);
    	pageutility.scrollAndClick(saveElement);
    		
    }
    public void image_Upload()
    {
    	File file=new File(Constants.IMAGE_FILE_PATH);
    	chooseFileElement.sendKeys(file.getAbsolutePath());
    }
    public void createNewManageOfferCode(String offerCode,String percentage,String amount,String description)
    {
    	
    	enter_addnew();
    	enter_OfferCode(offerCode);
    	click_FirstOrderUser();
    	enter_percentage(percentage);
    	enter_Amount(amount);
    	enter_Description(description);
    	image_Upload();
    	click_saveButton();
    	
    }
    public void dataProviderAddOffer(String offerCode,String percentage,String amount,String description)
    {
    	//dataproviderutility.addOfferCode();
    	enter_OfferCode(offerCode);
    	enter_percentage(percentage);
    	enter_Amount(amount);
    	enter_Description(description);
    	
    	
    }
    public boolean alertsuccessMessage(String message)
	{
		generalutility=new GeneralUtility(driver);
		return generalutility.is_WordPresent(alertsuccessElement,message);	
	}
    
}
