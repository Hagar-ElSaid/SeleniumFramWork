package pagesObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registrationpage extends PageBase
{

	public Registrationpage(WebDriver driver) {
		super(driver);

	}

	@FindBy( id = "gender")
	WebElement genderRadiobutton;

	@FindBy( id = "FirstName")
	WebElement Firstname;

	@FindBy( id = "LastName")
	WebElement Lastname;

	@FindBy( id = "Email")
	WebElement Email;

	@FindBy( id = "Password")
	WebElement PasswordtxtBox ;

	@FindBy( id = "ConfirmPassword")
	WebElement ConfirmPassword;

	@FindBy(id = "register-button")
	WebElement RegisterButton ;

	@FindBy(css = "div.result")
	public WebElement registrationCompleted;

	@FindBy (linkText = "Log out")
	WebElement LogoutLink ;

	@FindBy (linkText =  "My account")
	WebElement Myacount;

	public Object userLogout;

	public void UserRegistration (String firstname , String lastname , String email , String password ) {
		//genderRadiobutton.click();
		clickButton(genderRadiobutton);
		//Firstname.sendKeys(firstname);
		setText(Firstname, firstname);
		// Lastname.sendKeys(lastname);
		setText(Lastname, lastname);
		// Email.sendKeys(email);
		setText(Email, email);

		//PasswordtxtBox.sendKeys(password);
		setText(PasswordtxtBox, password);

		//ConfirmPassword.sendKeys(password);
		setText(ConfirmPassword, password);

		//RegisterButton.click();
		clickButton(RegisterButton);

	}
	public void userLogout() {

		clickButton(LogoutLink);
	}



	public void OpenMyAccountPage () {

		clickButton(Myacount);
	}
}

