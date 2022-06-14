package JqeuryWeb.tests;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Jquery_SeleniumTestCases {
	
	@Test(priority=0)
	public void openJquery(){
		System.setProperty("webdriver.chrome.driver",
		         ".\\driver\\chromedriver.exe");
	    
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
		boolean b1=  driver.findElement(By.xpath("//a[@href=\"http://jqueryui.com/draggable/\"]")).isDisplayed();
		System.out.println(b1 + "Draggable Element is Displayed");
		
		driver.get("https://jqueryui.com/droppable/");
		
		driver.findElement(By.xpath("//a[@href=\"http://jqueryui.com/droppable/\"]")).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Store the web element
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));

		//Switch to the frame
		driver.switchTo().frame(iframe);		
	
		Actions builder = new Actions(driver);
		 
		WebElement from = driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
		 
		WebElement to = driver.findElement(By.xpath("//div[@id=\"droppable\"]"));
		//Perform drag and drop
		builder.dragAndDrop(from, to).perform();
		
		//verify text changed in to 'Drop here' box 
		String textTo = to.getText();

		if(textTo.equals("Dropped!")) {
			System.out.println("PASS: Source is dropped to target as expected");
		}else {
			System.out.println("FAIL: Source couldn't be dropped to target as expected");
		}
		
		driver.quit();
		
		
				
	}

}
