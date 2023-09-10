package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pagesObject.CheckoutPage;

import pagesObject.HomePage;

import pagesObject.OrderDetailsPage;
import pagesObject.ProductDetalisPage;
import pagesObject.Registrationpage;
import pagesObject.SearchPage;
import pagesObject.ShoppingCartPage;

public class GuestCheckoutFromCartTest extends TestBase{

	SearchPage searchobject ;
	ProductDetalisPage detalisobject ;
	String ProductName = "Apple MacBook Pro 13-inch" ;
	HomePage homeobject;
	Registrationpage registerobject ;
	ShoppingCartPage cartobject ;
	CheckoutPage checkoutobject ;
	String City = "cairo" ;
	String PostCode = "123456" ;
	String Address1 = "street main behiand metro" ;
	String phone  = "1122121" ;
	ShoppingCartPage shoppingcartobject ;
	OrderDetailsPage orderdetailsobject ;
	String firstname = "Hagar";
	String lastname = "Elsaid";
	String email = "hagar128@gmail.com" ;





	@Test (priority =1)
	public void UserCanSearchAuto () throws InterruptedException  {

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

	@Test (priority = 3)
	public void UserClickCheckout () throws InterruptedException {
		shoppingcartobject = new ShoppingCartPage(driver);
		shoppingcartobject.OpenCheckoutPage();
		Assert.assertTrue(shoppingcartobject.pageTitleChechout.isDisplayed());

	}

	@Test (priority = 4)
	public void UserCanCheckout () throws InterruptedException {
		checkoutobject = new CheckoutPage(driver) ; 
		checkoutobject.clickCheckoutAsGuestButton();
		Assert.assertTrue(checkoutobject.resultOfPageCheckout.isDisplayed());
		checkoutobject.CheckoutProductAsAGuest(firstname, lastname, email, "Canada", "Quebec", City, Address1, PostCode, phone);
		Assert.assertTrue(checkoutobject.productName.getText().contains("Apple MacBook Pro 13-inch"));

	}

	@Test (priority = 5)
	public void UserCanConfirmedOrder () throws InterruptedException {
		checkoutobject = new CheckoutPage(driver) ; 
		checkoutobject.ConfirmOrder();
		Assert.assertTrue(checkoutobject.SuccessMessage.isDisplayed());
		checkoutobject.clickOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderdetailsobject = new OrderDetailsPage(driver);
		orderdetailsobject.PrintOrderDetails();
		orderdetailsobject.DownloadPDFInvoice();
	}


}
