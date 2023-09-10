package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pagesObject.ComparePage;
import pagesObject.ProductDetalisPage;
import pagesObject.SearchPage;

public class AddProductToCompareTest extends TestBase {

	SearchPage searchobject ;
	ProductDetalisPage detalisobject ;
	String ProductName1 = "Apple MacBook Pro 13-inch" ;
	String ProductName2 = "Asus N551JK-XO076H Laptop" ;
	ComparePage compareobject ;



	@Test (priority = 1)
	public void UserCanSearchAuto1 () throws InterruptedException  {

		searchobject = new SearchPage(driver);
		searchobject.ProductSearchAutoSuggest("MacB");
		detalisobject = new ProductDetalisPage(driver);
		Assert.assertEquals(detalisobject.ProductNamebreadCramb.getText(),(ProductName1));

	}

	@Test (priority = 2)
	public void UserCanAddToCompare1 () {

		detalisobject = new ProductDetalisPage(driver);
		detalisobject.addtocompare();
		Assert.assertTrue(detalisobject.NotificationSuccessAddCompare.getText().contains("The product has been added to you"));

	}

	@Test (priority = 2)
	public void UserCanSearchAuto2 () throws InterruptedException  {

		searchobject = new SearchPage(driver);
		searchobject.ProductSearchAutoSuggest("Asus");
		detalisobject = new ProductDetalisPage(driver);
		Assert.assertEquals(detalisobject.ProductNamebreadCramb.getText(),(ProductName2));
	}



	@Test (priority = 3)
	public void UserCanAddToCompare2 () {

		detalisobject = new ProductDetalisPage(driver);
		detalisobject.addtocompare();


	}



	@Test (priority = 4)
	public void UserCanCompareProducts () {
		detalisobject.ProductCompareButton();
		compareobject = new ComparePage(driver);
		compareobject.CompareProducts();
		compareobject.ClearCompareList();
		Assert.assertTrue(compareobject.noData.getText().contains("You have no items to compare."));
	}

}

