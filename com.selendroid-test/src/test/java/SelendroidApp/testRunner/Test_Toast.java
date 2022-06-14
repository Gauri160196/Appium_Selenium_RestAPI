package SelendroidApp.testRunner;

import java.net.MalformedURLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features/selendroid-test-app.feature"
		, tags = "@Scenario5"
		, glue = "SelendroidApp.stepdefinition"
		, plugin = {"pretty", "html:results/Toast_Results_Scenario5.html"}
		, monochrome = true
		)

@Test
public class Test_Toast extends AbstractTestNGCucumberTests {

	@BeforeTest
	public void setup() throws MalformedURLException, InterruptedException {
		System.out.println("Test Started for Toast");
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("Test Ended for Toast");
	}
	
}