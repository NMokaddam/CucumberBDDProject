package com.telus.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search1CustomerPage {

	WebDriver ldriver;

	public Search1CustomerPage(WebDriver rdriver) {

		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "SearchEmail")
	WebElement emailAdd;

	@FindBy(id = "search-customers")
	WebElement searchBtn;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-striped dataTable no-footer']")
	WebElement searchResult;

	//// table[@class='table table-bordered table-hover table-striped dataTable
	//// no-footer']//tbody//tr
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//tbody//tr")
	List<WebElement> tableRows;

	// @FindBy(xpath = "//table[@class='table table-bordered table-hover
	// table-striped dataTable no-footer']//tr/td")
	// List<WebElement> tableColumns;

	@FindBy(xpath = "//input[@id='SearchFirstName']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='SearchLastName']")
	WebElement lastName;

	
//////////////////////////Search Customer by Email///////////////////////////////////////////
	// action method for enter email address
	public void enterEmailAdd(String email) {
		emailAdd.sendKeys(email);
	}

	// action method to perform click action
	public void clickOnSearchButton() {
		searchBtn.click();
	}
 
	
	public boolean searchCustomerByEmail(String email) {
		boolean found = false;

		// total no. of rows in a grid
		int ttlRows = tableRows.size();

		// total no of columns
		// int ttlColumns = tableColumns.size();

		// to iterate all the rows of the grid
		for (int i = 1; i <= ttlRows; i++) {
			// System.out.println("Searching row:" +i);

			WebElement webElementEmail = ldriver.findElement(By.xpath(
					"//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//tbody//tr["
							+ i + "]/td[2]"));

			String actualEmailAdd = webElementEmail.getText();

			if (actualEmailAdd.equals(email)) {
				found = true;
			}
		}
		return found;
	}

///////////////////////////////////////////search customer by name///////////////////////////////////////////

//action method to enter first name
	public void enterFirstName(String firstNameText) {
		firstName.sendKeys(firstNameText);
	}

//action method to enter last name
	public void enterLastName(String lastNameText) {
		lastName.sendKeys(lastNameText);
	}

	public boolean searchCustomerByName(String name) {
		boolean found = false;

//total no. of rows in a grid
		int ttlRows = tableRows.size();

		for (int i = 1; i <= ttlRows; i++) {

			WebElement webElementName = ldriver.findElement(By.xpath(
					"//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//tbody//tr["
							+ i + "]/td[3]"));

			String actualName = webElementName.getText();

			if (actualName.equals(name)) {
				found = true;
				break;
			}
		}
		return found;

	}
}
