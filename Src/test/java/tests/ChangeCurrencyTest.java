package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pagesObject.HomePage;
import pagesObject.ProductDetalisPage;
import pagesObject.Registrationpage;
import pagesObject.SearchPage;

public class ChangeCurrencyTest extends TestBase {

	HomePage homeobject ;
	ProductDetalisPage detailsobject ;
	SearchPage searchobject ;
	String ProductName = "Apple MacBook Pro 13-inch" ;
	Registrationpage registerobject ;

	@Test(priority = 1)
	public void UserCanChangeCurrency () {

		homeobject = new HomePage(driver);
		homeobject.ChangeCurrency();
		


	}

	@Test (priority = 2)
	public void UserCanSearchAuto () throws InterruptedException  {

		searchobject = new SearchPage(driver);
		searchobject.ProductSearchAutoSuggest("MacB");
		detailsobject = new ProductDetalisPage(driver);
		Assert.assertEquals(detailsobject.ProductNamebreadCramb.getText(),(ProductName));
		Assert.assertTrue(detailsobject.ProductPriceLabel.getText().contains("€"));

	}
	
	//@Test (priority = 3)
	//public void RegisterUserCanLogout() {

		//registerobject.userLogout() ;

	//}

}
