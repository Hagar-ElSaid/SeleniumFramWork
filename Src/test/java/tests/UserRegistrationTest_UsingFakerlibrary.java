package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

//import com.github.javafaker.Faker;

import pagesObject.HomePage;
import pagesObject.LoginPage;
import pagesObject.Registrationpage;

public class UserRegistrationTest_UsingFakerlibrary extends TestBase {

	HomePage homeobject;
	Registrationpage registerobject ;
	LoginPage loginobject ;
	String firstName = "Hagar";
	String lastName = "ElSaid";
	String email = "Hagar33@gmail.com";
	String password = "123456";
	/*
	 * Faker fakeDate = new Faker() ; String firstName = fakeDate.name().firstName()
	 * ; String lastName = fakeDate.name().lastName() ; String email =
	 * fakeDate.internet().emailAddress() ; String password =
	 * fakeDate.number().digits(8).toString();
	 */

	@Test (priority = 1  , alwaysRun = true)
	public void UserCanRegisterSucess() {


		homeobject = new HomePage(driver);
		homeobject.OpenRegisterPage();
		registerobject = new Registrationpage(driver);
		registerobject.UserRegistration(firstName, lastName, email, password);
		Assert.assertTrue(registerobject.registrationCompleted.getText().contains("registration completed"));

	}
	@Test (dependsOnMethods = {"RestierUserCanlogin"})
	public void RegisterUserCanLogout() {

		registerobject.userLogout() ;

	}

	@Test (dependsOnMethods = {"UserCanRegisterSucess"})
	public void RestierUserCanlogin() {
		homeobject.OpenLoginPage();
		loginobject = new LoginPage(driver);
		loginobject.UserLogin(email, password);
	}
	
	
}
