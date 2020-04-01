package mytestcase;

import java.util.List;

import org.openqa.selenium.By;
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
		
		if(paginationcount >1){ 
			for(int i=0; i<paginationcount; i++){ 
			pagination.get(i).click(); 
			}
	   List<WebElement> Soft =driver.findElements(By.className("fndr-title")); 
	   for(WebElement Title : Soft ) {
		   String SoftTitle = Title.getText();
		   System.out.println(SoftTitle);
	      }
		}
	}
}
