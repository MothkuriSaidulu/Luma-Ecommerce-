package pages;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;

public class Page_02_CreateNewCustomerAccount extends OnlineActions {

	public static WebDriver driver;

	public Page_02_CreateNewCustomerAccount(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[@data-ui-id='page-title-wrapper']")
	private static WebElement pageTitle;

	@FindBy(id = "firstname")
	private static WebElement firstName_txt;

	@FindBy(id = "lastname")
	private static WebElement lastName_txt;

	@FindBy(css = "input[name='email']")
	private static WebElement email_txt;

	@FindBy(xpath = "//input[@name='password']")
	private static WebElement password_txt;

	@FindBy(css = "input[title='Confirm Password']")
	private static WebElement confirmPassword_txt;

	@FindBy(xpath = "//button[@title='Create an Account']")
	private static WebElement createAccount_btn;

	@FindBy(xpath = "//div[@class='mage-error']")
	private static WebElement error_msg;

	@FindBy(xpath = "//div[@class='message-success success message']")
	private static WebElement successMessage_txt;

//	Actions
	public static void verifyPageTitle() {
		VerifyText(pageTitle, " Verify Page Title ", "Create New Customer Account");

	}

	public static void enterFirstName() {

		String firstName = "ram" + randomString();
		EnterText(firstName_txt, " User entering first name ", firstName);
		System.out.println(" User First Name : " + firstName);
	}

	public static void enterLastName() {
		String lastName = "ram" + randomString();
		EnterText(lastName_txt, "User Entered Last Name ", lastName);
		System.out.println(" User Last Name : " + lastName);
	}

	public static void enterEmailID() {
		String randomEmailID = randomString() + "@Yopmail.com";
		EnterText(email_txt, "User enetering emailid", randomEmailID);
		System.out.println(" User Email Id : " + randomEmailID);
	}

	public static void enterPassword() {
		String randomStringPassword = randomString() + "@123";

		EnterText(password_txt, " user entering password ", randomStringPassword);
		EnterText(confirmPassword_txt, "user entering confirm password ", randomStringPassword);
		System.out.println(" User Password : " + randomStringPassword);

	}

	public static void clickOnCreateAccountBtn() throws InterruptedException {

		if (createAccount_btn.isDisplayed()) {
			Click(createAccount_btn, "User clicked on create account button");
//			Thread.sleep(10000);
		} else if (successMessage_txt.isDisplayed()) {
			System.out.println("User Landed on my account page" + successMessage_txt.getText());
		} else {
			System.out.println("Fill the required details whic is mandatory   " + error_msg.getText());
		}

	}

}
