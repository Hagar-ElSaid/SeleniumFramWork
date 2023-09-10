package pagesObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(linkText =  "Change password")
	WebElement ChangePasswored ;

	@FindBy ( id ="OldPassword")
	WebElement OldPasswordTxt ;

	@FindBy ( id ="NewPassword")
	WebElement NewPasswordTxt ;

	@FindBy ( id ="ConfirmNewPassword")
	WebElement ConfirmNewPasswordTxt ;

	@FindBy (css = "button.button-1.change-password-button")
	WebElement ChangeBtn ;

	@FindBy (css ="p.content")
	public WebElement result ;

	@FindBy (css = "span.close")
	WebElement close ;

	public void OpenchangepasswordPage () {

		clickButton(ChangePasswored);
	}
	public void ChangePassword (String oldpassword , String newpassword ) {

		setText(OldPasswordTxt, oldpassword);
		setText(NewPasswordTxt, newpassword);
		setText(ConfirmNewPasswordTxt, newpassword);
		clickButton(ChangeBtn);
		clickButton(close);

	}





}
