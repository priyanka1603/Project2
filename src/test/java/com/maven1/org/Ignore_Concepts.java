package com.maven1.org;


import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Ignore_Concepts {

	public static WebDriver driver;
	
	@BeforeSuite
	private void setUp() {
		System.out.println("Before Suite");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\eclipse-workspace\\Maven1\\Driver\\chromedriver.exe");
         driver = new ChromeDriver();
         driver.manage().window().maximize();
	}
	@BeforeTest
	private void siteLaunch() {
		driver.get("https://www.amazon.in/");        
	}
	
	@Ignore
	@Test
	private void search() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 12 pro");
        driver.findElement(By.id("nav-search-submit-button")).click();
	}
	
	@Test(priority = 1)
	private void oneplus() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Oneplus pro 9");
        driver.findElement(By.id("nav-search-submit-button")).click();
	}
	   @Test(priority = 2)
		private void iphone() {
			driver.findElement(By.xpath("//img[@class='s-image']")).click();
	   }
	   	   
	   @Test (priority = 3)
	  private void addTo() {
		   Set<String> wind = driver.getWindowHandles();
		   for ( String title : wind) {
			   //System.out.println(title);
		String title1 =	driver.switchTo().window(title).getTitle();
		System.out.println( "Window Title"  +title1);
		}
		   String tit = "OnePlus 9 Pro 5G (Pine Green, 12GB RAM, 256GB Storage): Amazon.in: Electronics\r\n";
		   		
		   for (String title : wind) {
			if (driver.switchTo().window(title).equals(tit)) {
				break;
			}
		}
		   
	      driver.findElement(By.xpath("//a[@title='Add to Wish List']")).click();
	}
	   @Test (priority = 4)
	   private void total() {
		   driver.navigate().refresh();
		   driver.close();
	}
	   
	   
	   @AfterTest
	   private void aftterTest() {
		
      System.out.println("After Test");
        
	}
	   
	   
	@AfterSuite
      private void afterSuite() {
		System.out.println("After Suite");
		

	}
	
	
   
	
	
	
	
}
