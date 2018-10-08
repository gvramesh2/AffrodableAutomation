package com.realpage.qa.affordable.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProspectsGridPage extends HomePage {

	// Prospects page Objects

	@FindBy(xpath = "//span[contains(text(),'Prospects')]")
	WebElement prospectsLabel;

	@FindBy(id = "LPL_btnNewLabel")
	WebElement newBtn;

	@FindBy(id = "LPL_btnPrintLabel")
	WebElement printBtn;

	@FindBy(id = "LPL_selFind")
	WebElement findDrpdwn;

	@FindBy(id = "LPL_txtFind")
	WebElement findTxtbox;

	@FindBy(id = "LPL_btnFindLabel")
	WebElement findBtn;

	@FindBy(id = "LPL_btnRefreshLabel")
	WebElement refreshBtn;

	@FindBy(id = "LPL_cboProspectFilter")
	WebElement selectByStatusDrpdwn;

	// Initializing the Page Objects:
	public ProspectsGridPage() {
		PageFactory.initElements(driver, this);
	}

	public void prospectSelectByStatus(String StatusType) throws Exception {

		driver.switchTo().frame("ifrmShell");
		driver.switchTo().frame("ifrmPage");
		Select oProspectSelection = new Select(selectByStatusDrpdwn);
		oProspectSelection.selectByVisibleText(StatusType);
		Thread.sleep(5000);
	}

	public void getAllProspectsData(String ProspectType) throws Exception {

		Thread.sleep(5000);
		prospectSelectByStatus(ProspectType);

		WebElement webtable = driver.findElement(By.id("LPL_tblProspect_ST"));

		List<WebElement> rows = webtable.findElements(By.tagName("tr"));

		System.out.println("Number of Rows including headings: " + rows.size());

		List<WebElement> columns = rows.get(0).findElements(By.tagName("th"));
		System.out.println("Number of columns: " + columns.size());

		// Finding & Printing the column headings

		for (int cnum = 0; cnum < columns.size(); cnum++) {
			System.out.println(columns.get(cnum).getText());
		}

		System.out.println("****************************************************************");

		for (int i = 1; i < rows.size(); i++) {
			for (int j = 1; j <= columns.size(); j++) {
				String data = driver
						.findElement(By.xpath("//table[@id='LPL_tblProspect_ST']/tbody/tr[" + i + "]/td[" + j + "]"))
						.getText();
				System.out.println(data);
			}

		}

	}

	public int getWebtableRowCount(WebElement webtableObject) {

		List<WebElement> rows = webtableObject.findElements(By.tagName("tr"));

		System.out.println("Number of Rows including headings: " + rows.size());
		return rows.size();

	}

	public int getWebtableColumnCount(WebElement webtableObject) {
		List<WebElement> rows = webtableObject.findElements(By.tagName("tr"));
		List<WebElement> columns = rows.get(0).findElements(By.tagName("th"));
		System.out.println("Number of columns: " + columns.size());
		return columns.size();
	}

	public void getWebtableData(WebElement webtableObject) {

		List<WebElement> rows = webtableObject.findElements(By.tagName("tr"));
		List<WebElement> columns = rows.get(0).findElements(By.tagName("th"));
		System.out.println("Number of columns: " + columns.size());

		for (int i = 1; i < rows.size(); i++) {
			for (int j = 1; j <= columns.size(); j++) {
				String data = driver
						.findElement(By.xpath("//table[@id='LPL_tblProspect_ST']/tbody/tr[" + i + "]/td[" + j + "]"))
						.getText();
				System.out.println(data);
			}

		}
	}

	public void searchProspectByName(String prospectName) throws Exception {
		
		driver.switchTo().frame("ifrmShell");
		driver.switchTo().frame("ifrmPage");
		
		Select oProspectSelection = new Select(findDrpdwn);
		oProspectSelection.selectByVisibleText("Name");
		Thread.sleep(5000);
		findTxtbox.sendKeys(prospectName);
		findBtn.click();

	}

}
