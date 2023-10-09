package com.telus.StepDefination;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.telus.PageObject.Add1NewCustomerPage;
import com.telus.PageObject.LoginPage;
import com.telus.PageObject.Search1CustomerPage;
import com.telus.Utilities.ReadConfig;

/*Parent Class*/

public class BaseClass {
	public static  WebDriver driver;
	public LoginPage loginpage;
	public Add1NewCustomerPage addNewCustPg;
	public Search1CustomerPage searchCustPg;
	public static Logger Log;
	public ReadConfig readConfig;
	
	
	
	//generate unique email id
	public String generateEmailId()
	{
		return(RandomStringUtils.randomAlphabetic(5));
	}
}
