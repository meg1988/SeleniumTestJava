package com.megha.selenium.SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class CompareStockPrice {
	
	@Test
	public void compare(){
		
		System.setProperty("webdriver.gecko.driver", "/Users/megharastogi/Downloads/geckodriver");
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		
		Double pypl = getStockPrice(driver,"pypl");
		Double ebay = getStockPrice(driver,"eBay Inc stock price");
		
		System.out.println("Paypal stock -->" + pypl);
		System.out.println("Ebay stock -->" + ebay);
	
		if (pypl == ebay)
		{
			System.out.println("Paypal stock price is equal to ebay");
			
		}else if (pypl > ebay)
		{
			System.out.println("Paypal stock price is greater than ebay");
		}else
		{
			System.out.println("Ebay stock price is greater than Paypal");
		}
			
			
		driver.quit();
		

	}
	
	public Double getStockPrice(WebDriver driver, String companyName)
	
	{
		
		driver.get("https://www.google.com/");
			
		driver.findElement(By.id("lst-ib")).sendKeys(companyName);
		driver.findElement(By.id("_fZl")).click();
		
		
		
		WebElement stockPrice = driver.findElement(By.xpath(".//div[@id='fac-ut']//div[@class='_FOc']//span[@class='_Rnb fmob_pr fac-l']"));
		return (Double.parseDouble(stockPrice.getText()));
		
	}

}
