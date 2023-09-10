package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pagesObject.ProductDetalisPage;
import pagesObject.SearchPage;
import pagesObject.WishListPage;

public class AddProductToWishListTest extends TestBase{


	SearchPage searchobject ;
	ProductDetalisPage detalisobject ;
	String ProductName = "Apple MacBook Pro 13-inch" ;
	WishListPage wishlistobject ;
	ProductDetalisPage productdetalisobject ;


	@Test (priority = 1)
	public void UserCanSearchAuto () throws InterruptedException  {

		searchobject = new SearchPage(driver);
		searchobject.ProductSearchAutoSuggest("MacB");
		detalisobject = new ProductDetalisPage(driver);
		Assert.assertEquals(detalisobject.ProductNamebreadCramb.getText(),(ProductName));

	}
	@Test (priority = 2)
	public void UserCanAddProductToWishlist() {
		productdetalisobject = new ProductDetalisPage(driver);
		productdetalisobject.AddToWishlist();
		Assert.assertTrue(productdetalisobject.NotificationSuccess.getText().contains("The product has been added to your"));
		productdetalisobject.Wishlistpage();
		wishlistobject = new WishListPage(driver);
		Assert.assertTrue(wishlistobject.PageTitleWishlist.getText().contains("Wishlist"));

	}


	@Test (priority = 3)
	public void UserCanRemoveProductFromWishlist() {
		wishlistobject = new WishListPage(driver);
		wishlistobject.RemoveProductFromWishlist();
		Assert.assertTrue(wishlistobject.EmptyWishlist.getText().contains("The wishlist is empty!"));

	}

}
