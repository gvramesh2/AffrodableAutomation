package com.realpage.qa.affordable.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.realpage.qa.affordable.utilities.TestUtil;
import com.realpage.qa.affordable.utilities.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\realpage\\qa\\affordable\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() throws Exception {
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\vgeddam\\eclipse-workspace\\qa.affordable\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\vgeddam\\eclipse-workspace\\qa.affordable\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {

			//System.setProperty("java.net.preferIPv4Stack", "true");
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\vgeddam\\eclipse-workspace\\qa.affordable\\Drivers\\IEDriverServer.exe");

			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			
			ieCapabilities.setCapability("nativeEvents", true);

			driver = new InternetExplorerDriver(ieCapabilities);

			
			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
			 

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();

			driver.get(prop.getProperty("url"));
			driver.switchTo().frame("logonFrm");

			WebElement myDynamicElement = (new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@Value='Sign on']")));

			driver.findElement(By.xpath("//input[@Value='Sign on']")).click();

			driver.switchTo().defaultContent();

			Set<String> AllWindowHandles = driver.getWindowHandles();
			Iterator<String> itr = AllWindowHandles.iterator();

			String mainWindow = itr.next();
			String popupWindow = itr.next();
			// String popupWindow1 = itr.next();
			// String popupWindow2 = itr.next();

			System.out.println();
			System.out.println(mainWindow);
			System.out.println(popupWindow);

			// Thread.sleep(3000);
			driver.switchTo().window(popupWindow);
			
			Thread.sleep(5000);

			System.out.println(driver.getTitle());
			
			driver.switchTo().frame("ifrmShell");
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			
			//WebElement element = driver.findElement(By.id("tdHomeLink"));
			 
			
			WebElement element = wait.until(
			        ExpectedConditions.visibilityOfElementLocated(By.id("tdHomeLink")));
			
			driver.switchTo().defaultContent();
			

			//WebElement homePageObject = (new WebDriverWait(driver, 10))
				//	.until(ExpectedConditions.presenceOfElementLocated(By.id("sitename")));

			String siteName = driver.findElement(By.id("sitename")).getText();
			// System.out.println(siteName);

			if (siteName.equalsIgnoreCase("Oak Place Village Apartments")) {
				System.out.println("Login Success");
			} else {
				System.out.println("Login Failed");
			}
		}
	}

	/*
	 * public static void main(String[] args) throws Exception {
	 * 
	 * TestBase tb = new TestBase(); tb.initialization(); }
	 */
}
