package com.realpage.qa.affordable.prospects_testcases;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.realpage.qa.affordable.pageobjects.HomePage;
import com.realpage.qa.affordable.pageobjects.ProspectsPage;
import com.realpage.qa.affordable.testbase.TestBase;
import com.realpage.qa.affordable.utilities.TestUtil;

public class CreateNewProspect extends TestBase {

	HomePage homePage;
	TestUtil testUtil;
	ProspectsPage prospect;

	public CreateNewProspect() {
		super();
	}

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		prospect = new ProspectsPage();

		homePage.clickOnHomepageMenubutton();
		homePage.clickOnProspectsLink();
		prospect.clickOnProspectNewButton();

	}

	@Test
	public void createNewProspectByclickingOnNewButton() throws Exception {

		// driver.switchTo().frame("ifrmShell");
		// driver.switchTo().frame("ifrmPage");
		// System.out.println("New prospect window opened...");
		driver.switchTo().frame(1);
		// System.out.println("Moved to frame");
		Thread.sleep(8000);
		/*
		 * List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
		 * System.out.println(iframes.size());
		 * 
		 * for (WebElement iframe : iframes) {
		 * 
		 * // switch to every frame driver.switchTo().frame(iframe);
		 * 
		 * WebElement ele = driver.findElement(By.id("txtFirstName"));
		 * if(ele.isDisplayed()) { System.out.println("element idetified"); // now
		 * within the frame you can navigate like you are used to
		 * System.out.println(driver.findElement(By.id("txtFirstName")).getText()); } }
		 */
		prospect.selectContactBy("E-Mail");
		prospect.enterDate("05/07/2018");
		prospect.enterTime("1000");
		prospect.selectFloorPlan("1x1");
		prospect.enterProspectFirstName("LL");
		prospect.enterProspectMiddleName("V");
		prospect.enterProspectLastName("LL");
		prospect.selectSourceType("Apartment Finder Blue Book");
		
		Thread.sleep(5000);
		prospect.enterNeededDate("05/08/2019");
		prospect.enterPhoneNumberOne("9000966567");
		prospect.enterPhoneNumberOneExtension("1234");
		prospect.enterStreetName("Test Street");
		prospect.enterCityName("Test City");
		prospect.enterStateName("AL - Alabama");
		prospect.enterZipNumber("75005");
		prospect.enterPhoneNumberTwo("9988775566");
		prospect.enterPhoneNumberTwoExtension("9876");
		prospect.enterEmail("venkata.geddam@realpage.com");
		prospect.enterNotes("This is an sample notes");
		prospect.clickOnResultsLink();
		driver.switchTo().defaultContent();
		
		Thread.sleep(5000);
		prospect.selectResultDropdown("Active - HIGH probability of leasing");
		prospect.clickOnOKButtonOnResultsLink();
		driver.switchTo().defaultContent();
		prospect.clickOnProspectSave();
		
	}

	@AfterMethod
	public void tearDown() throws Exception {
		
		Thread.sleep(5000);
		Set<String> AllWindowHandles = driver.getWindowHandles();
		Iterator<String> itr = AllWindowHandles.iterator();

		String mainWindow = itr.next();
		String popupWindow = itr.next();
		
		System.out.println();
		System.out.println(mainWindow);
		System.out.println(popupWindow);

		//Thread.sleep(3000);
		driver.switchTo().window(popupWindow);
		
		//TestUtil.setPageLoadTimeoutWithPolling(10000, 1000);
		Thread.sleep(5000);
		System.out.println("Prospect window title is : "+driver.getTitle());
		//driver.switchTo().frame("ifrmMBtn");
		driver.close();
		System.out.println("Prospect window closed successfully");
			
		
		Thread.sleep(5000);
		// driver.quit();
	}

}
