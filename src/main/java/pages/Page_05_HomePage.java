package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;

public class Page_05_HomePage extends OnlineActions {
	
	public static WebDriver driver;
	
	public Page_05_HomePage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Women']")
	private WebElement Women_title;
	
	@FindBy(xpath = "//a[@href='https://magento.softwaretestingboard.com/women/tops-women.html']")
	private WebElement topsWomen_option;
	
	@FindBy(xpath = "//a[@href='https://magento.softwaretestingboard.com/women/bottoms-women.html']")
	private WebElement bottomsWomen_option;
		

	
}