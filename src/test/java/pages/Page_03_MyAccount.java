package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;

public class Page_03_MyAccount extends OnlineActions {

	public static WebDriver driver;

	public Page_03_MyAccount(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='message-success success message']")
	private WebElement successMessage_txt;

	@FindBy(xpath = "//span[@data-ui-id='page-title-wrapper']")
	private WebElement MyAccountPageTitle;

	public void verifySuccessMsg() throws InterruptedException {
//		VerifyText(successMessage_txt, "verify Successfull msg ", "Thank you for registering with Main Website Store.");
		Thread.sleep(6000);
		Assert.assertEquals("Thank you for registering with Main Website Store.", successMessage_txt.getText());
		System.out.println(" User Landed on My account page :  " + successMessage_txt.getText());
	}

	public void verifyMyAccountPageTitle() {

		VerifyText(MyAccountPageTitle, "Verify Page Title", "My Account");
		System.out.println(" **********  User Landed on My Account page Successfully  **********  ");

	}
}
