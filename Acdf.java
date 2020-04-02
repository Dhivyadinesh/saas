package mytestcase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class Acdf {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "/home/dinesh/Downloads/driver/geckodriver");
		WebDriver driver = new FirefoxDriver();
		String url = "https://www.saasworthy.com/";
		driver.get(url);
		
		driver.findElement(By.partialLinkText("Business Intelligence Software")).click();
	    String CatgyName = driver.findElement(By.xpath("//h1[@class='list_titl titl_width']")).getText();
		String totalCount = driver.findElement(By.xpath("//span[@id='totallistCount']")).getText();
		System.out.println("The total count of "+CatgyName+" is "+totalCount);
		List<WebElement> pagination =driver.findElements(By.xpath("//ul[@class='pagination']/li/a")); 
		int paginationcount = pagination.size();
		System.out.println("The "+CatgyName+" has contains "+paginationcount+" number of pages");
		String url1 = driver.getCurrentUrl();
		String url2 = url1 +"?page=";
		for(int i=0; i<=paginationcount; i++) {
			String url3 = url2 + i;
			driver.get(url3);
			  List<WebElement> paginationList =driver.findElements(By.className("fndr-title"));
			    	int Count = paginationList.size();
         			System.out.println(url3+" has " + Count +" Number of software in the page");
		}
	}
}
