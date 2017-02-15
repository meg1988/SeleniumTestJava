package com.megha.selenium.SeleniumTest;

import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Screenshots {

	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver", "/Users/megharastogi/PycharmProjects/SeleniumProject/lib/geckodriver");
		driver = new FirefoxDriver();
		baseUrl = "http://www.expedia.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		
		driver.get(baseUrl);
		
		driver.findElement(By.id("tab-flight-tab")).click();
		driver.findElement(By.id("flight-origin")).sendKeys("New York");
		driver.findElement(By.id("flight-destination")).sendKeys("New York");
		driver.findElement(By.id("flight-departing")).sendKeys("02/20/2017");
		driver.findElement(By.id("flight-returning")).clear();
		driver.findElement(By.id("flight-returning")).sendKeys("02/25/2017");
		driver.findElement(By.id("search-button")).click();


	}
	
	public static String getRandomString(int length)
	{
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for (int i=0; i<length ; i++)
		{
			int index = (int)(Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}
	
	@After
	public void tearDown() throws Exception {
		String randomFileName = getRandomString(10) + ".png";
		File destinationDirectory = new File("/Users/megharastogi/Desktop/screenshots/" + randomFileName);
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, destinationDirectory);
		driver.quit();
	}

	

}
