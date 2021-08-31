package com.openkart.Pageobject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.openkart.Baseclass.Basepage;

public class ProductSearch_page extends Basepage {
	
	@FindBy(xpath="//header/div[1]/div[1]/div[2]/div[1]/input[1]")
	private WebElement searchBox;
	@FindBy(xpath="//header/div[1]/div[1]/div[2]/div[1]/span[1]/button[1]")
	private WebElement searchIcon;
	@FindBy(xpath="//body/div[@id='product-search']/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/h4[1]/a[1]")
    private WebElement displyed_product;
	@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criter')]")
	private WebElement no_product_match;
	@FindBy(xpath="//a[contains(text(),'iMac')]")
	private WebElement mac;
	@FindBy(xpath="//body/div[@id='product-search']/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/h4[1]/a[1]")
	private WebElement Imac; 
	@FindBy(xpath="//a[contains(text(),'MacBook Air')]")
	private WebElement MacBookAir;
	@FindBy(xpath="//input[@id='input-search']")
	private WebElement serchCreteriaPlaceHolder;
	@FindBy(id="button-search")
	private WebElement serchPlaceHolder;
	@FindBy(id="input-search")
	private WebElement SerchCreteriaField;
	@FindBy(id="button-search")
	private WebElement SerchField_Icon;
	@FindBy(xpath="//body/div[@id='product-search']/div[1]/div[1]/div[1]/div[2]/select[1]")
	private WebElement all_categegory;
	@FindBy(xpath="//body/div[@id='product-search']/div[1]/div[1]/div[1]/div[3]/label[1]/input[1]")
	private WebElement SearchInSubCategories;
	@FindBy(xpath="//body/div[@id='product-search']/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]/i[1]")
	private WebElement listOptions;
	@FindBy(xpath="//body/div[@id='product-search']/div[1]/div[1]/div[2]/div[1]/div[1]/button[2]/i[1]")
    private WebElement GrideOption;
	@FindBy(xpath="//body/div[@id='product-search']/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/a[1]/img[1]")
	private WebElement single_product;
	@FindBy(xpath="//body/div[@id='product-search']/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[2]/button[1]/span[1]")
	private WebElement addtocart;
	@FindBy(xpath="//body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[2]/button[2]")
	private WebElement addtowishlist;
	@FindBy(css="div.container:nth-child(4) div.row div.col-sm-12 div.row:nth-child(8) div.product-layout.product-list.col-xs-12:nth-child(1) div.product-thumb div:nth-child(2) div.button-group button:nth-child(3) > i.fa.fa-exchange")
	private WebElement CompareThisProduct;
	@FindBy(xpath="//a[contains(text(),'Your Store')]")
	private WebElement YourStore;
	
	
	
	public  ProductSearch_page()
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
	public String displyed_product()
	{
		String product=displyed_product.getText();
		return product;
	}
	public String NoProductMatches()
	{
		String noproduct= no_product_match.getText();
		return noproduct;
		 
	}
	public String mac()
	{
		String text=mac.getText();
		return text;
	}
	public String Imac()
	{
		String text=Imac.getText();
		return text;
		
	}
	public String MacBookAir()
	{
		String text=MacBookAir.getText();
		return text;
	}
    
	public String serchCreteriaPlaceHolder()
	{
		String placeholder=serchCreteriaPlaceHolder.getAttribute("placeholder");
		return placeholder;
	}
	public String  serchPlaceHolder()
	{
		 String serch_place=serchPlaceHolder.getAttribute("value");
		 return serch_place;
		 
	}
	public void SerchCreteriaField(String s)
	{
		SerchCreteriaField.sendKeys(s);
		
	}
	public void SerchField_Icon()
	{
		SerchField_Icon.click();
	}
	public void AllCategory_Mac(int value)
	{
	
		Select s=new Select(all_categegory);
		s.selectByIndex(value);
	}
	public void AllCategory_pc(int value)
	{
	
		Select s=new Select(all_categegory);
		s.selectByIndex(value);
	}
	public void SearchInSubCategories()
	{
		SearchInSubCategories.click();
	}
	public void SingleProductInList()
	{
		listOptions.click();
	}
	public Boolean AddtoCart()
	{
		Boolean cart=addtocart.isDisplayed();
		return cart;
	}
	public String AddToWishList()
	{
	String wish=addtowishlist.getAttribute("data-original-title");
	return wish;
	}
	public String  CompareThisProduct()
	{    
		
        String compare=CompareThisProduct.getAttribute("data-toggle");
		 return compare;
	}
	public Boolean SingleProduct()
	{
	Boolean single=single_product.isDisplayed();
		return single;
		
	}
	public void clickOnImage()
	{
		single_product.click();
	}
	public String YourStore()
	{
	String	stor=YourStore.getText();
	return stor;
	}
	public void SelectGride()
	{
		 GrideOption.click();
		
	}
	
	public List<WebElement> VerifyOneMoreProduct() 
	{
		
		List<WebElement> list=driver.findElements(By.cssSelector("div.container:nth-child(4) div.row div.col-sm-12 div.row:nth-child(8) div.product-layout.product-grid.col-lg-3.col-md-3.col-sm-6.col-xs-12:nth-child(n) div.product-thumb div:nth-child(2) div.caption h4:nth-child(1) > a:nth-child(1)"));
		return list;

		}
	public Boolean  SortingA_Z() throws InterruptedException
	{
		List sortedproduct=new LinkedList();

		Select s=new Select(driver.findElement(By.xpath("//select[@id='input-sort']")));
		s.selectByIndex(1);
		
		List<WebElement> list=driver.findElements(By.cssSelector("div.container:nth-child(4) div.row div.col-sm-12 div.row:nth-child(8) div.product-layout.product-grid.col-lg-3.col-md-3.col-sm-6.col-xs-12:nth-child(n) div.product-thumb div:nth-child(2) div.caption h4:nth-child(1) > a:nth-child(1)"));
		for (WebElement webElement : list) {
			
			sortedproduct.add(webElement.getText());
			}
		
		List temp=new ArrayList();
		temp.addAll(sortedproduct);
		Collections.sort(temp,Collections.reverseOrder());
		System.out.println(temp);
		System.out.println(sortedproduct);
		
		if(sortedproduct.equals(temp))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	
	}
	
	
	
}
