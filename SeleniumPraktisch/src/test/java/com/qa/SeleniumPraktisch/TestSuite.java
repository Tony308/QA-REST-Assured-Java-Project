package com.qa.SeleniumPraktisch;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TestSuite {
	
	 WebDriver driver;
	    String url = Constant.url;
	    ExtentReports report;
	    ExtentTest test;
	    Actions action;

	    @Before
	    public void setup() {
	        System.setProperty("webdriver.chrome.driver", Constant.filepath + Constant.chromeDriver);
	        driver = new ChromeDriver();

	        action = new Actions(driver);
	        report = new ExtentReports(Constant.filepath+Constant.report, true);
	        test = report.startTest("Testing");
	    }

	    @After
	    public void tearDown() throws InterruptedException {
	        Thread.sleep(2500);
	        driver.quit();
	        report.endTest(test);
	        report.flush();
	    }

	    @Test
	    @Ignore
	    public void registration() {
	        driver.manage().window().maximize();
	        driver.get(url);
	        driver.findElement(By.xpath("//*[@id=\"menu-item-374\"]/a")).click();
	        driver.findElement(By.name("first_name")).sendKeys("Tony");
	        driver.findElement(By.name("last_name")).sendKeys("Smith");
	        driver.findElement(By.xpath("//*[@id=\"pie_register\"]/li[2]/div/div/input[1]")).click();
	        driver.findElement(By.id("dropdown_7")).sendKeys("United Kingdom");
	        driver.findElement(By.id("mm_date_8")).sendKeys("9");
	        driver.findElement(By.id("dd_date_8")).sendKeys("4");
	        driver.findElement(By.id("yy_date_8")).sendKeys("1996");
//	        new Actions(driver).click(driver.findElement(By.id("dropdown_7"))).perform();
	    }

	    @Test
	    public void pomRegistration() throws InterruptedException {
	        Homepage home = PageFactory.initElements(driver, Homepage.class);
	        Registration reg = PageFactory.initElements(driver, Registration.class);

	        driver.manage().window().maximize();
	        driver.get(url);
	        home.navReg();

	        reg.registerSomeone(driver);
	        
	        

	    }
	

}
