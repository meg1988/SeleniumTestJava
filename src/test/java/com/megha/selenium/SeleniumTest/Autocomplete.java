package com.megha.selenium.SeleniumTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Autocomplete {
	
	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver", "/Users/megharastogi/PycharmProjects/SeleniumProject/lib/geckodriver");
		driver = new FirefoxDriver();
		baseUrl = "http://www.southwest.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		
		driver.get(baseUrl);
		String searchingText = "New York/Newark, NJ - EWR";
		String partialText = "New York";
		
		WebElement departField = driver.findElement(By.id("air-city-departure"));
		departField.sendKeys(partialText);
		
		List<WebElement> departOption = driver.findElements(By.xpath(".//ul[@id='air-city-departure-menu']//li"));
		int size = departOption.size();
		
		for (int i = 0; i < size; i++) {
			System.out.println("********************");
			System.out.println(departOption.get(i).getText());
		}
		
		for (WebElement element : departOption)
		{
			if((element.getText()).equals(searchingText))
			{
				element.click();
				System.out.println("Selected: " + element.getText());
				break;
			}
		}
	}
	
		@After
		public void tearDown()
		{
			//driver.quit();
		}
		
}


