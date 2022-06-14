package SelendroidApp.testRunner;


import java.net.MalformedURLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/Features/selendroid-test-app.feature"
		, tags = "@Scenario1"
		, glue = "SelendroidApp.stepDefinition"
		, plugin = {"pretty", "html:results/LaunchAppandVerifyElements_Results_Scenario1.html"}
		, monochrome = true
		)

@Test
public class Test_LaunchApp extends AbstractTestNGCucumberTests {

	@BeforeTest
	public void setup() throws MalformedURLException, InterruptedException {
		System.out.println("Test Started and Application is Launch");
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("Testing Done");
	}
	
}