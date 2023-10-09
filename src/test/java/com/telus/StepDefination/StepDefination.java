package com.telus.StepDefination;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.telus.PageObject.Add1NewCustomerPage;
import com.telus.PageObject.LoginPage;
import com.telus.PageObject.Search1CustomerPage;
import com.telus.Utilities.ReadConfig;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

/* child Class*/

public class StepDefination extends BaseClass {

	/*
	 * @Before
	 * public void setup2() {
	 * 
	 * System.out.println("Setup-sanity method executed....."); //
	 * WebDriverManager.chromedriver().setup(); // driver = new ChromeDriver();
	 * 
	 * System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver.exe");
	 * 
	 * ChromeOptions chromeOptions = new ChromeOptions();
	 * chromeOptions.addArguments("--remote-allow-origins=*"); driver = new
	 * ChromeDriver(chromeOptions); driver.manage().window().maximize(); }
	 * 
	 */

	@Before("@sanity") // it will be execute for sanity only i.e conditional hook
	public void setup1() throws Exception {

		readConfig = new ReadConfig();
		
		// initial logger
		Log = LogManager.getLogger("StepDefination");
		System.out.println("Setup-regression method executed.....");

		String browser = readConfig.getBrowser();
		// launch browser
		switch (browser.toLowerCase()) {
		case "chrome":
		//	WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(chromeOptions);
		//	driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addPreference("security.fileuri.strict_origin_policy", false);
			WebDriver driver = new FirefoxDriver(firefoxOptions);

		//	driver = new FirefoxDriver();
			break;
			
		default:
			driver = null;
			break;
		}
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();

/*		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(chromeOptions); */
		Log.info("Setup1 executed....");
		driver.manage().window().maximize();

	}

	@Given("User Launch chrome browser")
	public void user_launch_chrome_browser() {

//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();

		loginpage = new LoginPage(driver);
		addNewCustPg = new Add1NewCustomerPage(driver);
		searchCustPg = new Search1CustomerPage(driver);

		Log.info("User launched chrome browser....");
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);

