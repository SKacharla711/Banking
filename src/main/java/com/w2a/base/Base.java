package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.w2a.utilities.ExtentManager;

public class Base {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static WebDriverWait wait;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static FileInputStream fis;
	public static ExtentReports extent = ExtentManager.getInstance();

	@BeforeSuite
	public void setUp() {
		if (driver == null) {
			initializePropertyfiles();
			intializeWebDriver("chrome");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.navigate().to(config.getProperty("url"));
		log.debug("Launched URL");
	}

	@AfterSuite
	public void endBrowser() {
		if (driver != null) {
			driver.close();
		}
	}

	public void initializePropertyfiles() {
		if (driver == null) {
			PropertyConfigurator
					.configure("D:\\Satish\\Initiation\\banking\\src\\test\\resources\\properties\\log4j.properties");
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public WebDriver intializeWebDriver(String driverName) {
		if (driverName.equals("chrome")) {
			driver = loadChromeDriver();
		} else if (driverName.equals("firefox")) {
			driver = loadFirefoxDriver();
		} else if (driverName.equals("ie")) {
			driver = loadInternetExplorerDriver();
		}
		log.debug(driverName + " driver Initialized");
		return driver;

	}

	public WebDriver loadChromeDriver() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	public WebDriver loadFirefoxDriver() {
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	public WebDriver loadInternetExplorerDriver() {
		System.setProperty("webdriver.ie.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		return driver;
	}

	public void click(WebElement element, String elementName) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		log.debug("Clicked on " + elementName);
		ExtentManager.getTest().log(Status.INFO, "Clicked on " + elementName);
	}

	public void sendKeys(WebElement element, String elementName, String value) {
		element.sendKeys(value);
		log.debug("Entered value " + value + " on " + elementName);
		ExtentManager.getTest().log(Status.INFO, "Entered value " + value + " on " + elementName);
	}

}
