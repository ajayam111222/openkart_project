package com.openkart.Pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.openkart.Baseclass.Basepage;

public class AddToCart_Page extends Basepage{
	@FindBy(xpath="//header/div[1]/div[1]/div[2]/div[1]/input[1]")
	private WebElement searchBox;
	@FindBy(xpath="//header/div[1]/div[1]/div[2]/div[1]/span[1]/button[1]")
	private WebElement searchIcon;
	@FindBy(xpath="//body/div[@id='product-search']/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/a[1]/img[1]")
    private WebElement ProductDisplay;	
	@FindBy(xpath="//h1[contains(text(),'iMac')]")
    private WebElement ProducName;
	@FindBy(id="button-cart")
	private WebElement AddToCart;
	@FindBy(linkText="shopping cart")
	private WebElement shopingCartLink;
	@FindBy(xpath="//body/div[@id='product-product']/div[1]")
	private WebElement AddTocartSuccessMessage;
	@FindBy(xpath="//body[1]/div[2]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")
    private WebElement ProductInShopingCart;
	@FindBy(xpath="//span[contains(text(),'Add to Cart')]")
	private WebElement ADDTOCART;
    @FindBy(id="cart-total")
    private WebElement item;
    @FindBy(xpath="//header/div[1]/div[1]/div[3]/div[1]/ul[1]/li[2]/div[1]/p[1]/a[1]/strong[1]")
    private WebElement ViewCart;
	public AddToCart_Page()
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
	public void AddToCart()
	{
		AddToCart.click();	
	}
	public void ShopingCartLink() throws InterruptedException
	{
	    WebDriverWait wait=new WebDriverWait(driver,2000);
	    wait.until(ExpectedConditions.visibilityOf(shopingCartLink));
		shopingCartLink.click();
	}
	public Boolean AddTocartSuccessMessage()
	{
	Boolean s=	AddTocartSuccessMessage.isDisplayed();
	return s;
	}
	public Boolean ProductInShopingCart()
	{
		Boolean p=ProductInShopingCart.isDisplayed();
		return p;
	}
	public void ADDToCart()
	{
		ADDTOCART.click();
	}
	public void Item() throws InterruptedException
	{
	    WebDriverWait wait=new WebDriverWait(driver,2000);
	    wait.until(ExpectedConditions.visibilityOf(item));
		item.click();
	}
	public void ViewCart()
	{
		WebDriverWait wait=new WebDriverWait(driver,2000);
	    wait.until(ExpectedConditions.visibilityOf(ViewCart));
		ViewCart.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
