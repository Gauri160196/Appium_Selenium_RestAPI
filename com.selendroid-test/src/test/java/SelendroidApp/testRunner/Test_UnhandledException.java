package SelendroidApp.testRunner;

import java.net.MalformedURLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features/selendroid-test-app.feature"
		, tags = "@Scenario6"
		, glue = "SelendroidApp.stepdefinition"
		, plugin = {"pretty", "html:results/UnhandledException_Scenario6.html"}
		, monochrome = true
		)

@Test
public class Test_UnhandledException extends AbstractTestNGCucumberTests {

	@BeforeTest
	public void setup() throws MalformedURLException, InterruptedException {
		System.out.println("Testing Started");
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("Testing Ended");
	}
	
}