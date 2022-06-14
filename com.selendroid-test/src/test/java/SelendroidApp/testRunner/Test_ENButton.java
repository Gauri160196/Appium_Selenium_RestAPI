package SelendroidApp.testRunner;
import java.net.MalformedURLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features/selendroid-test-app.feature"
		, tags = "@Scenario2"
		, glue = "SelendroidApp.stepDefinition"
		, plugin = {"pretty", "html:results/TestENButton_Scenario2.html"}
		, monochrome = true
		)

@Test
public class Test_ENButton extends AbstractTestNGCucumberTests {

	@BeforeTest
	public void setup() throws MalformedURLException, InterruptedException {
		System.out.println(" Started Test for EN Button");
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("End Test for EN Button");
	}
	
}