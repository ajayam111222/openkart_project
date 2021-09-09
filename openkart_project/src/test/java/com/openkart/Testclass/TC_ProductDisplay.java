package com.openkart.Testclass;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.openkart.Baseclass.Basepage;
import com.openkart.Pageobject.ProductDisplay_Page;

public class TC_ProductDisplay extends Basepage{
	Boolean expected=true;
	ProductDisplay_Page p;
	@Test(priority=1,enabled=true)
	public void VerifyTheBrandNameCodeProductName_001()
	{
		p=new ProductDisplay_Page();
		p.SearchBox("iMac");
		p.searchicon();
		p.ProductDisplay();
		Boolean ActualPname=p.ProducName();
		Assert.assertEquals(ActualPname, expected);
		Boolean ActualBrand=p.Brand();
		Assert.assertEquals(ActualBrand, expected);
		Boolean Actualcode=p.ProducName();
		Assert.assertEquals(Actualcode, expected);
	 }
	@Test(priority=2,enabled=true)
	public void VerifyAvailabilityStatus()
	{
		p=new ProductDisplay_Page();
		p.SearchBox("iMac");
		p.searchicon();
		p.ProductDisplay();
        Boolean ActualAvailabiltyStatus=p.AvailabilityStatus();
        Assert.assertEquals(ActualAvailabiltyStatus, expected);
     }
	@Test(priority=3,enabled=true)
	public void VerifyTheDefaultQuantiyOne()
	{
		p=new ProductDisplay_Page();
		p.SearchBox("iMac");
		p.searchicon();
		p.ProductDisplay();
String ActualQuantity=p.QuantityField();
Assert.assertEquals(ActualQuantity, "1");
       
String ActualupdateValue=p.QuantityFieldIncrease("3");
Assert.assertEquals(ActualupdateValue, "3");
           p.AddToCart();
      }
	@Test(priority=4)
	public void VerifyRatingSucessMessage()
	{
		p=new ProductDisplay_Page();
		p.SearchBox("iMac");
		p.searchicon();
		p.ProductDisplay();
		p.Review();
		p.Yourname("ajay");
		p.Yourreview("your product is awosem its realy helpfull to us we will looking to product in feature");
		p.rating();
		p.continu();
String actualtext=p.SuccessMessageForRating();
Assert.assertEquals(actualtext, " Thank you for your review. It has been submitted to the webmaster for approval.");
	}
	
	
	

}
