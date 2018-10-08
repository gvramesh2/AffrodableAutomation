package com.realpage.qa.affordable.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.realpage.qa.affordable.pageobjects.HomePage;
import com.realpage.qa.affordable.testbase.TestBase;
import com.realpage.qa.affordable.utilities.TestUtil;

public class HomePageTests extends TestBase {

	HomePage homePage;
	TestUtil testUtil;

	public HomePageTests() {
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

	}

	@Test(priority = 0)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "datafix2016a.onesite.realpage.com (221122)", "Home page title not matched");
	}

	@Test(priority = 1)
	public void verifyNewProspectLinkTest() {
		boolean newprospectlink = homePage.verifyNewProspectLink();
		Assert.assertEquals(newprospectlink, true, "New prospect link is not available");

	}

	@Test(priority = 2)
	public void verifyAvailableUnitsLinkTest() {
		boolean availableunitslink = homePage.verifyAvailableUnitsLink();
		Assert.assertEquals(availableunitslink, true, "Available units link is not available");

	}

	@Test(priority = 3)
	public void verifyQuickQualifyLinkTest() {
		boolean quickqualifylink = homePage.verifyQuickQualifyLink();
		Assert.assertEquals(quickqualifylink, true, "Quick Qualify link is not available");

	}

	@Test(priority = 4)
	public void verifyFindPersonLinkTest() {
		boolean findpersonlink = homePage.verifyFindPersonLink();
		Assert.assertEquals(findpersonlink, true, "Find Person link is not available");

	}

	@Test(priority = 5)
	public void verifyCalculatorLinkTest() {
		boolean calculatorlink = homePage.verifyCalculatorLink();
		Assert.assertEquals(calculatorlink, true, "Calculatorn link is not available");

	}

	@Test(priority = 6)
	public void verifyLedgerLinkTest() {
		boolean ledgerlink = homePage.verifyLedgerLink();
		Assert.assertEquals(ledgerlink, true, "Ledger link is not available");

	}

	@Test(priority = 7, enabled = false)
	public void verifyServiceRequestLinkTest() {
		boolean servicerequestlink = homePage.verifyServiceRequestLink();
		Assert.assertEquals(servicerequestlink, true, "Service request link is not available");

	}
	
	@Test(priority = 8)
	public void verifyAccountingLinkTest() {
		boolean accountlink = homePage.verifyAccountingLink();
		Assert.assertEquals(accountlink, true, "Service request link is not available");

	}
	
	@Test(priority = 9, enabled = false)
	
	public void verifyHomepageMenuBtnTest() {
		
		homePage.clickOnHomepageMenubutton();
		homePage.clickOnProspectsLink();
		System.out.println("Clicked on Home Page Menu button");

	}
	

	@AfterMethod
	public void tearDown() throws Exception {
		
		driver.close();
		driver.quit();
		Thread.sleep(5000);
	}

}
