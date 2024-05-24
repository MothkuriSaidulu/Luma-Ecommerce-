package pages;

import java.util.List;

import org.bouncycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actions.OnlineActions;

public class Page_05_LandingPage extends OnlineActions {

//	WebDriver driver = new ChromeDriver();

	String name = "Women";

	public Page_05_LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	String str = "Women"
//	descendant  --> grand parent to child

	@FindBy(xpath = "//span[text()='Women']")
	WebElement women;

	@FindBy(xpath = "//ul[@id='ui-id-2']/descendant::span[text()='Women']")
	private WebElement Women_title;

	// Women top
	@FindBy(xpath = "//ul[@id='ui-id-2']/descendant::span[text()='Women']/parent::a/following-sibling::ul/descendant::span[text()='Tops']")
	private WebElement women_tops_text;

	// Women Bottom
	@FindBy(xpath = "//ul[@id='ui-id-2']/descendant::span[text()='Women']/parent::a/following-sibling::ul/descendant::span[text()='Bottoms']")
	private WebElement woment_bottoms_text;

	// Women tops models
	@FindBy(xpath = "//ul[@id='ui-id-2']/descendant::span[text()='Women']/parent::a/following-sibling::ul/descendant::span[text()='Jackets']")
	private WebElement tops_models;

	@FindBy(xpath = "//ul[@id='ui-id-2']/descendant::span[text()='Women']/parent::a/following-sibling::ul/descendant::span[text()='Hoodies & Sweatshirts']")
	private WebElement Hoodies_Sweatshirts;

	@FindBy(xpath = "//ul[@id='ui-id-2']/descendant::span[text()='Women']/parent::a/following-sibling::ul/descendant::span[text()='Tees']")
	private WebElement Tees;

	@FindBy(xpath = "//ul[@id='ui-id-2']/descendant::span[text()='Women']/parent::a/following-sibling::ul/descendant::span[text()='Bras & Tanks']")
	private WebElement Bras_Tanks;

	// Women Bottom Models
	@FindBy(xpath = "//ul[@id='ui-id-2']/descendant::span[text()='Women']/parent::a/following-sibling::ul/descendant::span[text()='Pants']")
	private WebElement pants;

	@FindBy(xpath = "//ul[@id='ui-id-2']/descendant::span[text()='Women']/parent::a/following-sibling::ul/descendant::span[text()='Shorts']")
	private WebElement Shorts;

	@FindBy(xpath = "//h1[@class='page-title']")
	private WebElement pageTitle;

	@FindBy(xpath = "//div[@class='product-item-info']/descendant::strong")
	private List<WebElement> listOfDresses;

	@FindBy(xpath = "//div[@class='product details product-item-details']//div[@class='product details product-item-details']/parent::strong/following-sibling::div/descendant::div[@aria-label='XS']")
	private WebElement size;
	
	@FindBy(xpath = "//div[@class='product details product-item-details']//a[contains(text(),'Juno Jacket')]")
	private WebElement text;

	public void verifyPageTitle() {

		try {
			String pageTitle = driver.getTitle();
			Assert.assertEquals("Home Page", pageTitle);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void selectDressType() {

		try {
			action = new Actions(driver);

//			WaitForWebElementToVisable(women, "");

			Thread.sleep(4000);
			action.moveToElement(Women_title).build().perform();

//			WaitForWebElementToVisable(women_tops_text, "women_tops_text");
			action.moveToElement(women_tops_text).build().perform();
			
//			WaitForWebElementToVisable(tops_models, "tops_models");
			action.moveToElement(tops_models).click().build().perform();

//			String title = pageTitle.getText();
//			Assert.assertEquals("Jackets", title);

			VerifyText(pageTitle, "Page title", "Jackets");

			for (int i = 0; i < listOfDresses.size(); i++) {
				String dressModelName = listOfDresses.get(i).getText();
				if (dressModelName.equalsIgnoreCase("Juno Jacket")) {
					text.click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

//		action.moveToElement(woment_bottoms_text).build().perform();

	}

}