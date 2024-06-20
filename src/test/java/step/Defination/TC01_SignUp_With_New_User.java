package step.Defination;

import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.Page_01_HomePage;
import pages.Page_02_CreateNewCustomerAccount;
import pages.Page_03_MyAccount;
import utilities.BaseClass;

public class TC01_SignUp_With_New_User extends BaseClass {


	
	@Given("user launched the browser.")
	public void user_launched_the_browser() throws IOException {
		LaunchTheBrowser();
	}

	@SuppressWarnings("static-access")
	@When("user entered url verify user landed on luma home page.")
	public void user_entered_url_verify_user_landed_on_luma_home_page() throws IOException {
		getUrl();
		homePageObject = new Page_01_HomePage(driver);
		homePageObject.verifyHomeTitle();
	}

	@SuppressWarnings("static-access")
	@When("click on create an account option.")
	public void click_on_create_an_account_option() {
		homePageObject = new Page_01_HomePage(driver);
		homePageObject.clickOnCreateAnAccount();

	}

	@SuppressWarnings("static-access")
	@Then("verify user landed on create new customer account page.")
	public void verify_user_landed_on_create_new_customer_account_page() {

		createAccountObject = new Page_02_CreateNewCustomerAccount(driver);
		createAccountObject.verifyPageTitle();
	}

	@SuppressWarnings("static-access")
	@Then("fill the personal information.")
	public void fill_the_personal_information() {
		createAccountObject = new Page_02_CreateNewCustomerAccount(driver);
		createAccountObject.enterFirstName();
		createAccountObject.enterLastName();
		createAccountObject.enterEmailID();
		createAccountObject.enterPassword();
	}

	@SuppressWarnings("static-access")
	@Then("click on create and account button.")
	public void click_on_create_and_account_button() throws InterruptedException {

		createAccountObject = new Page_02_CreateNewCustomerAccount(driver);
		createAccountObject.clickOnCreateAccountBtn();
	}

	@Then("verify account created sucessfully.")
	public void verify_account_created_sucessfully() throws InterruptedException {
		myAccountObject = new Page_03_MyAccount(driver);
		myAccountObject.verifySuccessMsg();	
	}


}

