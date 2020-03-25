package com.dd;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class OpenAllSofware {

	@Test
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "/home/dinesh/Downloads/driver/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.saasworthy.com/");
		driver.manage().window().maximize();
		List<WebElement> count = driver.findElements(By.xpath("/html/body/div[11]/div/div/div/div/div/div/div/div[2]/span[1]/a"));
		String title = driver.findElement(By.xpath("/html/body/div[11]/div/div/h3")).getText();
		int orginalcount = count.size();		    
		System.out.println("The "+title+ " contains " +orginalcount+"pages" );
		int expectedcount =10;
		Assert.assertEquals(orginalcount, expectedcount);
		
	}
}
