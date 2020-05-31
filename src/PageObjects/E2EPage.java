package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class E2EPage {
	
	WebDriver driver = null;
	
	public E2EPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Elements
	By womensection = By.linkText("Women");
	By quickview = By.className("quick-view");
	By incrementQuantity = By.cssSelector("i.icon-plus");
	By addToCart1 = By.xpath("//span[text()='Add to cart']");
	By proceed1 = By.xpath("//div[@class='button-container']/a/span");
	By cartPrice = By.cssSelector("span[id='total_price']");
	By proceed2 = By.cssSelector("p[class*='cart_navigation'] a span");
	By processaddress = By.cssSelector("button[name='processAddress'] span");
	By terms = By.id("cgv");
	By proceed3 = By.name("processCarrier");
	By payment = By.cssSelector("a.bankwire");
	By finalPrice = By.xpath("//span[@id='amount']");
	By confirmOrder = By.cssSelector("button[class*='button btn btn-default button-medium'] span");
	
	
	//Methods
	public WebElement WomenSection() {
		return driver.findElement(womensection);
	}
	public void QuickView() {
		WebElement view = driver.findElement(quickview);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", view);
	}
	public WebElement IncrementQuantity() {
		return driver.findElement(incrementQuantity);
	}
	public WebElement AddToCart1() {
		return driver.findElement(addToCart1);
	}
	public WebElement ProceedToCheckout() {
		return driver.findElement(proceed1);
	}
	public WebElement CartPrice() {
		return driver.findElement(cartPrice);
	}
	public WebElement ProceedToAddress() {
		return driver.findElement(proceed2);
	}
	public WebElement ProcessAddress() {
		return driver.findElement(processaddress);
	}
	public WebElement TermsandCondition() {
		return driver.findElement(terms);
	}
	public WebElement ProceedToCourier() {
		return driver.findElement(proceed3);
	}
	public WebElement Payment() {
		return driver.findElement(payment);
	}
	public WebElement FinalPrice() {
		return driver.findElement(finalPrice);
	}
	public WebElement ConfirmOrder() {
		return driver.findElement(confirmOrder);
	}
}
