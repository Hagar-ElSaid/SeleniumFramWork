package pagesObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBase {

	public OrderDetailsPage(WebDriver driver) {
		super(driver);
	}
 @FindBy (css="a.button-2.print-order-button")
 WebElement PrintOrderButton;
 
 @FindBy (css= "a.button-2.pdf-invoice-button")
 WebElement PdfInvoiceButton;
 
 
 public void PrintOrderDetails() {
	clickButton(PrintOrderButton);
}
 
 public void DownloadPDFInvoice() {
		clickButton(PdfInvoiceButton);
	}
	 
 
}
