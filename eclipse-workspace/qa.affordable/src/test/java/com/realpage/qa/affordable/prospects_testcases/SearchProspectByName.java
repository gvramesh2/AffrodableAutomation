package com.realpage.qa.affordable.prospects_testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.realpage.qa.affordable.pageobjects.HomePage;
import com.realpage.qa.affordable.pageobjects.ProspectsGridPage;
import com.realpage.qa.affordable.pageobjects.ProspectsPage;
import com.realpage.qa.affordable.testbase.TestBase;
import com.realpage.qa.affordable.utilities.TestUtil;

public class SearchProspectByName extends TestBase {

	HomePage homePage;
	TestUtil testUtil;
	ProspectsPage prospect;
	ProspectsGridPage prospectgridactivities;

	public SearchProspectByName() {
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
		prospectgridactivities = new ProspectsGridPage();

		homePage.clickOnHomepageMenubutton();
		homePage.clickOnProspectsLink();
		// prospect.clickOnProspectNewButton();

	}

	@Test
	public void displayProspectData() throws Exception {
		Thread.sleep(5000);
		prospectgridactivities.searchProspectByName("Burris");
		Thread.sleep(5000);
	}

	@AfterMethod
	public void tearDown() throws Exception {

		driver.close();
		System.out.println("Prospect window closed successfully");

	}

}
