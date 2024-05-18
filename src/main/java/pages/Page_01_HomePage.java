package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;

public class Page_01_HomePage extends OnlineActions {

	public static WebDriver driver;

	public Page_01_HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://magento.softwaretestingboard.com/customer/account/create/']")
	private static WebElement creatAnAct_txt;

	@FindBy(xpath = "//li[@class='authorization-link']")
	private static WebElement signin_txt;

	public static void verifyHomeTitle() {

		try {
			Assert.assertEquals("Home Page", driver.getTitle());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(" ******** User Landed on Home Page Successfully ********");

	}

	public static void clickOnCreateAnAccount() {
		Click(creatAnAct_txt, "Click on Create an account");
	}

	public static void clickOnSignIn() {
		Click(signin_txt, "User clicking on sign in option");
	}

}
