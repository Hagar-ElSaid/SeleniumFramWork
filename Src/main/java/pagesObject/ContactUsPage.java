package pagesObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);

	}
	@FindBy (id ="FullName")
	WebElement FullNameTxt ;

	@FindBy (id ="Email")
	WebElement EmailTxt ;

	@FindBy (id ="Enquiry")
	WebElement EnquiryTxt ;

	@FindBy (css ="button.button-1.contact-us-button")
	WebElement SubmitBtn ;

	@FindBy ( css ="div.result")
	public WebElement SuccessMessage ;


	public void ContactUs(String fullName , String email , String message) {

		setText(FullNameTxt, fullName);
		setText(EmailTxt, email);
		setText(EnquiryTxt, message);
		clickButton(SubmitBtn);

	}
}
