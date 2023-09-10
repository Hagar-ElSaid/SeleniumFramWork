package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pagesObject.AddReviewPage;
import pagesObject.EmailPage;
import pagesObject.HomePage;
import pagesObject.LoginPage;
import pagesObject.ProductDetalisPage;
import pagesObject.Registrationpage;
import pagesObject.SearchPage;

public class AddReviewTest extends TestBase{

	SearchPage searchobject ;
	ProductDetalisPage detalisobject ;
	String ProductName = "Apple MacBook Pro 13-inch" ;
	HomePage homeobject;
	Registrationpage registerobject ;
	LoginPage loginobject ;
	EmailPage emailobject ;
	String frstName = "Hagar"  ;
	String	lastName = "Elsaaid";
	String password = "123456" ;
	String email ="hagar81408@gmail.com";
	AddReviewPage reviewobject ;
	String ReviewTitle = "My Review";
	String ReviewText = "This is product is useful ";



	@Test (priority = 1  , alwaysRun = true)
	public void UserCanRegisterSucess()  {


		homeobject = new HomePage(driver);
		homeobject.OpenRegisterPage();
		registerobject = new Registrationpage(driver);
		registerobject.UserRegistration(frstName , lastName ,email , password);
		Assert.assertTrue(registerobject.registrationCompleted.getText().contains("registration completed"));
	}


	@Test (priority =3)
	public void RestierUserCanlogin()  {


		homeobject.OpenLoginPage();
		loginobject = new LoginPage(driver);
		loginobject.UserLogin(email,password);
	}



	@Test (priority =2)
	public void UserCanSearchAuto () throws InterruptedException  {

		searchobject = new SearchPage(driver);
		searchobject.ProductSearchAutoSuggest("MacB");
		detalisobject = new ProductDetalisPage(driver);
		Assert.assertEquals(detalisobject.ProductNamebreadCramb.getText(),(ProductName));

	}



	@Test (priority = 4)
	public void UserCanAddReview ()  {

		detalisobject.AddYourReview();
		reviewobject  = new AddReviewPage(driver);
		reviewobject.AddReview(ReviewTitle, ReviewText);
		Assert.assertTrue(reviewobject.ReviewResult.getText().contains("Product review is successfully added."));
	}
	@Test (priority = 5)
	public void RegisterUserCanLogout() {

		registerobject.userLogout() ;

	}

}
