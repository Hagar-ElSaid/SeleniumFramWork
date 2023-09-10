package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pagesObject.ProductDetalisPage;
import pagesObject.SearchPage;
import pagesObject.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase {


	SearchPage searchobject ;
	ProductDetalisPage detalisobject ;
	String ProductName = "Apple MacBook Pro 13-inch" ;
	ShoppingCartPage cartobject ;
	String quantityProductEdit = "4";


	@Test (priority = 1)
	public void UserCanSearchAuto1 () throws InterruptedException  {

		searchobject = new SearchPage(driver);
		searchobject.ProductSearchAutoSuggest("MacB");
		detalisobject = new ProductDetalisPage(driver);
		Assert.assertEquals(detalisobject.ProductNamebreadCramb.getText(),(ProductName));
	}

	@Test (priority = 2 )
	public void UserCanAddToCart () {
		detalisobject.AddToCart();
		Assert.assertTrue(detalisobject.NotificationSuccessAddCompare.getText().contains("The product has been added to your"));
		detalisobject.ClicktoCartPage();
		cartobject = new ShoppingCartPage(driver);
		Assert.assertTrue(cartobject.ProductNameResult.getText().contains("Apple MacBook Pro 13-inch"));

	}

	@Test (priority = 3 )
	public void UserCanEditOfQuantityOfProduct () {
		cartobject = new ShoppingCartPage(driver);
		cartobject.UpdateProductQuantityCart(quantityProductEdit);
		Assert.assertTrue(cartobject.total.getText().contains("$7,200.00"));
	}
	@Test (priority = 4 )
	public void UserCanRemoveProduct () {

		cartobject.RemoveProductFromCart();
		Assert.assertTrue(cartobject.Result.getText().contains("Your Shopping Cart is empty!"));
	}
}
