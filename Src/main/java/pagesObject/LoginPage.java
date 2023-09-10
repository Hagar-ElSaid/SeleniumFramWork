package pagesObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);

	}
	@FindBy (id= "Email")
	WebElement EmailTxtBox ;

	@FindBy (id= "Password")
	WebElement PasswordTxtBox ;

	@FindBy (css = "button.button-1.login-button")
	WebElement LoginBtn ;

	public void UserLogin( String  email , String password ) {

		setText(EmailTxtBox, email );
		setText(PasswordTxtBox,password); 
		clickButton(LoginBtn);
	}

}
