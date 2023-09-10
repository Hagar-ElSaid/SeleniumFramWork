package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pagesObject.EmailPage;
import pagesObject.HomePage;
import pagesObject.LoginPage;
import pagesObject.ProductDetalisPage;
import pagesObject.Registrationpage;
import pagesObject.SearchPage;

public class EmailFrinedTest extends TestBase{


	HomePage homeobject;
	Registrationpage registerobject ;
	LoginPage loginobject ;
	SearchPage searchobject ;
	ProductDetalisPage detalisobject ;
	String ProductName = "Apple MacBook Pro 13-inch" ;
	EmailPage emailobject ;
	String oldpassword = "123456" ;
	String email ="hagar9087@gmail.com";

	@Test (priority = 1  , alwaysRun = true)
	public void UserCanRegisterSucess() {

		homeobject = new HomePage(driver);
		homeobject.OpenRegisterPage();
		registerobject = new Registrationpage(driver);
		registerobject.UserRegistration("Hagar", "ELSaid", email, oldpassword);
		Assert.assertTrue(registerobject.registrationCompleted.getText().contains("registration completed"));

	}

	@Test (priority = 2)
	public void UserCanSearchAuto () throws InterruptedException  {

		searchobject = new SearchPage(driver);
		searchobject.ProductSearchAutoSuggest("MacB");
		detalisobject = new ProductDetalisPage(driver);
		Assert.assertEquals(detalisobject.ProductNamebreadCramb.getText(),(ProductName));

	}

@Test ( priority = 3)
	public void RestierUserCanlogin() {
		homeobject.OpenLoginPage();
		loginobject = new LoginPage(driver);
		loginobject.UserLogin(email, oldpassword);
	}

	@Test (priority = 4)
	public void RegisterUserCanSendProductToFirend () {
		detalisobject.EmailFrind();
		emailobject = new EmailPage(driver);
		emailobject.SendMailToFrined("test252@gmail.com", "Hellow best Frined");
		Assert.assertTrue(emailobject.EmailSend.getText().contains("Your message has been sent"));
	}


	@Test (priority = 5)
	public void RegisterUserCanLogout() {

		registerobject.userLogout() ;

	}
}
