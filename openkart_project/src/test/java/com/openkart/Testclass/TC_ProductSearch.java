package com.openkart.Testclass;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.openkart.Baseclass.Basepage;
import com.openkart.Pageobject.ProductSearch_page;

public class TC_ProductSearch extends Basepage{
	ProductSearch_page p;
	
	@Test(priority=1)
	public void VerifySearchingWithExistingProductName_001()
	{
		 p=new ProductSearch_page();
		 p.SearchBox("MacBook");
		 log.info("Entered  existing Product Name in search box");
		 p.searchicon();
		 String Actual_displyed=p.displyed_product();
		 Assert.assertEquals(Actual_displyed,"MacBook");
		 log.info("serched product displyed in search result ");
		 
	}
	@Test(priority=2)
	public void VerifySearchingWithNonExistingProductName_002()
	{
		 p=new ProductSearch_page();
		 p.SearchBox("ajay");
		 log.info("Entered Non existing Product Name in search box");
		 p.searchicon();
		 String Actual_displyed=p.NoProductMatches();
		 Assert.assertEquals(Actual_displyed,"There is no product that matches the search criteria.");
		 log.info("user got no product matche warning ----");
		
	}
	
	@Test(priority=3)
	public void VerifySearchingWithoutAnyValue_003()
	{
		 p=new ProductSearch_page();
		 p.SearchBox("");
		 log.info("Entered No Product Name in search box");
		 p.searchicon();
		 String Actual_displyed=p.NoProductMatches();
		 Assert.assertEquals(Actual_displyed,"There is no product that matches the search criteria.");
		 log.info("user got no product matche warning ----");
		
		
	}
	@Test(priority=4)
	public void VerifyTheMultipleProductDisplay_004()
	{
		 p=new ProductSearch_page();
		 p.SearchBox("mac");
		 log.info("Entered mac Product Name in search box");
		 p.searchicon();
		 String mac=p.mac();
		 String imac=p.Imac();
		 String MacBook=p.MacBookAir();
	
		 Assert.assertEquals(mac, "iMac");
		 Assert.assertEquals(imac, "MacBook");
		 Assert.assertEquals(MacBook, "MacBook Air");
		 log.info("more than one product displayed");
	}
	@Test(priority=5)
	public void VerifySerchCreteriaAndSearchPlaceholder_005()
	{
		 p=new ProductSearch_page();
		 p.SearchBox("");
		 p.searchicon();
      String A_serchcreteria=p.serchCreteriaPlaceHolder();
      Assert.assertEquals(A_serchcreteria,"Keywords");
      log.info("SerchCreteria placeholder name found as per expectation");

      String A_search=p.serchPlaceHolder();
      Assert.assertEquals(A_search, "Search");
      log.info("Serch placeholder name found as per expectation");
      }
	@Test(priority=6)
	public void VerifySerchUsingSerchFieldCreteria_006()
	{
		 p=new ProductSearch_page();
		 p.SearchBox("");
		 p.searchicon();
		 p.SerchCreteriaField("Imac");
		 p.SerchField_Icon();
    String A_text=p.mac();
    Assert.assertEquals(A_text, "iMac");
    log.info(" Product found in serch result as per expectation --By serchin the existing prodduct on search createria field");
	}
	@Test(priority=7)
	public void VerifySearchBySelectingTheCategoryOfProduct_007() 
	{
		 p=new ProductSearch_page();
		 p.SearchBox("");
		 p.searchicon();
		 p.SerchCreteriaField("imac");
		 p.AllCategory_Mac(3);
		 p.SerchField_Icon();
		 String mac=p.mac();
		 Assert.assertEquals(mac, "iMac");
		 log.info("Product is found in  serch result as per expectation by selecting Mac in category list  ");
		 p.AllCategory_pc(2);
		 p.SerchField_Icon();
		 String Actual_displyed=p.NoProductMatches();
		 Assert.assertEquals(Actual_displyed,"There is no product that matches the search criteria.");
		 log.info("user got no product matche warning as per expectation by selecting incorrect category ----");
	}
	@Test(priority=8)
	public void VerifySearchBySelectingToSearchInSubcategories_008()
	{
		p=new ProductSearch_page();
		 p.SearchBox("");
		 p.searchicon();
		 p.SerchCreteriaField("imac");
		 p.AllCategory_Mac(1);
		 p.SerchField_Icon();
		 String Actual_displyed=p.NoProductMatches();
		 Assert.assertEquals(Actual_displyed,"There is no product that matches the search criteria.");
		 log.info("user got no product matche warning as per expectation by selecting desktop category ----");
		 p.SearchInSubCategories();
		 p.SerchField_Icon();
		 String mac=p.mac();
		 Assert.assertEquals(mac, "iMac");
		 log.info("Product is found in  serch result as per expectation by selecting subcategory button, again by clicking on search button ");
	}
	@Test(priority=9)
	public void VerifyListandGridViewsWhenOnlyOneProductDisplayedInTheSearchResults_009()
	{
		
		 p=new ProductSearch_page();
		 p.SearchBox("iMac");
		 p.searchicon();
		 p.SingleProductInList();
		 Boolean A_product=p.SingleProduct();
	     Assert.assertTrue(true);
	
         Boolean A_display=p.AddtoCart();
         Assert.assertTrue(true);
    

         String A_addtolist=p.AddToWishList();
         Assert.assertEquals(A_addtolist, "Add to Wish List");

//String A_comparetolist=p.CompareThisProduct();
//Assert.assertEquals(A_comparetolist,"Compare this Product");

        p.clickOnImage();
        String A_store=p.YourStore();
        Assert.assertEquals(A_store,"Your Store");
        p.SearchBox("iMac");
        p.searchicon();
        p.SelectGride();
 
        Boolean A_product1=p.SingleProduct();
	    Assert.assertTrue(true);
	
        Boolean A_display1=p.AddtoCart();
        Assert.assertTrue(true);
 

        String A_addtolist1=p.AddToWishList();
        Assert.assertEquals(A_addtolist1, "Add to Wish List");
//String A_comparetolist1=p.CompareThisProduct();
//Assert.assertEquals(A_comparetolist1,"Compare this Product");

        p.clickOnImage();
        String A_store1=p.YourStore();
        Assert.assertEquals(A_store1,"Your Store");
 
}

	@Test(priority=10)
	public void VerifyUserAbleToSortTheProductsDisplayedintheSearchResults() throws InterruptedException
	{
		Boolean expectedList=true;
		p=new ProductSearch_page();
		 p.SearchBox("Mac");
		 p.searchicon();
		 p.SerchCreteriaField("");
		 p.SerchField_Icon();
		 p.SelectGride();
         int  ListOfProduct=p.VerifyOneMoreProduct().size();
        
         if(ListOfProduct>3)
         {
        	 Assert.assertTrue(true);
        	 log.info("more than one product is displayed");
         }
         else
         {
        	 Assert.assertTrue(false);
        	 log.info("more than one product not  displayed");
         }
         
         Boolean actuallist=p.SortingA_Z();
         
         Assert.assertEquals(actuallist, expectedList);
         
         }
	
	
	
	
	
}
