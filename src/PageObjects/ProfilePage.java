package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
	WebDriver driver = null;
	
	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element
	By account = By.cssSelector("a[class='account']");
	By orderhistory = By.cssSelector("i.icon-list-ol");
	By historyprice = By.cssSelector("td.history_price span");
	
	//Methods
	public WebElement AccountInfo() {
		return driver.findElement(account);
	}
	public WebElement OrderHistory() {
		return driver.findElement(orderhistory);
	}
	public WebElement HistoryPrice() {
		return driver.findElement(historyprice);
	}

}
