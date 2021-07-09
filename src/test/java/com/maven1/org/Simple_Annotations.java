package com.maven1.org;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Simple_Annotations {

	public static WebDriver driver;
	@BeforeSuite
	private void BeforeSuite() {
		System.out.println("Before suite");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\eclipse-workspace\\Maven1\\Driver\\chromedriver.exe");
	}
	@BeforeTest
	private void beforeTest() {		
		driver = new ChromeDriver();
		System.out.println("Bowser Launch");
	}
	
	@BeforeClass
	private void beforeClass() {
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.get("https://adactinhotelapp.com/"); 
		System.out.println("Url Launch");
		
	}
	
	@Test(priority = 0)
	private void Login() {
		System.out.println("Login");
		 String title1 = driver.getTitle();
			System.out.println("Title1 == "+ title1 );
		driver.findElement(By.id("username")).sendKeys("priyanka16");
        driver.findElement(By.id("password")).sendKeys("Pkpri161");
        driver.findElement(By.xpath("//input[@type='Submit']")).click();
       
	}
	
	@Test(priority = 1)
	private void Booking() {
		String title2 = driver.getTitle();
		System.out.println("Title2 == "+ title2 );
		
		Select sc = new Select(driver.findElement(By.name("location")));
		sc.selectByValue("New York");
		List<WebElement> options = sc.getOptions();
		for (WebElement elem : options) {
			String text = elem.getText();
			System.out.println(text);
			
		}
		Select sc1 = new Select(driver.findElement(By.name("hotels")));
		sc1.selectByVisibleText("Hotel Hervey");
		Select sc2 = new Select(driver.findElement(By.id("room_type")));
		sc2.selectByValue("Super Deluxe");
		Select sc3 = new Select(driver.findElement(By.id("room_nos")));
		sc3.selectByIndex(2);
		
	   driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();//datein
	   driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("16/07/2021");
	   
	   driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();//dateout
	   driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("18/07/2021");
		
	   Select sc4 = new Select(driver.findElement(By.name("adult_room")));
	   sc4.selectByIndex(2);//Adultroom
	   Select sc5 = new Select(driver.findElement(By.id("child_room")));
	   sc5.selectByIndex(1);
	   //Book now
	   driver.findElement(By.name("Submit")).click();        
		
	}
	
	@Test(priority = 2)
	private void radioButton() {
		String title3 = driver.getTitle();
		System.out.println("Title3 ==  "  + title3);
        driver.findElement(By.name("radiobutton_0")).click();
		
		driver.findElement(By.id("continue")).click();  
	}
	
	@Test(priority = 3)
	private void details () {
		driver.findElement(By.name("first_name")).sendKeys("Priyanka");
	     driver.findElement(By.name("last_name")).sendKeys("Manohar");
		 driver.findElement(By.name("address")).sendKeys("Chennai");
		 driver.findElement(By.id("cc_num")).sendKeys("1243254654657787");
		 
		Select sc = new Select(driver.findElement(By.id("cc_type")));
		 sc.selectByValue("OTHR");
		 Select sc1 = new Select(driver.findElement(By.name("cc_exp_month")));
		 sc1.selectByVisibleText("July");
		 Select sc2 = new Select(driver.findElement(By.name("cc_exp_year")));
		 sc2.selectByVisibleText("2022");
		 
		 driver.findElement(By.id("cc_cvv")).sendKeys("4265");
		 driver.findElement(By.name("book_now")).click();		 		 	
	}
		  		
	@AfterTest
	private void close() {
		//driver.close();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String title4 = driver.getTitle();
		 System.out.println("Title4 == " + title4);
		 driver.findElement(By.xpath("(//input[@class='reg_button'])[3]")).click();			
	String logout = driver.getTitle();
    System.out.println("Logout == " + logout);		
     
	}
	
	@AfterSuite
	private void aftersuite() {
		driver.manage().deleteAllCookies();
		driver.close();
		System.out.println("After Suite");

	}
	
}
