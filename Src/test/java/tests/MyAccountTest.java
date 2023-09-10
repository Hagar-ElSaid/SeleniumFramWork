package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pagesObject.HomePage;
import pagesObject.LoginPage;
import pagesObject.MyAccountPage;
import pagesObject.Registrationpage;

public class MyAccountTest extends TestBase{

	HomePage homeobject;
	LoginPage loginobject ;
	Registrationpage registerobject ;
	MyAccountPage myaccountobject ;
	String oldpassword = "123456" ;
	String newpassword = "123123" ;
	String firstname ="Hagar";
	String lastname ="ELSaid";
	String email ="hagar7118@gmail.com";




	@Test (priority = 1  , alwaysRun = true)
	public void UserCanRegisterSucess() {

		homeobject = new HomePage(driver);
		homeobject.OpenRegisterPage();
		registerobject = new Registrationpage(driver);
		registerobject.UserRegistration(firstname, lastname, email, oldpassword);
		Assert.assertTrue(registerobject.registrationCompleted.getText().contains("registration completed"));

	}

	@Test (dependsOnMethods = {"RestierUserCanlogin"}) 
	public void UserCanChangePasswored() {

		myaccountobject = new MyAccountPage(driver);
		registerobject.OpenMyAccountPage();
		myaccountobject.OpenchangepasswordPage();
		myaccountobject.ChangePassword(oldpassword , newpassword);
		Assert.assertTrue(myaccountobject.result.getText().contains("Password was changed"));

	}

	@Test (dependsOnMethods = {"UserCanChangePasswored"})
	public void RegisterUserCanLogout() {

		registerobject.userLogout() ;

	}

	@Test (dependsOnMethods = {"UserCanRegisterSucess"})
	public void RestierUserCanlogin() {
		homeobject.OpenLoginPage();
		loginobject = new LoginPage(driver);
		loginobject.UserLogin(email, oldpassword);

	}


}
