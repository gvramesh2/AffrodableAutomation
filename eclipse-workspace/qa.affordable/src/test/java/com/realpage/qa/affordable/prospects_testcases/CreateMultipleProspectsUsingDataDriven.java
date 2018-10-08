package com.realpage.qa.affordable.prospects_testcases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.realpage.qa.affordable.pageobjects.HomePage;
import com.realpage.qa.affordable.pageobjects.ProspectsPage;
import com.realpage.qa.affordable.testbase.TestBase;
import com.realpage.qa.affordable.utilities.TestUtil;

public class CreateMultipleProspectsUsingDataDriven extends TestBase {

	HomePage homePage;
	TestUtil testUtil;
	ProspectsPage prospect;
	String sheetName = "ProsDetails";

	public CreateMultipleProspectsUsingDataDriven() {
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

	@DataProvider
	public Object[][] getProspectsData() {

		Object[][] data = TestUtil.getTestData(sheetName);
		
		return data;
	}

	@Test(dataProvider = "getProspectsData")
	public void createMultipleProspects(String s1, String s2, String s3, String s4) throws Exception {

		// Switching to frame
		//driver.switchTo().frame(1);
		// Wait until new prospect window loaded
		//Thread.sleep(8000);
		// Adding data
		//prospect.selectContactBy(ContactedBy);
		//prospect.enterDate(oDate);
		//prospect.enterTime(oTime);
		//prospect.selectFloorPlan(oFloorPlan);
		//prospect.enterProspectFirstName(oFirstName);
		//prospect.enterProspectMiddleName(oMiddleName);
		//prospect.enterProspectLastName(oLastName);
		//prospect.selectSourceType(oSource);

		//Thread.sleep(5000);
		//prospect.enterNeededDate(oDateNeeded);
		//prospect.enterPhoneNumberOne(oPhoneNumberOne);
		//prospect.enterPhoneNumberOneExtension(oPhoneNumberOneExtension);
		//prospect.enterStreetName(oStreetName);
		//prospect.enterCityName(oCityName);
		//prospect.enterStateName(oStateName);
		//prospect.enterZipNumber(oZipNumber);
		//prospect.enterPhoneNumberTwo(oPhoneNumberTwo);
		//prospect.enterPhoneNumberTwoExtension(oPhoneNumberTwoExtension);
		//prospect.enterEmail(oEmailId);
		//prospect.enterNotes(oNotes);
		//prospect.clickOnResultsLink();
		//driver.switchTo().defaultContent();

		//Thread.sleep(5000);
		//prospect.selectResultDropdown(oResultDropdown);
		//prospect.clickOnOKButtonOnResultsLink();
		//driver.switchTo().defaultContent();
		//prospect.clickOnProspectSave();
		
		//ArrayList col = (ArrayList) it.next();
		
		System.out.println();
		
		
		

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

		// Thread.sleep(3000);
		driver.switchTo().window(popupWindow);

		// TestUtil.setPageLoadTimeoutWithPolling(10000, 1000);
		Thread.sleep(5000);
		System.out.println("Prospect window title is : " + driver.getTitle());
		// driver.switchTo().frame("ifrmMBtn");
		driver.close();
		System.out.println("Prospect window closed successfully");

		Thread.sleep(5000);
		driver.quit();
	}

}
