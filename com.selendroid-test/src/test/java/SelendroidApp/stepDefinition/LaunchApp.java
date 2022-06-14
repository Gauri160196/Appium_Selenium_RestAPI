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

public class LaunchApp {
	
	AppiumDriver<MobileElement> driver;
	

	@Given("Application is launched")
	public void user_launches_application() throws InterruptedException, MalformedURLException {
		
		//Giving desired capabililties
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
		
		//click continue button whenever it directly opens
		MobileElement continueButton = driver.findElement(By.id("com.android.permissioncontroller:id/continue_button"));
		continueButton.click();

		Thread.sleep(5000);
		//click on ok button in popup
		MobileElement okButton = driver.findElement(By.id("android:id/button1"));
		okButton.click();

		Thread.sleep(5000);
	}

	@Then("verify title in application")
	public void verify_title_in_application() {
		MobileElement title = driver.findElement(By.id("android:id/title"));
		Assert.assertEquals(title.getText(), "selendroid-test-app");
	}

	@Then("verify elements on homepage")
	public void verify_elements_on_homepage() {
		MobileElement ENButton = driver.findElement(By.id("io.selendroid.testapp:id/buttonTest"));
		Assert.assertEquals(ENButton.isDisplayed(), true);
	}

}
