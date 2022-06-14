package SelendroidApp.testRunner;


import java.net.MalformedURLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features/selendroid-test-app.feature"
		, tags = "@Scenario3"
		, glue = "SelendroidApp.stepDefinition"
		, plugin = {"pretty", "html:results/VerifyChromeLogoandTitle_Results_Scenario3.html"}
		, monochrome = true
		)

@Test
public class Test_ChromeLogo extends AbstractTestNGCucumberTests {

	@BeforeTest
	public void setup() throws MalformedURLException, InterruptedException {
		System.out.println("Chrome Logo Testing Started and User is on Home Page");
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("Testing Ended -Validate Chrome Logo and Title");
	}
	
}