package com.megha.selenium.SeleniumTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    @Test
	public void test3() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "/Users/megharastogi/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1280,794));
		driver.get("https://www.paypal.com/");
		WebElement ebay = null;
		String ebayText = null;
		WebElement paypal = driver.findElement(By.id("ul-btn"));
		String paypalText = paypal.getText();
		String paypalWindow = driver.getWindowHandle();
		
		Thread.sleep(3000);
		
		if (driver instanceof JavascriptExecutor)
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.open('http://www.ebay.com/');");
			//driver.get("http://www.ebay.com/");
			Set<String> handles = driver.getWindowHandles();
			for (String a : handles)
			{
				if(a.equals(paypalWindow))
				continue;
				else{
					
					driver.switchTo().window(a);
					ebay = driver.findElement(By.id("gh-btn"));
					ebayText = ebay.getAttribute("value");
					Thread.sleep(3000);
					break;
				}
					
			}
			
			
		}
		else{
			 throw new IllegalStateException("This driver does not support JavaScript!");
		}
		
		driver.switchTo().window(paypalWindow);
		Thread.sleep(3000);
		System.out.println("Text at paypal is --->>" + paypalText);
		System.out.println("Text at ebay is --->>" + ebayText);

		driver.quit();
	}

}

