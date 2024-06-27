package step.Defination;

import io.cucumber.java.en.*;
import pages.Page_05_LandingPage;
import utilities.BaseClass;

public class TC05_PlaceMultipleOrders extends BaseClass{

	@Then("select multiple dress.")
	public void select_multiple_dress() throws InterruptedException {
		landingObject = new Page_05_LandingPage(driver);
		landingObject.selectMultipleDressItems();
		
	
	
	
	}
}