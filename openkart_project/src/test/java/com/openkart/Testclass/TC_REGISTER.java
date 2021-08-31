package com.openkart.Testclass;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.openkart.Baseclass.Basepage;
import com.openkart.Pageobject.Register_page;





public class TC_REGISTER extends Basepage
{
	
	Register_page r;
	
	@Test(priority=1)
	public void verify_account_by_providing_all_mandatory_filed()
	{
		 r=new Register_page();
		 log.info("clicked on register button");
		 r.Myaccount();
		 log.info("clicked on the register button");
		 r.register();
		 r.firstname_lastname("ajay", "am");
		 log.info("entered firstname and lastname");
		 
		 String email_pass=randomeString()+"@gmail.com";
		 
		 r.email(email_pass);
		 log.info("entered email address");
		 r.phone_number("9353615291");
		 log.info("entered the phone number");
		 r.password("ajay1234");
		 r.confirm_password("ajay1234");
		 log.info("entered the password");
		 log.info("no newsletter option selected");
		 r.privacy();
		 r.continu();
		 log.info("click on the continue button ");
		 
		String actual_message= r.verify_account_created();
		Assert.assertEquals(actual_message, "Your Account Has Been Created!");
		log.info("account created successfully");
		
		r.click_continue();
		
		String actual_myaccount=r.myaccount();
		Assert.assertEquals(actual_myaccount, "My Account");
		log.info("User successfully visited to my account ");
	}
	
	@Test(priority=2)
	public void verify_YES_option_selected()
	{
		r=new Register_page();
		 log.info("clicked on register button");
		 r.Myaccount();
		 log.info("clicked on the register button");
		 r.register();
		 r.firstname_lastname("ajay", "am");
		 log.info("entered firstname and lastname");
		 
		 String email_pass=randomeString()+"@gmail.com";
		 
		 r.email(email_pass);
		 log.info("entered email address");
		 r.phone_number("9353615291");
		 log.info("entered the phone number");
		 r.password("ajay1234");
		 r.confirm_password("ajay1234");
		 log.info("entered the password");
		 r.yes_option_newsletter();
		 log.info("yes option news letter  selected");
		 r.privacy();
		 r.continu();
		 log.info("click on the continue button ");
		 r.click_continue();
		 r.subscribe_unscibe_newsletter();
		 log.info("clicked on subscribe/unscribe news letter");
		 Boolean yes_option= r.yes_option_selected();
		 Assert.assertTrue(true);
		 log.info("yes option selected sucessfully");
		}
	@Test(priority=3)
     public void verify_NO_option_selcted()
	  {
		verify_account_by_providing_all_mandatory_filed();
		
		r.subscribe_unscibe_newsletter();
		log.info("clicked on subscribe/unscribe news letter");
		Boolean NO_option_selected=r.no_option_selected();
		Assert.assertTrue(true);
		log.info("NO option is selected successfully");
	
	  }
	
	@Test(priority=4)
	public void different_way_navigate_Register()
	{   r=new Register_page();
		r.Myaccount();
		r.login();
		r.Newcustomer();
		boolean registe=r.register_page();
		Assert.assertTrue(true);
		log.info("Navigate to the register page through login successfully");
	}
	@Test(priority=5)
	public void verify_registeraccount_with_differentpassword()
	{    r=new Register_page();
		 r.Myaccount();
		 log.info("clicked on the register button");
		 r.register();
		 r.firstname_lastname("ajay", "am");
		 log.info("entered firstname and lastname");
		 
		 String email_pass=randomeString()+"@gmail.com";
		 r.email(email_pass);
		 log.info("entered email address");
		 
		 r.phone_number("9353615291");
		 log.info("entered the phone number");
		 
		 log.info("different password enterd");
		 
		 r.password("ajay");
		 log.info("password---ajay");
		 
		 r.confirm_password("1234");
		 
		 log.info("password--1234");
		 
		 log.info("no newsletter option selected");
		 
		 r.privacy();
		 r.continu();
		 String actual_text=r.password_not_match();
		 Assert.assertEquals(actual_text,"Password confirmation does not match password!");
		 log.info("password does not matched message dispalyed");
		
	}
	@Test(priority=6)
	public void verifyAccountByProvidingExistingDetails()
	{
		 r=new Register_page();
		log.info("clicked on register button");
		 r.Myaccount();
		 log.info("clicked on the register button");
		 r.register();
		 r.firstname_lastname("ajay", "am");
		 log.info("entered firstname and lastname");
		 
		 //String email_pass=randomeString()+"@gmail.com";
		 
		 r.email("ajayam1234@gmail.com");
		 log.info("entered email address");
		 r.phone_number("9353615291");
		 log.info("entered the phone number");
		 r.password("ajay1234");
		 r.confirm_password("ajay1234");
		 log.info("entered the password");
		 log.info("no newsletter option selected");
		 r.privacy();
		 r.continu();
		 log.info("click on the continue button ");
		
	     Boolean actual_rext= r.verify_accoun_already_register();
	     Assert.assertTrue(true);
	     log.info("displyed successfully----account already register ");
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
