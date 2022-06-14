package JqeuryWeb.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Jquery_Controlgroup_SeleniumTC {
	
	@Test
	public void SelectTC_001(){
		System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
	    
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@href=\"http://jqueryui.com/controlgroup/\"]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Store the web element
		WebElement iframe = driver.findElement(By.xpath("//iframe[@src='/resources/demos/controlgroup/default.html']"));
		//Switch to the frame
		driver.switchTo().frame(iframe);
		WebElement radioAutomaticbtn = driver.findElement(By.xpath("//label[@for='transmission-automatic']"));							
        WebElement checkInsurance = driver.findElement(By.xpath("//label[@for='insurance']"));
        
        radioAutomaticbtn.click();
        checkInsurance.click();
        
      //to perform Scroll on application using Selenium
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)", "");
        
        
        
        Select sel = new Select(driver.findElement(By.xpath("//span[@id=\"ui-id-8-button\"]")));
		sel.selectByVisibleText("Truck");

	    WebElement radiobtnTruck = driver.findElement(By.xpath("//label[@for='transmission-automatic-v']"));							
	    WebElement checkinsTruck = driver.findElement(By.xpath("//label[@for='insurance-v']"));							
	    radiobtnTruck.click();
	    checkinsTruck.click();
	    //driver.findElement(By.xpath("//button[@id=\"book\"]")).click();	
	}
        
	   

}