		Log.info("Url opened");
	}

	@When("User enters Emails as {string} and Password as {string}")
	public void user_enters_emails_as_and_password_as(String emailadd, String password) {
		loginpage.enterEmail(emailadd);
		loginpage.enterPassword(password);

		Log.info("email address and password entered");
	}

	@When("Click on Login")
	public void click_on_login() throws Exception {
		Thread.sleep(2000);
		loginpage.clickOnLoginButton();

		Log.info("Clicked on login button");
	}

	///////////////////// Login Feature/////////////////////

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualTitle = driver.getTitle();

		if (expectedTitle.equals(actualTitle)) {

			Log.warn("Test passed: Login feature :Page title matched.");
			Assert.assertTrue(true); // pass
		} else {
			Assert.assertTrue(false); // failed
			Log.warn("Test Failed: Login feature:Page title not matched. ");
		}
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws Exception {
		Thread.sleep(2000);
		loginpage.clickOnLogout();

		Log.info("user clicked on logout link");
	}

	/*
	 * @Then("close browser") public void close_browser() {
	 * 
	 * driver.close(); // driver.quit(); Log.info("Browser closed"); }
	 */

	////////////////////////// Add New Customer////////////////////////////////

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {

		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";

		if (actualTitle.equals(expectedTitle)) {

			Log.info("User can view Dashboard test passed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			Log.warn("User can view Dashboard test failed");
		}
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws Exception {
		Thread.sleep(2000);
		addNewCustPg.clickOnCustomerMenu();
		Log.info("customer menu clicked...");
		Thread.sleep(2000);
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() {
		addNewCustPg.clickOnCustomersMenuItem();
		Log.info("customer menu Item clicked...");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
		addNewCustPg.clickOnAddnew();
		Log.info("clicked on add new button...");
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";

		if (actualTitle.equals(expectedTitle)) {
			Log.info("User can view Add new customer page-passed");
			Assert.assertTrue(true); // pass
		} else {
			Log.info("User can view Add new customer page-failed");
			Assert.assertTrue(false);// fail

		}
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws Exception {

		// addNewCustPg.enterEmail("jimmy12@gmail.com");
		addNewCustPg.enterEmail(generateEmailId() + "@gmail.com");
		addNewCustPg.enterPassword("test12367");
		addNewCustPg.enterFirstName("JimmyTim");
		addNewCustPg.enterLastName("Lathan");
		addNewCustPg.enterGender("Male");
		addNewCustPg.enterDOB("6/13/1990");
		addNewCustPg.enterCompanyName("Softech");
		// addNewCustPg.enterJenish("abcddf");
		// addNewCustPg.customerRoles("Registered");
		addNewCustPg.enterAdminContent("Admin Comment");
		addNewCustPg.enterManagerOfVender("Vendor 1");

		Log.info("customer information entered");
	}

	@When("click on Save button")
	public void click_on_save_button() {
		addNewCustPg.clickOnSave();

		Log.info("clicked on save button");
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMsg1) {

		String bodyTagText = driver.findElement(By.tagName("Body")).getText();
		if (bodyTagText.contains(expectedConfirmationMsg1)) {
			Assert.assertTrue(true);// Pass

			Log.info("User can view confirmation message- passed");
		} else {

			Log.warn("User can not view confirmation message- failed");
			Assert.assertTrue(false);// false

		}
	}

////////////////////////////////Search Customer by Email////////////////////////////////////////////

	@When("Enter customer Email")
	public void enter_customer_email() {
		searchCustPg.enterEmailAdd("victoria_victoria@nopCommerce.com");

		Log.info("Email on search_button");
	}

	@When("Click on search button")
	public void click_on_search_button() throws Exception {
		searchCustPg.clickOnSearchButton();

		Log.info("Clicked on search button");

		Thread.sleep(2000);

	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
		String expectedEmail = "victoria_victoria@nopCommerce.com";

		// Assert.assertTrue(searchCustPage.searchCustomerByEmail(expectedEmail));

		if (searchCustPg.searchCustomerByEmail(expectedEmail) == true) {
			Assert.assertTrue(true);
			Log.info("User should found Email in the Search table - passed");

		} else {
			Log.info("User should not found Email in the Search table - failed");
			Assert.assertTrue(false);

		}
	}

	//////////////////////////// Search Customer by
	//////////////////////////// Name////////////////////////////////////////
	@When("Enter customer FirstName")
	public void enter_customer_first_name() {
		searchCustPg.enterFirstName("Victoria");
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() {
		searchCustPg.enterLastName("Terces");
	}

	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() {
		String expectedName = "Victoria Terces";

		if (searchCustPg.searchCustomerByName(expectedName) == true) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

//	@After
	public void tearDown(Scenario sc) throws Exception {
		System.out.println("Tear down method executed.....");

		if (sc.isFailed() == true) {
			// convert web driver object to TakeScreenshot
			String fileWithPath = "E:\\neweclipse-workspace\\CucumberMyTest\\Screenshot\\failedScreenshot.png";
			TakesScreenshot srcShot = ((TakesScreenshot) driver);

			// Call getScreenshotsAs method to create image file
			File SrcFile = srcShot.getScreenshotAs(OutputType.FILE);

			// Move image file to new destination
			File DestFile = new File(fileWithPath);

			// Copy file at destination
			FileUtils.copyFile(SrcFile, DestFile);
		}
		driver.quit();

	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) {
		
		
		if(scenario.isFailed()) { final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		
		 //attach image file report(data, media type, name of the attachment)
		 scenario .attach(screenshot, "image/png", scenario.getName());
		 }
			
			 
			 
	}

	/*
	 * @BeforeStep public void beforeStepMethodDemo() {
	 * System.out.println("This is before step...."); }
	 * 
	 * @AfterStep public void afterStepMethodDemo() {
	 * System.out.println("This is after step...."); }
	 */
}
