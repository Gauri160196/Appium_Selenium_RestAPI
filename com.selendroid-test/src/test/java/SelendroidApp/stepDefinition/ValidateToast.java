package SelendroidApp.stepDefinition;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ValidateToast {

	AppiumDriver<MobileElement> driver;

	@Given("I am again on homepage")
	public void I_am_again_on_homepage() throws InterruptedException, MalformedURLException {
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
	
	@And("click on display toast button")
	public void click_on_display_toast_button() {
		MobileElement toastButton = driver.findElement(By.id("io.selendroid.testapp:id/showToastButton"));
		toastButton.click();
	}

	@Then("verify toast text")
	public void verify_toast_text() {
	}

}
