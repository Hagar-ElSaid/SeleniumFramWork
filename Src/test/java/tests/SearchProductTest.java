package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pagesObject.ProductDetalisPage;
import pagesObject.SearchPage;

public class SearchProductTest extends TestBase{

	String ProductName = "Apple MacBook Pro 13-inch" ;
	SearchPage searchobject ;
	ProductDetalisPage detalisobject ;

	@Test

	public void UserCanSearchProduct () {

		searchobject = new SearchPage(driver);
		detalisobject = new ProductDetalisPage(driver);
		searchobject.ProductSearch(ProductName);
		searchobject.OpenProductDetialsPage();
		Assert.assertTrue(detalisobject.ProductNamebreadCramb.getText().equalsIgnoreCase(ProductName));

	}

}
