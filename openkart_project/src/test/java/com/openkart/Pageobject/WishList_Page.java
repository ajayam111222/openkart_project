package com.openkart.Pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.openkart.Baseclass.Basepage;

public class WishList_Page extends Basepage{
	@FindBy(xpath="//header/div[1]/div[1]/div[2]/div[1]/input[1]")
	private WebElement searchBox;
	@FindBy(xpath="//header/div[1]/div[1]/div[2]/div[1]/span[1]/button[1]")
	private WebElement searchIcon;
	@FindBy(xpath="//body/div[@id='product-search']/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/a[1]/img[1]")
    private WebElement ProductDisplay;	
	@FindBy(xpath="//body/div[@id='product-product']/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]/i[1]")
    private WebElement WishList;
	@FindBy(css="body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible")
	private WebElement SuccessMessageWishList;
	@FindBy(css="body:nth-child(2) div.container:nth-child(4) div.alert.alert-success.alert-dismissible > a:nth-child(3)")
	private WebElement WishListLink;
	@FindBy(xpath="//a[contains(text(),'iMac')]")
    private WebElement ProductInWishList;
	@FindBy(css="div.container:nth-child(4) div.row div.col-sm-12 div.row:nth-child(4) div.product-layout.col-lg-3.col-md-3.col-sm-6.col-xs-12:nth-child(1) div.product-thumb.transition div.button-group button:nth-child(2) > i.fa.fa-heart")
    private WebElement WishList1;
	@FindBy(xpath="//a[contains(text(),'Your Store')]")
	private WebElement yourstore;
	
	public WishList_Page()
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
	public void WishList()
	{
		WishList.click();
	}
	public Boolean SuccessMessageWishList()
	{
        WebDriverWait wait=new WebDriverWait(driver,2000);
	    wait.until(ExpectedConditions.visibilityOf(SuccessMessageWishList));
	Boolean s=SuccessMessageWishList.isDisplayed();
	return s;
	}
	public void WishListLink()
	{   
		WebDriverWait wait=new WebDriverWait(driver,2000);
	    wait.until(ExpectedConditions.visibilityOf(WishListLink));
		WishListLink.click();
	}
	public Boolean ProductInWishList()
	{
		WebDriverWait wait=new WebDriverWait(driver,2000);
	    wait.until(ExpectedConditions.visibilityOf(ProductInWishList));
	    Boolean s=ProductInWishList.isDisplayed();
	return s;
	}
	public void WishList1() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,2000);
	    wait.until(ExpectedConditions.visibilityOf(	WishList1));

	    JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("arguments[0].click();",WishList1);
	}
	public void yourstore()
	{
	yourstore.click();
	}

}
