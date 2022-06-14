package JqeuryWeb.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Jquery_Select_SeleniumTC {
	
	@Test(priority=0)
	public void SelectTC_001(){
		System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
	    
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@href=\"http://jqueryui.com/selectable/\"]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Store the web element
		WebElement iframe = driver.findElement(By.xpath("//iframe[@src='/resources/demos/selectable/default.html']"));
		//Switch to the frame
		driver.switchTo().frame(iframe);
		List<WebElement> p = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
	    System.out.println("Menu Items are: ");
	      //iterate through list
	    for( WebElement i: p){
	         System.out.println(i.getText());
	    }
	    Actions action=new Actions(driver);
	    action.keyDown(Keys.CONTROL).build().perform();
	    
	    driver.findElement(By.xpath(".//*[@id='selectable']/li[1]")).click();
	    driver.findElement(By.xpath(".//*[@id='selectable']/li[3]")).click();
	    driver.findElement(By.xpath(".//*[@id='selectable']/li[7]")).click();
	    
	    System.out.println("Item Values are selected ");

	    

	    action.keyUp(Keys.CONTROL).build().perform();

		driver.quit();


//	      // select with text visible
//	      // select with index
//	      sel.selectByIndex(5);
	}
}
