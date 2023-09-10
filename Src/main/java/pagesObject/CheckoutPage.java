package pagesObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class CheckoutPage extends PageBase {

	public CheckoutPage(WebDriver driver) {
		super(driver);

	}

	@FindBy (id = "BillingNewAddress_CountryId")
	WebElement CountryList ;

	@FindBy (id = "BillingNewAddress_StateProvinceId")
	WebElement StateProvinceIdList ;

	@FindBy (id = "BillingNewAddress_City")
	public WebElement CityTxt ;


	@FindBy (id = "BillingNewAddress_Address1")
	WebElement Address1Txt ;

	@FindBy (id = "BillingNewAddress_ZipPostalCode")
	WebElement ZipPostalCodeTxt ;

	@FindBy (id = "BillingNewAddress_PhoneNumber")
	WebElement PhoneNumberTxt ; 


	@FindBy (css = "button.button-1.new-address-next-step-button")
	WebElement ContnueButton1; 


	@FindBy (id = "shippingoption_1")
	WebElement shippingoptionRadiobutton; 

	@FindBy (css ="button.button-1.shipping-method-next-step-button")
	WebElement ContnueButton2;

	@FindBy (css ="button.button-1.payment-method-next-step-button")
	WebElement ContnueButton3 ;

	@FindBy (css = "button.button-1.payment-info-next-step-button")
	WebElement ContnueButton4 ;

	@FindBy (css ="a.product-name")
	public WebElement productName ;

	@FindBy (css = "button.button-1.confirm-order-next-step-button")
	WebElement  confirmbutton;

	@FindBy (css ="div.page-title")
	public WebElement SuccessMessage ;

	@FindBy (linkText = "Click here for order details.")
	WebElement OrderDetailsLink ;

	@FindBy (css ="button.button-1.checkout-as-guest-button")
	WebElement  checkoutAsGguestButton;

	@FindBy (id ="BillingNewAddress_FirstName")
	WebElement FirstNameTxt;

	@FindBy (id ="BillingNewAddress_LastName")
	WebElement LastNameTxt ;

	@FindBy (id ="BillingNewAddress_Email")
	WebElement EmailTxt ;

	@FindBy (css= "div.page-title")
	public WebElement resultOfPageCheckout ;



	public void CheckoutProduct (String CountryName ,String StateProvince , String City , String Address1 ,String PostCode , String phone ) throws InterruptedException {
		select = new Select (CountryList);
		select.selectByVisibleText(CountryName);
		select = new Select (StateProvinceIdList);
		select.selectByVisibleText(StateProvince);
		setText(CityTxt, City);
		setText(Address1Txt, Address1);
		setText(ZipPostalCodeTxt, PostCode);
		setText(PhoneNumberTxt, phone);
		clickButton(ContnueButton1);
		clickButton(shippingoptionRadiobutton);
		Thread.sleep(1000);
		clickButton(ContnueButton2);
		Thread.sleep(1000);
		clickButton(ContnueButton3);
		Thread.sleep(1000);
		clickButton(ContnueButton4);

	}
	public  void ConfirmOrder() throws InterruptedException {
		Thread.sleep(1000);
		clickButton(confirmbutton);
	}

	public void clickOrderDetails() {
		clickButton(OrderDetailsLink);
	}

	public void clickCheckoutAsGuestButton() {
		clickButton(checkoutAsGguestButton);

	}
	public void CheckoutProductAsAGuest (String firstname,String lastname,String email ,  String CountryName ,String StateProvince , String City , String Address1 ,String PostCode , String phone ) throws InterruptedException {
		setText(FirstNameTxt, firstname);
		setText(LastNameTxt, lastname);
		setText(EmailTxt, email);
		select = new Select (CountryList);
		select.selectByVisibleText(CountryName);
		select = new Select (StateProvinceIdList);
		select.selectByVisibleText(StateProvince);
		setText(CityTxt, City);
		setText(Address1Txt, Address1);
		setText(ZipPostalCodeTxt, PostCode);
		setText(PhoneNumberTxt, phone);
		clickButton(ContnueButton1);
		clickButton(shippingoptionRadiobutton);
		Thread.sleep(1000);
		clickButton(ContnueButton2);
		Thread.sleep(1000);
		clickButton(ContnueButton3);
		Thread.sleep(1000);
		clickButton(ContnueButton4);
	}
}
