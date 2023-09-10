package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pagesObject.ContactUsPage;
import pagesObject.HomePage;

public class ContactUsPageTest extends TestBase{

	HomePage home;
	ContactUsPage contactPage ;
	String email = "hagar7705@gmail.come" ;
	String fullName ="hagar";
	String message = "Hello Test"; 


	@Test
	public void UserCanUseContactUs () {
		home = new HomePage(driver) ;
		home.OpenContactUsPage();
		contactPage = new ContactUsPage(driver);
		contactPage.ContactUs(fullName, email, message);
		Assert.assertTrue(contactPage.SuccessMessage.getText().contains("Your enquiry has been successfully sent"));

	}


}
