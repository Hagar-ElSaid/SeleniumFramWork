package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pagesObject.HomePage;

public class ProductHoverMenuTest extends TestBase{

	HomePage  homeobject ;

	@Test 
	public void UserCanSelectSubCategegoryFormMainMenu() {
		homeobject = new HomePage(driver);
		homeobject.SelectNoteboxMenue();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));

	}


}
