package com.maven1.org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Grouping {

	public static WebDriver driver;
	
	@BeforeSuite (groups = "site") 
	private void beforeSuite() {
	  System.out.println("Before Suite");
	  System.setProperty("webdriver.chrome.driver", 
			  "C:\\Users\\user\\eclipse-workspace\\Maven1\\Driver\\chromedriver.exe");
       driver = new ChromeDriver();
  	}
	@BeforeTest (groups = "site")
	private void beforeTest() {
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}
	@Test(priority = -1, groups = "site")
	private void test1() {
		System.out.println("Text");
		  String loginText =   driver.findElement(By.id("login_credentials")).getText();
	      System.out.println("== " + loginText + " ==");		
	}
	@Test (groups = "User")
	private void test2() {
		System.out.println("User Name");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");    
		System.out.println("User Pass");
		  driver.findElement(By.name("password")).sendKeys("secret_sauce");
		  System.out.println("User Login");
			 driver.findElement(By.id("login-button")).click();
	}
	@Test (priority = 1)
	private void test3() {
		driver.findElement(By.xpath("//div[@class='inventory_item_name']")).click();
		 driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']")).click();
	}
	@Test (priority = 2)
	private void test4() {
		 driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
         driver.findElement(By.id("checkout")).click();
         String title = driver.getTitle();
 		System.out.println(title);
	}
	@Test (priority = 3)
	private void test5() {
		 driver.findElement(By.id("first-name")).sendKeys("Priyanka");
         driver.findElement(By.id("last-name")).sendKeys("M");
         driver.findElement(By.name("postalCode")).sendKeys("600068");
         driver.findElement(By.name("continue")).click();
	}	
	@Test (priority = 4)
	private void test6() {
		 String total = driver.findElement(By.xpath("//div[@class='cart_item_label']")).getText();
         System.out.println("== " + total + " ==");
         driver.findElement(By.id("finish")).click(); 
	}
	@AfterMethod
	private void afterMethod() {
		driver.navigate().refresh();
	}
	@AfterClass
	private void afterClass() {
		driver.close();

	}	
	@AfterTest
	private void afterTest() {
		System.out.println("After Test");
	}
		
	@AfterSuite
	private void afterSui() {
		System.out.println(" After Suite ");
	}	
	
}
