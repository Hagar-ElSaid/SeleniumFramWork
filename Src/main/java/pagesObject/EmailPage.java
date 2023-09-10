package pagesObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase{

	public EmailPage(WebDriver driver) {
		super(driver);

	}
	@FindBy ( id ="FriendEmail")
	WebElement FrindEmailTxt ;


	@FindBy (id = "PersonalMessage")
	WebElement PersonalMessageTxt ;

	@FindBy (css="button.button-1.send-email-a-friend-button")
	WebElement SendEmailBtn ;

	@FindBy  (css ="div.result")
	public WebElement EmailSend;

	public void SendMailToFrined  (String firnedmail , String message) {

		setText(FrindEmailTxt, firnedmail);
		setText(PersonalMessageTxt, message);
		clickButton(SendEmailBtn);
	}



}
