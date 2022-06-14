package SelendroidApp.stepDefinition;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestENButton {
	
	AppiumDriver<MobileElement> driver;
	
	@Given("I am on the homepage")
	public void I_am_on_the_homepage() throws InterruptedException, MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Redmi Note 8 Pro");
		cap.setCapability("udid", "nrucmjhircnfskhm");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10");
		
		cap.setCapability("appPackage", "io.selendroid.testapp");
		cap.setCapability("appActivity", ".HomeScreenActivity");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub/");
		driver = new AppiumDriver<MobileElement>(url, cap);
		
		System.out.println("Application started");
		
		MobileElement continueButton = driver.findElement(By.id("com.android.permissioncontroller:id/continue_button"));
		continueButton.click();

		Thread.sleep(2000);

		MobileElement okButton = driver.findElement(By.id("android:id/button1"));
		okButton.click();

		Thread.sleep(2000);
		
		MobileElement title = driver.findElement(By.id("android:id/title"));
		Assert.assertEquals(title.getText(), "selendroid-test-app");
	}

	@When("user clicks on EN button")
	public void user_clicks_on_en_button() {
		MobileElement ENButton = driver.findElement(By.id("io.selendroid.testapp:id/buttonTest"));
		ENButton.click();
	}

	@When("selects [No, no]")
	public void selects_no_no() {
		MobileElement NoNoButton = driver.findElement(By.id("android:id/button2"));
		NoNoButton.click();
	}

	@Then("user should be on homepage")
	public void user_should_be_on_homepage() {
		MobileElement title = driver.findElement(By.id("android:id/title"));
		Assert.assertEquals(title.getText(), "selendroid-test-app");
	}

}
