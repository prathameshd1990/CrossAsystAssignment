package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import resources.Baseclass;

public class AccountCreationPage extends Baseclass{
	
	WebDriver driver = null;
	
	public AccountCreationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Elements
	By login = By.cssSelector("a[class='login']");
	By Email = By.cssSelector("input#email_create");
	By gender = By.xpath("//input[@id='id_gender1']");
	By firstname = By.name("customer_firstname"); 
	By lastname = By.name("customer_lastname");
	By Password = By.cssSelector("input[id='passwd']");
	By date = By.id("days");
	By month = By.id("months");
	By year = By.id("years");
	By company = By.xpath("//input[@id='company']");
	By address1 = By.cssSelector("input[name='address1']");
	By address2 = By.cssSelector("input[name='address2']");
	By city = By.name("city");
	By state = By.id("id_state");
	By zipcode = By.cssSelector("input#postcode");
	By mobileno = By.cssSelector("input[name='phone_mobile']");
	By submit = By.name("submitAccount");
	
	//Methods
	public WebElement loginButton() {
		return driver.findElement(login);
	}
	public WebElement registerEmail() {
		return driver.findElement(Email);
	}
	public WebElement gender() {
		return driver.findElement(gender);
	}
	public WebElement firstName() {
		return driver.findElement(firstname);
	}
	public WebElement lastName() {
		return driver.findElement(lastname);
	}
	public WebElement registerPassword() {
		return driver.findElement(Password);
	}
	public Select selectDate() {
		Select dob = new Select(driver.findElement(date));
		return dob;
	}
	public Select selectMonth() {
		Select mob = new Select(driver.findElement(month));
		return mob;
	}
	public Select selectYear() {
		Select yob = new Select(driver.findElement(year));
		return yob;
	}
	public WebElement companyName() {
		return driver.findElement(company);
	}
	public WebElement Address1() {
		return driver.findElement(address1);
	}
	public WebElement Address2() {
		return driver.findElement(address2);
	}
	public WebElement City() {
		return driver.findElement(city);
	}
	public Select selectState() {
		Select stateselected = new Select(driver.findElement(state));
		return stateselected;
	}
	public WebElement ZipCode() {
		return driver.findElement(zipcode);
	}
	public WebElement MobileNo() {
		return driver.findElement(mobileno);
	}
	public WebElement Submit() {
		return driver.findElement(submit);
	}
}
