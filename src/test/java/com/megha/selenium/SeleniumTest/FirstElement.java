package com.megha.selenium.SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class FirstElement {
	
	@Test
	public void compare() throws InterruptedException{
		
		System.setProperty("webdriver.gecko.driver", "/Users/megharastogi/Downloads/geckodriver");
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com");
		driver.findElement(By.id("lst-ib")).sendKeys("cheese");
		driver.findElement(By.id("_fZl")).click();
		
		List<WebElement> elements = driver.findElements(By.xpath(".//div[@id='rso']//h3/a"));
		
		for(WebElement i : elements)
		{
			System.out.println(i.getAttribute("href"));
		}
		
		elements.get(2).click();
		
		Thread.sleep(3000);
		driver.quit();
		
	}
}