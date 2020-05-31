package Testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Baseclass;

public class LoginTest {
	public WebDriver driver;

	@BeforeTest
	public void initalizeTest() throws IOException {
		driver = Baseclass.initializeDriver();
		String URL = Baseclass.externalData.getProperty("url");
		driver.get(URL);
	}
	
	@Test
	public void Login() {
		Baseclass.performLogin();
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
