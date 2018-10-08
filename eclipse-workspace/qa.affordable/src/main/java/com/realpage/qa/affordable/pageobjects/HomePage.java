package com.realpage.qa.affordable.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.realpage.qa.affordable.testbase.TestBase;

public class HomePage extends TestBase {

	@FindBy(id = "raul-header-menu-button")
	WebElement hemburgerLink;

	@FindBy(id = "setup_link")
	WebElement setupLink;

	@FindBy(xpath = "//a[contains(text(),'New prospect')]")
	WebElement newprospectLink;

	@FindBy(xpath = "//a[contains(text(),'Available units')]")
	WebElement availableunitsLink;

	@FindBy(xpath = "//a[contains(text(),'Quick qualify')]")
	WebElement quickqualifyLink;

	@FindBy(xpath = "//a[contains(text(),'Find person')]")
	WebElement findpersonLink;

	@FindBy(xpath = "//a[contains(text(),'Calculator')]")
	WebElement calculatorLink;

	@FindBy(xpath = "//a[contains(text(),'Ledger')]")
	WebElement ledgerLink;

	@FindBy(xpath = "//a[contains(text(),'Service request')]")
	WebElement servicerequestLink;

	@FindBy(xpath = "//a[contains(text(),'Accounting')]")
	WebElement accountingLink;

	// Menu Icon
	@FindBy(id = "raul-header-menu-button")
	WebElement homepageMenubutton;

	@FindBy(xpath = "//span[contains(text(),'Prospects')]")
	WebElement prospectsLink;

	@FindBy(xpath = "//span[contains(text(),'Applicants')]")
	WebElement applicantsLink;

	@FindBy(xpath = "//span[contains(text(),'Residents')]")
	WebElement residentsLink;

	@FindBy(xpath = "//span[contains(text(),'Reports, SDE and Tasks')]")
	WebElement reportssdetasksLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyNewProspectLink() {
		return newprospectLink.isDisplayed();
	}

	public boolean verifyAvailableUnitsLink() {
		return availableunitsLink.isDisplayed();
	}

	public boolean verifyQuickQualifyLink() {
		return quickqualifyLink.isDisplayed();
	}

	public boolean verifyFindPersonLink() {
		return findpersonLink.isDisplayed();
	}

	public boolean verifyCalculatorLink() {
		return calculatorLink.isDisplayed();
	}

	public boolean verifyLedgerLink() {
		return ledgerLink.isDisplayed();
	}

	public boolean verifyServiceRequestLink() {
		return servicerequestLink.isDisplayed();
	}

	public boolean verifyAccountingLink() {
		return accountingLink.isDisplayed();
	}

	public void clickOnHomepageMenubutton() {
		homepageMenubutton.click();
	}

	public void clickOnProspectsLink() {
		prospectsLink.click();
	}

	public void clickOnApplicantsLink() {
		applicantsLink.click();
	}

	public void clickOnResidentsLink() {
		residentsLink.click();
	}

	public void clickOnReportsSDEandTasksLink() {
		reportssdetasksLink.click();
	}

}
