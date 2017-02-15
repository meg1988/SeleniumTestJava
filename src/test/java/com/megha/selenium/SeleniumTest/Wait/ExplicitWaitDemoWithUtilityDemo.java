package com.megha.selenium.SeleniumTest.Wait;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.megha.selenium.SeleniumTest.utilities.WaitTypes;

public class ExplicitWaitDemoWithUtilityDemo {
	
	private WebDriver driver;
	private String baseUrl;
	private WaitTypes wt;

	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "/Users/megharastogi/Downloads/geckodriver");
		driver = new FirefoxDriver();
		baseUrl = "https://letskodeit.teachable.com/pages/practice";
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wt = new WaitTypes(driver);
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		
		Thread.sleep(5000);
		driver.quit();
	}

	@Test
	public void test() {

		driver.get(baseUrl);
		WebElement loginLink = driver.findElement(By.linkText("Login"));
		loginLink.click();
		
		WebElement email_field= wt.waitForElement(By.id("user_email"), 5);
				
		email_field.sendKeys("test");
		
		wt.clickWhenReady(By.name("commit"), 3);
	}

}
