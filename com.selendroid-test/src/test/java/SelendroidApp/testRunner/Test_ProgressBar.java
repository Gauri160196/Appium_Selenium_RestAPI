package SelendroidApp.testRunner;


import java.net.MalformedURLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/Features/selendroid-test-app.feature"
		, tags = "@Scenario4"
		, glue = "SelendroidApp.stepDefinition"
		, plugin = {"pretty", "html:results/ProgressBar_Results_Scenario4.html"}
		, monochrome = true
		)

@Test
public class Test_ProgressBar extends AbstractTestNGCucumberTests {

	@BeforeTest
	public void setup() throws MalformedURLException, InterruptedException {
		System.out.println("Test Started for Progress Bar");
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("Test Ended for Progress Bar");
	}
	
}