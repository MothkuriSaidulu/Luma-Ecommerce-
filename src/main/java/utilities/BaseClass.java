package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Page_01_HomePage;
import pages.Page_02_CreateNewCustomerAccount;
import pages.Page_03_MyAccount;
import pages.Page_04_Customer_Login;
import pages.Page_05_LandingPage;

public class BaseClass {

	public static WebDriver driver;
	public static Properties property;
	public static FileInputStream file;
	public static String getPropertyValue;
	public static String rootPath = System.getProperty("user.dir");
	public Page_01_HomePage homePageObject;
	public Page_02_CreateNewCustomerAccount createAccountObject;
	public Page_03_MyAccount myAccountObject;
	public Page_04_Customer_Login customerLoginObject;
	public Page_05_LandingPage landingObject;  
//	public static Assert assertObject;
		
	public static Actions action;
	
	
	
	public static Properties PropteryFile() throws IOException {
		try {
			property = new Properties();
			file = new FileInputStream("Config.properties");
			property.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return property;

	}

	public static void LaunchTheBrowser() throws IOException {

		try {
			property = PropteryFile();
			getPropertyValue = property.getProperty("Browser"); // Browser
			if (getPropertyValue.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.setPageLoadStrategy(PageLoadStrategy.EAGER);
				driver = new ChromeDriver(options);
			} else {
				WebDriverManager.edgedriver().setup();
				EdgeOptions optiones = new EdgeOptions();
				optiones.setPageLoadStrategy(PageLoadStrategy.EAGER);
				driver = new EdgeDriver();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		System.out.println(" *********  Browser Launched Successfully *********  ");
	}

	public static void getUrl() throws IOException {
		property = PropteryFile();
		getPropertyValue = property.getProperty("Url");
		driver.get(getPropertyValue);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void CloseBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
}
