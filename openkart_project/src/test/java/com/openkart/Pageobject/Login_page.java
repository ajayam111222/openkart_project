package com.openkart.Pageobject;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.openkart.Baseclass.Basepage;

public class Login_page extends Basepage{
	
	@FindBy(xpath="//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]")
	private WebElement login;
	@FindBy(id="input-email")
	private WebElement username;
	@FindBy(id="input-password")
	private WebElement password;
    @FindBy(xpath="//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]")
    private WebElement submit;
    @FindBy(xpath="//body/div[@id='account-login']/div[1]")
    private WebElement warning_message;    
    @FindBy(xpath="//body/div[@id='account-login']/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/a[1]")
    private WebElement ForgotPassworedLink;
    @FindBy(css=" div.container:nth-child(4) div.row div.col-sm-9 div.row div.col-sm-6:nth-child(2) div.well form:nth-child(3) div.form-group:nth-child(2) > a:nth-child(3)")
    private WebElement ForgotPassworedLink1;
   
    
    public Login_page()
    {
    	PageFactory.initElements(driver, this);
    }

	public void click_login()
	{
		login.click();
		
	}
	public void username_password(String un,String pw)
	{  
        username.sendKeys(un);
		password.sendKeys(pw);
	}
	public void submitt()
	{
		submit.click();
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments&#91;0].click();", submit);
	}
	public String getWarningMessage()
	{
		String message=warning_message.getText();
		return message;
	}
	
	public Boolean ForgotPassworedLink()
	{   
		/* WebDriverWait wait=new WebDriverWait(driver,40);
		Boolean  text=wait.until(ExpectedConditions.visibilityOf(ForgotPassworedLink)).isDisplayed();
		return text;
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(1, TimeUnit.MINUTES)
			       .pollingEvery(20, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);

			   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			       WebElement display= driver.findElement(By.xpath("//body/div[@id='account-login']/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/a[1]"));
			       if(display.isDisplayed())
			       {
			    	   System.out.println("we found element ");
			       }
			       return display;
			     }
			   });
			 Boolean value=  foo.isDisplayed();
			 System.out.println(value);
			 return value; */
		
		
	    boolean forgot=ForgotPassworedLink1.isDisplayed();
		return forgot;
	}
	public String VerfiyPlaceHolderTextOfUserField()
	{
		String inner=username.getAttribute("placeholder");
		return inner;
	}
	public String VerfiyPlaceHolderTextOfPasswordfield()
	{
		String inner1=password.getAttribute("placeholder");
		return inner1;
	}
	public String VerfiyPlaceHolderTextOfLogin()
	{
		String inn=submit.getAttribute("value");
		return inn;
	}

}
