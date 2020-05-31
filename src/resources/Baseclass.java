package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import PageObjects.AccountCreationPage;
import PageObjects.E2EPage;
import PageObjects.LoginPage;
import PageObjects.ProfilePage;

public class Baseclass {
	
	public static WebDriver driver = null;
	public static Properties externalData =  new Properties();
	static LoginPage signin = null;
	
	public static WebDriver initializeDriver() throws IOException {
		String filePath = System.getProperty("user.dir");
		//externalData = new Properties();
		FileInputStream file = new FileInputStream(filePath + "\\src\\resources\\data.properties");
		externalData.load(file);
		String browserName = externalData.getProperty("browser");
		if(browserName.equals("chrome")) {			//for chrome
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) { 	// for firefox
			System.setProperty("webdriver.firefox.driver", "C:\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE")) {		// for IE
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			driver = new InternetExplorerDriver();
		}
		
		// Defining the timeout for how many seconds the application should wait before 
		// giving timeout
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static void createNewAccount() {
		AccountCreationPage newAccount = new AccountCreationPage(driver);
		newAccount.loginButton().click();
		newAccount.registerEmail().sendKeys(externalData.getProperty("username") + Keys.ENTER);
		newAccount.gender().click();
		newAccount.firstName().sendKeys("Bobby");
		newAccount.lastName().sendKeys("Singer");
		newAccount.registerPassword().sendKeys("123456");
		newAccount.selectDate().selectByVisibleText("3  ");
		newAccount.selectMonth().selectByVisibleText("November ");
		newAccount.selectYear().selectByVisibleText("1996  ");
		newAccount.companyName().sendKeys("ABC Enterprise");
		newAccount.Address1().sendKeys("E1-North Street");
		newAccount.Address2().sendKeys("Sioux Falls");
		newAccount.City().sendKeys("South Dakota");
		newAccount.selectState().selectByVisibleText("Wisconsin");
		newAccount.ZipCode().sendKeys("00000");
		newAccount.MobileNo().sendKeys("8888774477");
		newAccount.Submit().click();
	}
	
	public static void Login() {
		signin = new LoginPage(driver);
		signin.loginButton().click();
		signin.LoginEmail().sendKeys(externalData.getProperty("username"));
		signin.LoginPassword().sendKeys(externalData.getProperty("password"));
		signin.Submit().click();
	}
	
	public static void performLogin() {
		Login();
	}
	
	public static void performE2E() {
		Login();
		
		E2EPage e2e = new E2EPage(driver);
		e2e.WomenSection().click();
		e2e.QuickView();
		e2e.IncrementQuantity().click();
		e2e.AddToCart1().click();
		e2e.ProceedToCheckout().click();
		String cartPrice = e2e.CartPrice().getText();
		e2e.ProceedToAddress().click();
		e2e.ProcessAddress().click();
		e2e.TermsandCondition().click();
		e2e.ProceedToCourier().click();
		e2e.Payment().click();
		String finalPrice = e2e.FinalPrice().getText();
		//Verifying the total cost of product with order product cost
		Assert.assertEquals(cartPrice, finalPrice);
		e2e.ConfirmOrder().click();
		// Under Profile 
		ProfilePage profile = new ProfilePage(driver);
		profile.AccountInfo().click();
		profile.OrderHistory().click();
		String historyPrice = profile.HistoryPrice().getText();
		//Under 
		Assert.assertEquals(historyPrice, finalPrice);
	}
	
}
