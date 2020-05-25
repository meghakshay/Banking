package com.inetbanking.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.core.util.FileUtils;


//import org.apache.logging.log4j.core.util.FileUtils;

public class BaseTest {
	public static WebDriver driver;
	public Properties prop;
	public static Logger log;
	
	@BeforeMethod
	public WebDriver setup() throws IOException {
		log = LogManager.getLogger(BaseTest.class.getName());
		//Data file loading 
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\inetbanking\\testData\\Data.Properties");
			prop = new Properties();
			prop.load(file);
		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
		
		
		//get Browser Name from Data file
		String BrowserName=prop.getProperty("Browser");
		
		if(BrowserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",prop.getProperty("ChromePath"));
			driver = new ChromeDriver();
			log.info("Browser is Opened");
		}
		else if(BrowserName.equals("FireFox")){
			System.setProperty("webdriver.gecko.driver",prop.getProperty("FireFoxPath"));
			driver = new FirefoxDriver();
			log.info("Browser is Opened");
		}
//		else {
//			System.setProperty("","");
//			driver = new InternetExplorerDriver();
//		}
		
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return driver;
		
		
	}
	
	@AfterMethod
	public void CloseBrowser() {
		driver.close();
		driver = null;
	}
	
	public void CaptureScrsht(WebDriver driver, String tname) throws IOException {
		log.info("inside CaptureScrsht fuction");
		TakesScreenshot scrsht = (TakesScreenshot) driver;
		File srcFile =scrsht.getScreenshotAs(OutputType.FILE);
		String Date_of_scr_shot = current_date();
		File destFile = new File("D:\\Testing\\eclipse-workspace\\BankingProject\\Screenshots\\"+tname+"_"+Date_of_scr_shot+".png");
		FileUtils.copyFile(srcFile, destFile);
	}

	public boolean isAlertPresent() 	//userdefind method to check alert is present or not
	{
		try {

			driver.switchTo().alert();
			return true;
		} 
		catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	public static String randomAlphaString() {
		String rndmstring = RandomStringUtils.randomAlphabetic(8);
		return rndmstring;
	}
	public static String randomAlphaNumericString() {
		return(RandomStringUtils.randomAlphanumeric(6));
	}
	
	public static String current_date(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String formattedDate = sdf.format(date);
		System.out.println(formattedDate);
		return formattedDate;
		
	}
}


