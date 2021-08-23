package com.openkart.Testclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.openkart.data.XLUtils;
import com.openkart.Baseclass.Basepage;
import com.openkart.Pageobject.Login_page;
import com.openkart.Pageobject.Register_page;

public class TC_Login_001 extends Basepage{
	   Login_page l;
	   Register_page r;
	
		
	 
	@Test(priority=1)
	public void VerifyLoginWithValidCredential()
	{    r=new Register_page();
	    l=new Login_page();
        r.Myaccount();
		l.click_login();
		l.username_password(R.Getusername(),R.Getpassword());
		log.info("user entered username");
		log.info("user entered password");
		l.submitt();
		log.info("user clicked on login ");
		log.info("User logged in---- Entered my account page----success fully");

	}

	@Test(priority=2,dataProvider="LoginData")
	public void VerifyLoginWithInvalidCredential(String un,String pw) throws InterruptedException, IOException
	{   
		r=new Register_page();
		l=new Login_page();
	    r.Myaccount();
	    l.click_login();
        l.username_password(un,pw);
		log.info("user entered wrong  username");
		log.info("user entered wrong password");
		l.submitt();
		log.info("user clicked on login ");
		String Actual_message=l.getWarningMessage();
		Assert.assertEquals(Actual_message, "Warning: No match for E-Mail Address and/or Password.");
		log.info("user got warning  message -- Warning: No match for E-Mail Address and/or Password.");
		
	    }
	
	  @Test(priority=3)
	 public void VerifyLoginFieldWithoutCredential()
	  {
	   r=new Register_page();
	   l=new Login_page();
       r.Myaccount();
       l.click_login();
       l.username_password("","");
	   log.info("user entered wrong  username");
	   log.info("user entered wrong password");
	   l.submitt();
	   log.info("user clicked on login ");
	   String Actual_message=l.getWarningMessage();
	   Assert.assertEquals(Actual_message, "Warning: No match for E-Mail Address and/or Password.");
	   log.info("user got warning  message -- Warning: No match for E-Mail Address and/or Password.");
	  }
	  
	  @Test(priority=4)
	 public void VerifyForgottPasswordLinkAvailable()
	  {
		 r=new Register_page();
		 l=new Login_page();
	     r.Myaccount();
	     l.click_login();
		
	   Boolean actual_fortgotlink= l.ForgotPassworedLink();
	     Assert.assertTrue(true);
	    log.info("forgot passsword link available ");
		 
	  }
	  @Test(priority=5)
	  public void VerifyPlaceHolderTextEmailPassword() 
	  {
		  r=new Register_page();
		  l=new Login_page();
		  r.Myaccount();
		  l.click_login();
		  
		String actual_email=l.VerfiyPlaceHolderTextOfUserField();
		Assert.assertEquals(actual_email, "E-Mail Address");
		
		String actual_pass=l.VerfiyPlaceHolderTextOfPasswordfield();
		Assert.assertEquals(actual_pass, "Password");
		
		String actual_login=l.VerfiyPlaceHolderTextOfLogin();
		Assert.assertEquals(actual_login, "Login");
		
		}
	  @Test(priority=6)
	  public void VerifyLoginBrowsingBackByBackButton()
	  {
		  r=new Register_page();
		  l=new Login_page();
		  r.Myaccount();
		  l.click_login();
		  l.username_password(R.Getusername(),R.Getpassword());
		  l.submitt();
		  driver.navigate().back();
		  driver.navigate().back();
		  r.Myaccount();
		  l.click_login();
		  String actual_account_page=r.myaccount();
		  Assert.assertEquals(actual_account_page, "My Account");
		  log.info("Verify Logging into the Application and browsing back using Browser back button ");
		  
	  }
	  
	  
	  
	@DataProvider(name="LoginData")
	String [][] getData() throws Exception 
	{
		
		String path=System.getProperty("user.dir")+"/src/test/java/com/openkart/data/DatadrievenOpenKart.xlsx";
		
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}

}
