package com.openkart.Pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.api.robot.Key;

import com.openkart.Baseclass.Basepage;

public class ProductDisplay_Page extends Basepage {
	
	@FindBy(xpath="//header/div[1]/div[1]/div[2]/div[1]/input[1]")
	private WebElement searchBox;
	@FindBy(xpath="//header/div[1]/div[1]/div[2]/div[1]/span[1]/button[1]")
	private WebElement searchIcon;
	@FindBy(xpath="//body/div[@id='product-search']/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/a[1]/img[1]")
    private WebElement ProductDisplay;	
	@FindBy(xpath="//h1[contains(text(),'iMac')]")
    private WebElement ProducName;
	@FindBy(xpath="//body/div[@id='product-product']/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/a[1]")
    private WebElement Brand;
	@FindBy(xpath="//li[contains(text(),'Product Code: Product 14')]")
    private WebElement ProductCode;
	@FindBy(xpath="//li[contains(text(),'Availability: Out Of Stock')]")
    private WebElement AvailabilityStatus;
	@FindBy(xpath="//input[@id='input-quantity']")
    private WebElement QuantityField;
    @FindBy(id="button-cart")
    private WebElement AddToCart;
	@FindBy(xpath="//a[contains(text(),'Reviews (0)')]")
    private WebElement Review;
	@FindBy(id="input-name")
    private WebElement Yourname;
	@FindBy(id="input-review")
    private WebElement Yourreview;
	@FindBy(xpath="//body/div[@id='product-product']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[4]/div[1]/input[5]")
    private WebElement rating;
	@FindBy(id="button-review")
    private WebElement continu;
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]")
    private WebElement SuccessMessageForRating;
	
	
	
	
	
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	public ProductDisplay_Page()
	{
		PageFactory.initElements(driver, this);
	}
	public void SearchBox(String serch)
	{   searchBox.clear();
		searchBox.sendKeys(serch);
	}
	public void searchicon()
	{
		searchIcon.click();
	}
	public void ProductDisplay()
	{
		ProductDisplay.click();	
	}
	public Boolean ProducName()
	{
		Boolean Pname=ProducName.isDisplayed();
		return Pname;
	}
	public Boolean  Brand()
	{
		Boolean brand=Brand.isDisplayed();
		return brand;
	}
	public Boolean ProductCode()
	{
		Boolean code=ProductCode.isDisplayed();
		return code;
	}
	public Boolean AvailabilityStatus()
	{
		Boolean  status=AvailabilityStatus.isDisplayed();
		return status;
	}
	public String QuantityField()
	{
	String Quant=QuantityField.getAttribute("value");
	return Quant;
	}
	public void AddToCart()
	{
		AddToCart.click();	
	
	}
	public String  QuantityFieldIncrease(String string)
	{ 
		 QuantityField.sendKeys(Key.BACKSPACE);
		 QuantityField.sendKeys(string);
		 String Quant=QuantityField.getAttribute("value");
		 return Quant;
		 
	}
	public void Review()
	{
		//Review.click();
		
		executor.executeScript("arguments[0].click();", Review);
	}
	public void Yourname(String yourname)
	{
		Yourname.sendKeys(yourname);
	}
	public void Yourreview(String review)
	{
		Yourreview.sendKeys(review);
	}
	public void rating()
	{
		//rating.click();
		executor.executeScript("arguments[0].click();", rating);
		
	}
	public void  continu()
	{
		 continu.click();
	}
	public String SuccessMessageForRating()
	{
String mess=SuccessMessageForRating.getText();
return mess;
	}

	
	
	
	
	
	
	
	
	
	
	
	

}
