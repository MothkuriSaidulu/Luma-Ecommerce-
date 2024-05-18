package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;

public class Page_04_Customer_Login extends OnlineActions {

	public static WebDriver driver;

		public Page_04_Customer_Login(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Customer Login']")
	private static WebElement pageTitle;

	@FindBy(id = "email")
	private static WebElement emailId_txt;

	@FindBy(xpath = "//input[@title='Password']")
	private static WebElement password_txt;

	@FindBy(css = "button[name='send']")
	private static WebElement submit_btn;

	public static void verifyCustomerLoginPageTitle() {
		VerifyText(pageTitle, "customer login page title ", "Customer Login");
//		Assert.assertEquals("Customer Login", driver.getTitle());
		System.out.println(" ***********  User Landed On Customer Login page *********** ");
	}

	public static void enterEmailID(String EmailID) {

		EnterText(emailId_txt, "User entering Emailid", EmailID);

	}

	public static void enterPassword(String password) {
		EnterText(password_txt, "Password text ", password);
	}

	public static void clickOnSignInBtn() {
		Click(submit_btn, "user clicked on submit button ");
	}

}
