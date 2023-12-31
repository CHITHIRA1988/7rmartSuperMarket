package com.sevenrmartsupermarket.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class ManageProductPage {
	
	WebDriver driver;
	
	PageUtility pageutility;
	
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-danger']")
	WebElement newElement;
	@FindBy(xpath="(//a[@class='small-box-footer'])[5]")
	WebElement manageProductElement;
	@FindBy(xpath = "//input[@id='title']")
	WebElement titleElement;
	@FindBy(xpath="//input[@value='Veg']")
	WebElement vegElement;
	@FindBy(xpath="//input[@value='Nonveg']")
	WebElement nonVegElement;
	@FindBy(xpath="//input[@value='Others']")
	WebElement othersElement;
	@FindBy(xpath="//input[@id='tag']")
	WebElement tagElement;
	@FindBy(xpath="//select[@id='cat_id']")
	WebElement categoryElement;
	@FindBy(xpath="//select[@id='sub_id']")
	WebElement subCategoryElement;
	@FindBy(xpath="//input[@id='purpose']")
	WebElement weightElement;
	@FindBy(xpath="//input[@id='m_weight']")
	WebElement weightValueElement;
	@FindBy(xpath="//select[@id='w_unit']")
	WebElement weightUnitElement;
	@FindBy(xpath="//input[@id='w_stock']")
	WebElement stockAvailabilityElement;
	@FindBy(xpath="//input[@id='max_weight']")
	WebElement maxQtyElement;
	@FindBy(xpath="//input[@id='w_price']")
	WebElement priceElement;
	@FindBy(xpath="(//input[@name='stock'])[1]")
	WebElement stockElement;
	@FindBy(xpath="(//input[@value='yes'])[7]")
	WebElement featuredElement;
	@FindBy(xpath="//button[@class='btn btn-danger']")
	WebElement saveElement;
	
	public ManageProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void manageProduct()
	{
		manageProductElement.click();
		newElement.click();
	}
	public void enterTitle(String title)
	{
		titleElement.sendKeys(title);
	}
	public void vegMethod()
	{
		vegElement.click();
	}
    public void nonVegMethod()
    {
    	nonVegElement.click();
    }
    public void othersElementMethod()
    {
    	othersElement.click();
    }
    //public void categoriesMethod(String category,String subCategory)
    //{
    	//categoryElement.sendKeys(category);
    	//subCategoryElement.sendKeys(subCategory);
    //}
    public void maxQtymethod(String number)
    {
    	maxQtyElement.sendKeys(number);
   
    	
    }
    public void weightMethod(String no,String weight)
    {
    	weightElement.click();
    	weightValueElement.sendKeys(no);
    	pageutility=new PageUtility(driver);
    	pageutility.select_ByVisibleText(weightUnitElement,weight);
    	maxQtymethod("5kg");
    	stockAvailabilityElement.sendKeys("Yes");
    	priceElement.sendKeys("100");
    }
    	
    
    public void elementClickable()
    {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));

    	//stockElement.click();
    	//featuredElement.click();
    	saveElement.click();
    }
    
}
