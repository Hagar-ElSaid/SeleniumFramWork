package pagesObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductDetalisPage extends PageBase{

	public ProductDetalisPage(WebDriver driver) {
		super(driver);

	}
	@FindBy (css = "button.button-2.email-a-friend-button")
	WebElement EmailFrind ;
	@FindBy ( css = "strong.current-item")
	public WebElement ProductNamebreadCramb;

	@FindBy ( css = "span.price-value-4")
	public WebElement ProductPriceLabel ;

	@FindBy (linkText = "Add your review")
	WebElement AddYourReview ;

	@FindBy (id = "add-to-wishlist-button-4")
	WebElement AddToWishlist ;

	@FindBy (linkText = "wishlist")
	public WebElement WishlistPage ;

	@FindBy (css ="p.content")
	public WebElement NotificationSuccess;

	@FindBy ( css ="button.button-2.add-to-compare-list-button")
	WebElement AddToCompareButton ;

	@FindBy (css = "p.content")
	public WebElement NotificationSuccessAddCompare;

	@FindBy (linkText = "product comparison")
	WebElement ProductComparisonButton ;

	@FindBy (id ="add-to-cart-button-4")
	WebElement AddToCartButton ;

	@FindBy (linkText  = "shopping cart")
	public WebElement CartPage ;

	@FindBy (css = "div.bar-notification.success")
	public WebElement NotificationSuccessAddCart;

	public void EmailFrind () {

		clickButton(EmailFrind);
	}

	public void AddYourReview () {
		clickButton(AddYourReview);

	}

	public void AddToWishlist() {
		clickButton(AddToWishlist);

	}
	public void Wishlistpage() {
		clickButton(WishlistPage);

	}

	public void addtocompare() {
		clickButton(AddToCompareButton);

	}

	public void ProductCompareButton() {
		clickButton(ProductComparisonButton);

	}

	public void AddToCart() {

		clickButton(AddToCartButton);

	}
	public void ClicktoCartPage() {

		clickButton(CartPage);

	}

}

