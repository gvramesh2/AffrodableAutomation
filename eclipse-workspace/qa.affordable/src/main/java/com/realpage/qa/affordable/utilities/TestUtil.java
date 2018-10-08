package com.realpage.qa.affordable.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.realpage.qa.affordable.testbase.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	public static String TESTDATA_SHEET_PATH = "C:\\Users\\vgeddam\\eclipse-workspace\\qa.affordable\\src\\main\\java\\com\\realpage\\qa\\affordable\\testdata\\ProspectsModule.xlsx";

	static Workbook book;
	static Sheet sheet;

	// Wait for page load

	// Implicit Wait
	public static void impliciteWait(int timeInsec) {
		Reporter.log("waiting for page to load...");
		try {
			driver.manage().timeouts().implicitlyWait(timeInsec, TimeUnit.SECONDS);
			Reporter.log("Page is loaded");
		} catch (Throwable error) {
			Reporter.log("Timeout for Page Load Request to complete after " + timeInsec + " seconds");
			Assert.assertTrue(false, "Timeout for page load request after " + timeInsec + " second");
		}
	}

	public static void setPageLoadTimeout(long timeout, TimeUnit unit) {

		driver.manage().timeouts().pageLoadTimeout(timeout, unit == null ? TimeUnit.SECONDS : unit);
	}

	public static WebDriverWait setPageLoadTimeoutWithPolling(int timeOutInSeconds, int pollingEveryInMiliSec) {

		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(pollingEveryInMiliSec, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}

	public static void waitForElementVisible(WebElement locator, int timeOutInSeconds, int pollingEveryInMiliSec) {

		WebDriverWait wait = setPageLoadTimeoutWithPolling(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(ExpectedConditions.visibilityOf(locator));
	}

	public static void waitForElement(WebDriver driver, WebElement element, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static String waitForElement(String item, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(item)));
		return item;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// String currentDir = System.getProperty("user.dir");
		String dataName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String screenshotName = "venkataGeddam";

		String destination = System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\realpage\\qa\\affordable\\screenshots\\" + screenshotName + dataName
				+ ".png";
		// String currentDir = System.getProperty("user.dir");

		File finalDestination = new File(destination);
		FileUtils.copyFile(scrFile, finalDestination);

	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {

		String dataName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\realpage\\qa\\affordable\\screenshots\\" + screenshotName + dataName
				+ ".png";
		// String currentDir = System.getProperty("user.dir");

		File finalDestination = new File(destination);
		FileUtils.copyFile(scrFile, finalDestination);
		return destination;
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	
}
