package com.telus.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Add1NewCustomerPage {

	WebDriver ldriver;
	
	public Add1NewCustomerPage(WebDriver rdriver) {
		
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	// find webelement on the web page
	
		@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
		WebElement linkCustomers_menu;
		
		////p[normalize-space()='Customers']//i[contains(@class,'right fas fa-angle-left')]
		
		@FindBy(xpath = "(//p[contains(text(),'Customers')])[2]")
		WebElement lnkCustomers_menuitem;
		

		@FindBy(xpath = "//a[@class='btn btn-primary']")
		WebElement btnAddnew;
		
		@FindBy(xpath = "//input[@id='Email']")
		WebElement txtEmail;
		
		@FindBy(xpath = "//input[@id='Password']")
		WebElement txtPassword;
		
		@FindBy(xpath = "//div[@class='k-widget k-multiselect k-multiselect-clearable k-state-hover']//div[@role='listbox']")
		WebElement txtCustomerRoles;
		
		@FindBy(xpath = "li[contains(text(),'Registered')]")
		WebElement listItemRegistered;
		
		@FindBy(xpath = "li[contains(text(),'Guests')]")
		WebElement listItemGuests;
		
		@FindBy(xpath = "li[contains(text(),'Vendors')]")
		WebElement listItemVendors;
		
		@FindBy(xpath = "//select[@id='VendorId']")
		WebElement dropdownVendorMgr;
		
		@FindBy(xpath = "//input[@id='Gender_Male']")
		WebElement MaleGender;
		
		@FindBy(xpath = "//input[@id='Gender_Female']")
		WebElement FemaleGender;
		
		@FindBy(xpath = "//input[@id='FirstName']")
		WebElement txtFirstName;
		
		@FindBy(xpath = "//input[@id='LastName']")
		WebElement txtLastName;
		
		@FindBy(xpath = "//input[@id='DateOfBirth']")
		WebElement txtDob;
		
		@FindBy(xpath = "//div[@role='listbox'])[2]")
		WebElement customrRole;
		
		//(
		@FindBy(xpath = "//input[@id='Company']")
		WebElement txtCompanyName;
		
		@FindBy(xpath = "//textarea[@id='AdminComment']")
		WebElement txtAdminComment;
		
		@FindBy(xpath = "//button[@name='save']")
		WebElement btnsave;
		
		@FindBy(xpath = "//input[@id='customer_attribute_1']")
		WebElement jenish;
		
		//Actions method for web elements
		
		public String getPageTitle()
		{
			return ldriver.getTitle();
		}
		
		public void clickOnCustomerMenu() {
			linkCustomers_menu.click();
		}
		
		public void clickOnCustomersMenuItem() {
			lnkCustomers_menuitem.click();
		}
		
		public void clickOnAddnew() {
			btnAddnew.click();
		}
		
		public void enterEmail(String email) {
			txtEmail.sendKeys(email);
		}
		
		public void enterPassword(String password) {
			txtPassword.sendKeys(password);
		}
		
		public void enterFirstName(String firstName) {
			txtFirstName.sendKeys(firstName);
		}
		
		public void enterLastName(String lastName) {
			txtLastName.sendKeys(lastName);
		}
		
		public void enterDOB(String dob) {
			txtDob.sendKeys(dob);
		}
		
		public void enterCompanyName(String coName) {
			txtCompanyName.sendKeys(coName);
		}
		
		public void customerRoles(String value) {
			customrRole.click();
		}
		
		public void enterAdminContent(String content) {
			txtAdminComment.sendKeys(content);
		}
		
		public void enterManagerOfVender(String value) {
			Select drp = new Select(dropdownVendorMgr);
			drp.selectByVisibleText(value);
			
		}
		
		public void enterGender(String gender) {
			
			if(gender.equals("Male"))
			{
				MaleGender.click();
				
			}else if(gender.equals("Female"))
			{
				FemaleGender.click();
			}
			else //default set Male gender
			{
				MaleGender.click();
			}
		}
		
		public void clickOnSave()
		{
			btnsave.click();
		}
		
		public void enterJenish(String jens)
		{
			jenish.sendKeys(jens);
		}
		
	
}
