package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.compress.archivers.sevenz.CLI;
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

	@FindBy(xpath = "//strong[@class='product name product-item-name']")
	private List<WebElement> listOfDresses;

//	@FindBy(xpath = "//div[@class='product details product-item-details']//a[contains(text(),'Juno Jacket')]")
//	private WebElement text;

	@FindBy(xpath = "//strong[@class='product name product-item-name']/following-sibling::div/descendant::div[@option-label='XS']") // "//div[@class='product
																																	// details
																																	// product-item-details']/descendant::div[@option-label='XS']")
	private WebElement size;

	@FindBy(xpath = "//div[@class='product-add-form']/descendant::div[@option-label='Blue']")
	private WebElement colour;

	@FindBy(xpath = "//div[@class='product-add-form']/descendant::button")
	private WebElement addToCart;

	@FindBy(xpath = "//div[@class='page messages']/descendant::div[@data-ui-id='message-success']")
	private WebElement success_msg;

	@FindBy(xpath = "//div[@data-block='minicart']")
	private WebElement Cart;

	@FindBy(xpath = "//div[@class='minicart-items-wrapper']//span[@class='price']")
	private WebElement priceOfItems;

	@FindBy(xpath = "//div[@class='block-content']/descendant::input[contains(@id,'cart-item')]")
	private WebElement noOfItems;

	@FindBy(xpath = "//div[@id='minicart-content-wrapper']/descendant::button[@id='top-cart-btn-checkout']")
	private WebElement ProceedToCheckOut;

	public void verifyPageTitle() {

		try {
			String pageTitle = driver.getTitle();
			Assert.assertEquals("Home Page", pageTitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectDressType() throws InterruptedException {
		action = new Actions(driver);

		try {
			Thread.sleep(4000);
			action.moveToElement(Women_title).build().perform();
			action.moveToElement(women_tops_text).build().perform();
			action.moveToElement(tops_models).click().build().perform();

			VerifyText(pageTitle, "Page title", "Jackets");

			for (int i = 0; i < listOfDresses.size(); i++) {
				String itemName = listOfDresses.get(i).getText();
				if (itemName.contains("Neve Studio Dance Jacket")) {
					listOfDresses.get(i).click();
					break;
				}
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

//	Select multiple dress items
	public void selectMultipleDressItems() throws InterruptedException {

		try {
			action = new Actions(driver);

			action.moveToElement(Women_title).build().perform();
			action.moveToElement(women_tops_text).build().perform();
			action.moveToElement(tops_models).click().build().perform();

			VerifyText(pageTitle, "Page title", "Jackets");

			ArrayList<String> listOfItems = new ArrayList<String>();
			listOfItems.add("Neve Studio Dance Jacket");
			listOfItems.add("Nadia Elements Shell");

			for (int i = 0; i < listOfDresses.size(); i++) {
				String WebItemName = listOfDresses.get(i).getText();
//				System.out.println(WebItemName);
				for (int j = 0; j < listOfItems.size(); j++) {
					String listItemName = listOfItems.get(j);
//					System.out.println(listItemName);
					if (WebItemName.contains(listItemName)) {
//						size.click();

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectDressSizeAndColour() throws InterruptedException {

		Thread.sleep(4000);
		Click(size, "CLick on size");
		Click(colour, "colour");
		Click(addToCart, "Click on Add to Cart");
	}

	public void verifySucessMsgAndClickOnCart() throws InterruptedException {

		System.out.println(success_msg.getText());
		VerifyText(success_msg, "success_msg", "You added Neve Studio Dance Jacket to your shopping cart.");
//		System.out.println("Success message verified ");
		Thread.sleep(3000);
		Click(Cart, "click on cart ");
//		System.out.println("Clicked on Cart");
		Click(ProceedToCheckOut, "Click on proceed to check out");

//		System.out.println(" Clicked on Proceed to  check out ");

	}

	public void itemCalculations() {

	}
}