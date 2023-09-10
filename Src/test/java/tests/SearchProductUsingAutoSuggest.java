package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pagesObject.ProductDetalisPage;
import pagesObject.SearchPage;


public class SearchProductUsingAutoSuggest extends TestBase{

	SearchPage searchobject ;
	ProductDetalisPage detalisobject ;
	String ProductName = "Apple MacBook Pro 13-inch" ;

	@Test 
	public void UserCanSearchAuto () throws InterruptedException  {

		searchobject = new SearchPage(driver);
		searchobject.ProductSearchAutoSuggest("MacB");
		detalisobject = new ProductDetalisPage(driver);
		Assert.assertEquals(detalisobject.ProductNamebreadCramb.getText(),(ProductName));
		
	}
}
