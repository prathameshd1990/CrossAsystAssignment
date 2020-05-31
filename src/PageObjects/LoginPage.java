package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver = null;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	By login = By.cssSelector("a[class='login']");
	By loginemail = By.cssSelector("input#email");
	By loginpassword = By.cssSelector("input#passwd");
	By submit = By.name("SubmitLogin");
	
	
	public WebElement loginButton() {
		return driver.findElement(login);
	}
	public WebElement LoginEmail() {
		return driver.findElement(loginemail);
	}
	public WebElement LoginPassword() {
		return driver.findElement(loginpassword);
	}
	public WebElement Submit() {
		return driver.findElement(submit);
	}
}
