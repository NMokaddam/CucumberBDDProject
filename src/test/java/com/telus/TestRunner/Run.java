package com.telus.TestRunner;

import io.cucumber.testng.CucumberOptions;

//import org.junit.runner.RunWith;

//import org.junit.runner.RunWith;
//import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".//Features/LoginFeature.feature",},
		
	//	features = ".//Features/",
		glue= "com.telus.StepDefination",
		dryRun = false,
		monochrome = true,
		tags="@sanity", //scenarios under @sanity tag will be executed 
		plugin = {"pretty","html:target/cucumber-reports/reports.html"}
		
		)

public class Run extends  AbstractTestNGCucumberTests {

	/*
	 this class will be empty
	 */
}
