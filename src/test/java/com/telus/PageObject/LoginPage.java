package com.telus.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
		WebDriver ldriver;
		
		public LoginPage(WebDriver rdriver) 
		{
			ldriver=rdriver;
			
			PageFactory.initElements(rdriver, this);
		}
		
		// find WebElement 
		
		@FindBy(id = "Email")
		WebElement email;
		
		@FindBy(id = "Password")
		WebElement password;
		
		@FindBy(xpath = "//button[@class='button-1 login-button']")
		WebElement LoginBtn;
		
		@FindBy(linkText = "Logout")
		WebElement logout;
		
		// Action method
		public void enterEmail(String emailAdd)
		{
			email.clear();
			email.sendKeys(emailAdd);
		}
		
		public void enterPassword(String pwd)
		{
			password.clear();
			password.sendKeys(pwd);
		}
		
		public void clickOnLoginButton()
		{
			LoginBtn.click();
		}
		
		public void clickOnLogout() {
			logout.click();
		}
		
	}


