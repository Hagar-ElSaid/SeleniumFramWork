package pagesObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddReviewPage extends PageBase{

	public AddReviewPage(WebDriver driver) {
		super(driver);
	}


	@FindBy (id = "AddProductReview_Title")
	WebElement AddProductReviewTitleTxt ;

	@FindBy (id = "AddProductReview_ReviewText")
	WebElement AddProductReview_ReviewTextTxt ;

	@FindBy (id = "addproductrating_2")
	WebElement ratingRdiBtn ;

	@FindBy (css = "button.button-1.write-product-review-button")
	WebElement SubmitReviewBtn ;

	@FindBy ( css = "div.result")
	public WebElement ReviewResult ; 


	public void AddReview ( String ReviewTitle , String ReviewText ) {
		setText(AddProductReviewTitleTxt, ReviewTitle);
		setText(AddProductReview_ReviewTextTxt, ReviewText );
		clickButton(ratingRdiBtn);
		clickButton(SubmitReviewBtn);
	}

}


