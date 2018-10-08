package com.realpage.qa.affordable.pageobjects;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProspectsPage extends HomePage {

	// Prospects page Objects

	@FindBy(xpath = "//span[contains(text(),'Prospects')]")
	WebElement prospectsLabel;

	@FindBy(id = "LPL_btnNewLabel")
	WebElement pNewBtn;

	@FindBy(id = "LPL_btnPrintLabel")
	WebElement pPrintBtn;

	@FindBy(id = "LPL_selFind")
	WebElement pFindDrpdwnBtn;

	@FindBy(id = "LPL_txtFind")
	WebElement pFindTxtbox;

	@FindBy(id = "LPL_btnFindLabel")
	WebElement pFindBtn;

	@FindBy(id = "LPL_btnRefreshLabel")
	WebElement pRefreshBtn;

	@FindBy(id = "LPL_cboProspectFilter")
	WebElement pStatusDrpdwnBtn;

	// Create new prospect page objects
	@FindBy(xpath = "//*[@id='selContactType']")
	WebElement new_prospect_contactBydropdown;
	
	@FindBy(xpath = "//*[@id='txtContactDate_View']")
	WebElement new_prospect_contactedDate;
	
	@FindBy(xpath = "//*[@id='txtContactTime']")
	WebElement new_prospect_contactedTime;
	
	@FindBy(id = "txtContactDate_View")
	WebElement new_prospect_datetxtfield;

	@FindBy(id = "selInterest")
	WebElement new_prospect_floorplandropdown;

	@FindBy(id = "txtFirstName")
	WebElement new_prospect_txtFirstName;

	@FindBy(id = "txtMiddleName")
	WebElement new_prospect_txtMiddleName;

	@FindBy(id = "txtLastName")
	WebElement new_prospect_txtLastName;

	@FindBy(id = "selMSrc1")
	WebElement new_prospect_dpdwSource;

	@FindBy(id = "txtDateNeeded_View")
	WebElement new_prospect_dateDateNeeded;

	@FindBy(id = "txtPhone1")
	WebElement new_prospect_txtPhoneNumber;

	@FindBy(id = "txtExt1")
	WebElement new_prospect_txtPhoneExtNumber;

	@FindBy(id = "txtAddress1")
	WebElement new_prospect_txtStreetName;

	@FindBy(id = "txtCity")
	WebElement new_prospect_txtCityName;

	@FindBy(id = "txtState")
	WebElement new_prospect_dwdnState;

	@FindBy(id = "txtZIP")
	WebElement new_prospect_ZipNumber;

	@FindBy(id = "txtPhone2")
	WebElement new_prospect_txtPhoneNumber2;

	@FindBy(id = "txtExt2")
	WebElement new_prospect_txtPhoneExtNumber2;

	@FindBy(id = "txtEmail")
	WebElement new_prospect_txtEmail;

	@FindBy(id = "txtNotes")
	WebElement new_prospect_txtNotes;

	@FindBy(xpath = "//span[contains(text(),'Result')]")
	WebElement new_prospect_lnkResults;

	@FindBy(id = "selProspectResults")
	WebElement new_prospect_ResultsDropdown;

	@FindBy(id = "btnSaveLabel")
	WebElement new_prospect_ResultsDropdown_OKButton;

	//@FindBy(xpath = "//td[contains(text(),'Save')]")
	//WebElement new_prospect_SaveButton;

	@FindBy(id="btnSaveLabel")
	WebElement new_prospect_SaveButton;
	
	/*
	 * // Adding New Prospect page objects
	 * 
	 * @FindBy(id = "selContactType") WebElement pros_contactedBy;
	 * 
	 * @FindBy(id = "txtContactDate_View") WebElement pros_date;
	 * 
	 * @FindBy(id = "selInterest") WebElement pros_floorPlanGroup;
	 * 
	 * @FindBy(id = "txtFirstName") WebElement pros_firstName;
	 * 
	 * @FindBy(id = "txtLastName") WebElement pros_lastName;
	 * 
	 * @FindBy(id = "selMSrc1") WebElement pros_source;
	 * 
	 * @FindBy(id = "txtDateNeeded_View") WebElement pros_dateNeeded;
	 * 
	 * @FindBy(id = "txtPhone1") WebElement pros_phoneNumber;
	 * 
	 * @FindBy(id = "selAddrType") WebElement pros_addressCountry;
	 * 
	 * @FindBy(id = "txtAddress1") WebElement pros_streetName;
	 * 
	 * @FindBy(id = "txtCity") WebElement pros_cityName;
	 * 
	 * @FindBy(id = "txtState") WebElement pros_stateName;
	 * 
	 * @FindBy(id = "txtZIP") WebElement pros_zipNumber;
	 * 
	 * @FindBy(id = "txtEmail") WebElement pros_emailAddress;
	 * 
	 * @FindBy(id = "txtNotes") WebElement pros_noteMsg;
	 * 
	 * @FindBy(id = "prospectResult") WebElement pros_resultsLink;
	 * 
	 * @FindBy(id = "selProspectResults") WebElement pros_result_dropdown;
	 * 
	 * @FindBy(id = "btnSaveLabel") WebElement pros_result_saveButton;
	 * 
	 * @FindBy(id = "btnSaveLabel") WebElement pros_saveButton;
	 */

	// Initializing the Page Objects:
	public ProspectsPage() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * public String verifyProspectsPageTitle() { return driver.getTitle(); }
	 */
	public boolean verifyProspectsPage() {

		driver.switchTo().frame("ifrmShell");
		driver.switchTo().frame("ifrmPage");
		boolean prospectlabel_isdisplayed = prospectsLabel.isDisplayed();

		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();

		return prospectlabel_isdisplayed;
	}

	public void clickOnProspectNewButton() {
		driver.switchTo().frame("ifrmShell");
		driver.switchTo().frame("ifrmPage");
		pNewBtn.click();
		driver.switchTo().defaultContent();
	}

	// Adding new prospect window methods
	public void selectContactBy(String contactType) {

		// WebElement element = driver.findElement(By.id("selContactType"));
		Select oContactSelection = new Select(new_prospect_contactBydropdown);
		oContactSelection.selectByVisibleText(contactType);
		// oContactSelection.selectByValue(contactType);
	}

	public void enterDate(String Date) {
		
		new_prospect_contactedDate.clear();
		new_prospect_contactedDate.sendKeys(Date);
		
		//Date date = new Date();
		//System.out.println(date);
	}
	
	public void enterTime(String Time) {
		
		new_prospect_contactedTime.clear();
		new_prospect_contactedTime.sendKeys(Time);
		
		//Date date = new Date();
		//System.out.println(date);
	}

	public void selectFloorPlan(String floorplan) {

		// WebElement element = driver.findElement((By)pros_floorPlanGroup);
		Select oFloorplan = new Select(new_prospect_floorplandropdown);
		oFloorplan.selectByVisibleText(floorplan);
	}

	public void enterProspectFirstName(String firstName) {
		new_prospect_txtFirstName.sendKeys(firstName);
	}

	public void enterProspectMiddleName(String middleName) {
		new_prospect_txtMiddleName.sendKeys(middleName);
	}

	public void enterProspectLastName(String lastName) {
		new_prospect_txtLastName.sendKeys(lastName);
	}

	public void selectSourceType(String sourceName) {

		Select oSourceName = new Select(new_prospect_dpdwSource);
		oSourceName.selectByVisibleText(sourceName);
	}

	public void enterNeededDate(String dateNeeded) {
		new_prospect_dateDateNeeded.clear();
		new_prospect_dateDateNeeded.sendKeys(dateNeeded);
	}

	public void enterPhoneNumberOne(String phoneNumber) {
		new_prospect_txtPhoneNumber.sendKeys(phoneNumber);
	}

	public void enterPhoneNumberOneExtension(String extPhoneNumberOne) {
		new_prospect_txtPhoneExtNumber.sendKeys(extPhoneNumberOne);
	}

	public void enterStreetName(String streetName) {
		new_prospect_txtStreetName.sendKeys(streetName);
	}

	public void enterCityName(String cityName) {
		new_prospect_txtCityName.sendKeys(cityName);
	}

	public void enterStateName(String stateName) {
		Select oStateName = new Select(new_prospect_dwdnState);
		oStateName.selectByVisibleText(stateName);
	}

	public void enterZipNumber(String zipNumber) {
		new_prospect_ZipNumber.sendKeys(zipNumber);
	}

	public void enterPhoneNumberTwo(String phoneNumberTwo) {
		new_prospect_txtPhoneNumber2.sendKeys(phoneNumberTwo);
	}

	public void enterPhoneNumberTwoExtension(String extPhoneNumberTwo) {
		new_prospect_txtPhoneExtNumber2.sendKeys(extPhoneNumberTwo);
	}

	public void enterEmail(String emailId) {
		new_prospect_txtEmail.sendKeys(emailId);
	}

	public void enterNotes(String notes) {
		new_prospect_txtNotes.sendKeys(notes);
	}

	public void clickOnResultsLink() {
		new_prospect_lnkResults.click();
	}

	public void selectResultDropdown(String resultDropdown) throws Exception {
		Thread.sleep(3000);
		driver.switchTo().frame(2);
		Select oResultDropdownData = new Select(new_prospect_ResultsDropdown);
		oResultDropdownData.selectByVisibleText(resultDropdown);

	}

	public void clickOnOKButtonOnResultsLink() {
		new_prospect_ResultsDropdown_OKButton.click();
	}

	public void clickOnProspectSave() {
		driver.switchTo().frame(1);
		new_prospect_SaveButton.click();
	}
}
