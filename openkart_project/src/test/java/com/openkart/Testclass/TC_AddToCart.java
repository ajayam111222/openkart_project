package com.openkart.Testclass;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.openkart.Baseclass.Basepage;
import com.openkart.Pageobject.AddToCart_Page;

public class TC_AddToCart extends Basepage{
	AddToCart_Page a;
	Boolean Expected=true;
	@Test(priority=1,enabled=true)
	public void VerifyAddToCart_001() throws InterruptedException
	{
		a=new AddToCart_Page();
		a.SearchBox("iMac");
		a.searchicon();
		a.ProductDisplay();
		a.AddToCart();
Boolean ActualDisply=a.AddTocartSuccessMessage();
Assert.assertEquals(ActualDisply, Expected);
        
        a.ShopingCartLink();
Boolean Act_displayed=a.ProductInShopingCart();
Assert.assertTrue(Act_displayed, "iMac");
log.info("product is added to shopping cart successfully ");
		
	}
	@Test(priority=2)
	public void VerifyAddingProductToCartFromSearchResultsPage_002() throws InterruptedException
	{
		a=new AddToCart_Page();
		a.SearchBox("iMac");
		a.searchicon();
		a.ADDToCart();
		a.Item();
		a.ViewCart();
Boolean Act_displayed=a.ProductInShopingCart();
Assert.assertTrue(Act_displayed, "iMac");
log.info("product is added to shopping cart successfully ");
		
	}

}
