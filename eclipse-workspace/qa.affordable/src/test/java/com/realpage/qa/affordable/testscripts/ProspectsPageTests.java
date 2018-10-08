package com.realpage.qa.affordable.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.realpage.qa.affordable.pageobjects.HomePage;
import com.realpage.qa.affordable.pageobjects.ProspectsPage;
import com.realpage.qa.affordable.testbase.TestBase;
import com.realpage.qa.affordable.utilities.TestUtil;

public class ProspectsPageTests extends TestBase {

	HomePage homePage;
	TestUtil testUtil;
	ProspectsPage prospectpage;

	public ProspectsPageTests() {
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
		prospectpage = new ProspectsPage();
	}

	@Test(priority = 1)
	public void verifyProspectTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "datafix2016a.onesite.realpage.com (221115)", "Home page title not matched");
		homePage.clickOnHomepageMenubutton();
		homePage.clickOnProspectsLink();
		boolean Status = prospectpage.verifyProspectsPage();
		Assert.assertEquals(Status, true, "Prospect page not opened");
		prospectpage.clickOnProspectNewButton();
		
	}

	@AfterMethod
	public void tearDown() throws Exception {
		//driver.close();
		//driver.quit();
		Thread.sleep(5000);
	}

}
