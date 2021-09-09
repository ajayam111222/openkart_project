package com.openkart.Testclass;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.openkart.Baseclass.Basepage;
import com.openkart.Pageobject.Login_page;
import com.openkart.Pageobject.WishList_Page;

public class TC_WishList extends Basepage
{
	WishList_Page 	w;
	
   public void common()
	{    
	    w=new WishList_Page();
	    Login_page l=new  Login_page();
	    l.Myaccount();
	    l.click_login();
	    l.username_password("ajayam1234@gmail.com", "ajay1234");
	    l.submitt();
	}
   
	@Test(priority=1)
	public void VerifyAddingProductWishList_001()
	{   
		common();
		w.SearchBox("iMac");
		w.searchicon();
		w.ProductDisplay();
		w.WishList();
Boolean ActualDisplay=w.SuccessMessageWishList();
Assert.assertTrue(ActualDisplay," Success: You have added iMac to your wish list!");
        w.WishListLink();
Boolean ActualDisplay1=w.ProductInWishList();
Assert.assertTrue(ActualDisplay1,"iMac");
log.info("product successfully added to wishlist");
        }
	@Test(priority=2)
	public void VerifyAddingProductWishListFromFeaturedOption_002() throws InterruptedException
    {   common();
    w.yourstore();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,750)");
    w.WishList1();
    Boolean ActualDisplay=w.SuccessMessageWishList();
    Assert.assertTrue(ActualDisplay,"Success: You have added iMac to your wish list!");
    w.WishListLink();
    Boolean ActualDisplay1=w.ProductInWishList();
    Assert.assertTrue(ActualDisplay1,"iMac");
    log.info("product successfully added to wishlist");
    
	}
	
	
	
	
	
}
