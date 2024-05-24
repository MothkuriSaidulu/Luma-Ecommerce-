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
	private WebElement creatAnAct_txt;

	@FindBy(xpath = "//li[@class='authorization-link']")
	private WebElement signin_txt;

	public void verifyHomeTitle() {

		try {
			String pageTitle = driver.getTitle();
			Assert.assertEquals("Home Page", pageTitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(" ******** User Landed on Home Page Successfully ********");
		
	}

	public void clickOnCreateAnAccount() {
		Click(creatAnAct_txt, "Click on Create an account");
	}

	public void clickOnSignIn() {
		Click(signin_txt, "User clicking on sign in option");
	}

}
