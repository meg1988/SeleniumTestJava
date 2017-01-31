package com.megha.selenium.SeleniumTest;

import org.apache.commons.io.FileUtils;

import org.junit.Ignore;
import org.testng.annotations.Test;
//import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class Example {
	
	@Ignore
	@Test()
	public void test() throws InterruptedException,IOException {
		
		//System.setProperty("webdriver.gecko.driver", "/Users/megharastogi/Downloads/geckodriver");
		//WebDriver driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "/Users/megharastogi/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();

		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://letskodeit.teachable.com/pages/practice");
		
		Thread.sleep(1000);
		
		WebElement element = driver.findElement(By.xpath(".//input[@id='name']"));
		element.sendKeys("Hello");
		
		Thread.sleep(3000);
		
		driver.navigate().refresh();
		
		Thread.sleep(3000);
		driver.navigate().to("https://letskodeit.teachable.com");
		
		Thread.sleep(3000);
		driver.navigate().back();
		
		Thread.sleep(3000);
		driver.navigate().forward();
		
		Thread.sleep(3000);
		driver.navigate().back();

		Thread.sleep(3000);
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		element = driver.findElement(By.xpath(".//input[@id='name']"));
		element.sendKeys("Hello");
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("alertbtn")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().alert().accept();
		
		Thread.sleep(3000);
		
		Long randomFile = new Date().getTime()*1000 ;
		String randomFileName = randomFile.toString() + ".png";
		File destinationDirectory = new File("/Users/megharastogi/Desktop/" + randomFileName);
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, destinationDirectory);
		
		
		
		String parentHandle = driver.getWindowHandle();
		driver.findElement(By.id("openwindow")).click();
		
		Set<String> handles = driver.getWindowHandles();
		for (String a : handles)
		{
			if (a.equals(parentHandle))
			{
				continue;
			}
			else 				
			{
				driver.switchTo().window(a);
				Thread.sleep(3000);
				driver.findElement(By.id("search-courses")).sendKeys("java");
				Thread.sleep(3000);
				driver.close();
				break;
			}
		}
		
		driver.switchTo().window(parentHandle);
		Thread.sleep(3000);
		/*
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.id("name")));
		element4.click();
		
		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement element5 = wait2.until(new Function<WebDriver, WebElement>(){
				public WebElement apply(WebDriver driver) {
				// TODO Auto-generated method stub
				return driver.findElement(By.id("name"));
			}
			
		});*/
		
		if (driver instanceof JavascriptExecutor) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
			js.executeScript("window.scrollBy(0,700);");
			 
			WebElement element3 = (WebElement) js.executeScript("return document.getElementById('displayed-text');");
			element3.sendKeys("Javascript");
			
			Thread.sleep(3000);
			
		    js.executeScript("window.scrollBy(0,1200);");
		    
		    Thread.sleep(3000);
		    
		    js.executeScript("window.scrollBy(0,-700);");

		    
		} else {
		    throw new IllegalStateException("This driver does not support JavaScript!");
		}
		
		
		//js.executeScript("window.scrollBy(0,1200);");
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("courses-iframe");
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("search-courses")).sendKeys("Java");
		
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("bmwradio")).click();
		
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("mousehover"))).perform();
		
		
		Thread.sleep(2000);
		
		action.click(driver.findElement(By.xpath(".//div[@class='mouse-hover-content']//a[text()='Top']")));
		
		Thread.sleep(2000);

		Select sel = new Select(driver.findElement(By.id("carselect")));
		
		sel.selectByIndex(2);
		
		Thread.sleep(2000);
		
		sel.selectByValue("bmw");
		
		Thread.sleep(2000);

		sel.selectByVisibleText("Honda");
		
		Thread.sleep(2000);

		
		driver.quit();
				
	}
	
	@Ignore
	@Test
	public void test2() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver","/Users/megharastogi/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1500,1000));
		driver.get("http://jqueryui.com");
		
		Thread.sleep(3000);
		
		//Assert.assertEquals("Title not correct",driver.getTitle(),"Gmail");
		
		driver.findElement(By.xpath(".//*[@id='sidebar']//a[text()='Droppable']")).click();
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		
		Actions actions = new Actions(driver);
		actions.dragAndDrop(drag, drop).perform();
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);

		driver.findElement(By.xpath(".//*[@id='sidebar']//a[text()='Droppable']")).click();
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		
		drag = driver.findElement(By.id("draggable"));
		drop = driver.findElement(By.id("droppable"));
		
		Action dragging = actions.clickAndHold(drag).moveToElement(drop).release().build();
		dragging.perform();
		Thread.sleep(3000);

		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		
		Action type = actions.click(driver.findElement(By.name("s"))).keyDown(Keys.SHIFT).sendKeys("hello").keyUp(Keys.SHIFT).doubleClick().contextClick().build();
		type.perform();
		
		Thread.sleep(3000);

		driver.quit();
	}
	
}
