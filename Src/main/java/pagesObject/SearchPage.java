package pagesObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);

	}
	@FindBy ( id ="small-searchterms")
	WebElement searchTextBox ; 

	@FindBy (css = "button.button-1.search-box-button" )
	WebElement searchBtn ;

	@FindBy ( id="ui-id-1")
	java.util.List<WebElement> productList ;

	@FindBy (linkText ="Apple MacBook Pro 13-inch")
	WebElement ProductTitle ;




	public void ProductSearch (String ProductName) {

		setText(searchTextBox, ProductName);
		clickButton(searchBtn);
	}
	public void OpenProductDetialsPage() {

		clickButton(ProductTitle);
	}

	public void ProductSearchAutoSuggest (String searchTxt) throws InterruptedException {
		setText(searchTextBox, searchTxt);
		Thread.sleep(3000);
		productList.get(0).click();

	}

}