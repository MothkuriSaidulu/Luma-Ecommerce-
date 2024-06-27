package step.Defination;

import actions.OnlineActions;
import io.cucumber.java.en.Then;
import pages.Page_05_LandingPage;
import utilities.BaseClass;

public class TC03_PlaceSingleOrder extends BaseClass{

	@Then("select dress type.")
	public void select_dress_type() throws InterruptedException {
		landingObject = new Page_05_LandingPage(driver);
		landingObject.selectDressType();
		System.out.println("selected dress type.");
	}

	@Then("select size and colour click on add to cart.")
	public void select_size_and_colour_click_on_add_to_cart() throws InterruptedException {
		landingObject = new Page_05_LandingPage(driver);
		landingObject.selectDressSizeAndColour();
		System.out.println("select size and colour click on add to cart.");

	}

	@Then("verify sucessfull message and click on cart.")
	public void verify_sucessfull_message_and_click_on_cart() throws InterruptedException {
		landingObject = new Page_05_LandingPage(driver);
		landingObject.verifySucessMsgAndClickOnCart();

	}

}
