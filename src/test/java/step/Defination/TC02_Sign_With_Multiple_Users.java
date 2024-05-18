package step.Defination;


import io.cucumber.java.en.*;
import pages.Page_01_HomePage;
import pages.Page_04_Customer_Login;
import utilities.BaseClass;

public class TC02_Sign_With_Multiple_Users extends BaseClass {



	@When("user clicked on signin option.")
	public void user_clicked_on_signin_option() {
		homePageObject = new Page_01_HomePage(driver);
		homePageObject.clickOnSignIn();
	}

	@Then("verify user landed on Customer Login page.")
	public void verify_user_landed_on_customer_login_page() {
		customerLoginObject = new Page_04_Customer_Login(driver);
		customerLoginObject.verifyCustomerLoginPageTitle();
	}

	@And("user entered emailId As {string} and password as {string}.")
	public void user_entered_email_id_as_and_password_as(String emailID, String password) {
		customerLoginObject = new Page_04_Customer_Login(driver);
		customerLoginObject.enterEmailID(emailID);
		customerLoginObject.enterPassword(password);
	}

	@And("user clicked on signin button.")
	public void user_clicked_on_signin_button() {
		customerLoginObject = new Page_04_Customer_Login(driver);
		customerLoginObject.clickOnSignInBtn();
	}

	@Then("verify landed on home page.")
	public void verify_landed_on_home_page() {

	}

}
