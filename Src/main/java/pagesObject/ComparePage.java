package pagesObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase {

	public ComparePage(WebDriver driver) {
		super(driver);
	}

	@FindBy ( css = "tabel.compare-products-table")
	WebElement TabelCompare ;

	@FindBy ( css = "a.clear-list")
	WebElement ClearListButton ;

	@FindBy (tagName = "tr")
	public List<WebElement> allRows ;

	@FindBy (tagName = "td")
	public List<WebElement> allCol ;

	@FindBy ( css ="div.page-body")
	public WebElement noData ;


	public void ClearCompareList() {

		clickButton(ClearListButton);

	}
	public void CompareProducts() {
		//get all Rows
		System.out.println(allRows.size());

		// get data from each row

		for (WebElement row : allRows) {
			System.out.println(row.getText() + "\t");

			for (WebElement col : allCol) {
				System.out.println(col.getText() + "\t");

			}

		}

	}


}
