package com.openkart.Pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.openkart.Baseclass.Basepage;



public class Register_page extends Basepage{
	@FindBy(xpath="//span[contains(text(),'My Account')]")
	private WebElement Myaccount;
	@FindBy(xpath="//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]")
	private WebElement login;
	@FindBy(xpath="//a[contains(text(),'Continue')]")
	private WebElement New_customer;
	@FindBy(xpath="//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[1]/a[1]")
	private WebElement Register;
	@FindBy(id="input-firstname")
	private WebElement firstname;
	@FindBy(id="input-lastname")
	private WebElement lastname;
	@FindBy(id="input-email")
	private WebElement email;
	@FindBy(id="input-telephone")
	private WebElement phonnumber;
	@FindBy(id="input-password")
	private WebElement password;
	@FindBy(id="input-confirm")
	private WebElement confirm_password;
	@FindBy(xpath="//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]")
	private WebElement privacy_policy;
	@FindBy(xpath="//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]")
	private WebElement continu;
	@FindBy(xpath="//h1[contains(text(),'Your Account Has Been Created!')]")
	private WebElement confirmmessage;
	@FindBy(xpath="//a[contains(text(),'Continue')]")
	private WebElement continu2;
	@FindBy(xpath="//h2[contains(text(),'My Account')]")
	private WebElement myaccount;
	@FindBy(xpath="//a[contains(text(),'Subscribe / unsubscribe to newsletter')]")
	private WebElement subscribe_unscibe_newsletter;
	@FindBy(xpath="//body/div[@id='account-newsletter']/div[1]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/label[2]/input[1]")
	private WebElement no_option_selected;
	@FindBy(xpath="//body/div[@id='account-register']/div[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/label[1]/input[1]")
	private WebElement yes_option_newsletter;
	@FindBy(xpath="//body/div[@id='account-newsletter']/div[1]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/label[1]/input[1]")
	private WebElement yes_option_selected;
	@FindBy(xpath="//h1[contains(text(),'Register Account')]")
	private WebElement register_text;
	@FindBy(xpath="//div[contains(text(),'Password confirmation does not match password!')]")
	private WebElement password_not_match;
	
	
	public Register_page()
	{
		PageFactory.initElements(driver, this);
	}
	
	 WebDriverWait wait=new WebDriverWait(driver,40);
	
	public void Myaccount()
	{
		Myaccount.click();
	}
	public void register()
	{
		Register.click();
	}
	public void firstname_lastname(String Fname,String Lname)
	{
		firstname.sendKeys(Fname);
		lastname.sendKeys(Lname);
	}
	public void email(String mail)
	{
		email.sendKeys(mail);
	}
	public void phone_number(String number)
	{
		phonnumber.sendKeys(number);
	}
	public void password(String pass) 
	{
		password.sendKeys(pass);
	}
	public void confirm_password(String cpass)
	{
		confirm_password.sendKeys(cpass);
	}
	public void privacy()
	{
		privacy_policy.click();
	}
	public void continu()
	{
		continu.click();
	}
	public String verify_account_created()
	{
		String text=confirmmessage.getText();
		return text;
	}
	public void click_continue()
	{
		continu2.click();
	}
	public String myaccount()
	{
		String text1=myaccount.getText();
		return text1;
	}
	public void yes_option_newsletter()
	   {
		   yes_option_newsletter.click();
	   }
	   public Boolean yes_option_selected()
	   {
		  Boolean yes_selected= yes_option_selected.isSelected();
		  return yes_selected;
	   }
   public void subscribe_unscibe_newsletter()
   {
	   subscribe_unscibe_newsletter.click();
   }
   public boolean no_option_selected()
   {
	  boolean selected= no_option_selected.isSelected();
	  return selected;
   }
   public void login()
   {
	   login.click();
   }
   public void Newcustomer()
   { 
	  // wait.until(ExpectedConditions.visibilityOf(New_customer));
	   
	   New_customer.click();
   }
   public Boolean register_page()
   {
	   Boolean registeraccount=register_text.isDisplayed();
	   return registeraccount;
   }
   public String password_not_match()
   {
	  String  not_match= password_not_match.getText();
	  return not_match;
   }
}
