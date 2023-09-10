package pagesObject;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor ) driver ;
		action = new Actions(driver);
	}
	@FindBy(linkText ="Register")
	WebElement registerLink ;

	@FindBy(linkText = "Log in")
	WebElement loginlink ;

	@FindBy ( linkText = "Contact us")
	WebElement ContactUsLink ;

	@FindBy (id = "customerCurrency")
	WebElement CurrencyDDL;

	@FindBy (linkText = "Computers" )
	WebElement  ComputerMenu ;


	@FindBy ( linkText = "Notebooks")
	WebElement  NotbooksMenu ;

	public void OpenRegisterPage () {


		clickButton(registerLink);

	}
	public void OpenLoginPage () {


		clickButton(loginlink);

	}

	public void OpenContactUsPage () {

		ScrollButton();
		clickButton(ContactUsLink);
	}

	public void ChangeCurrency () {

		select = new Select (CurrencyDDL);
		select.selectByVisibleText("Euro");
	}

	public void SelectNoteboxMenue () {

		action.moveToElement(ComputerMenu).moveToElement(NotbooksMenu).click().build().perform();
	}
}
