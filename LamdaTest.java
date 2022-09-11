package scripts;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LamdaTest {

	public void test(){
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("https://www.Somewebsite.com/");
		WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
		driver.findElement(By.xpath("//*[@id=\"user-message\"]")).sendKeys("This is test TEXT");
		driver.findElement(By.cssSelector("#showInput")).click();
		new Actions(driver)
		.moveToElement(firstResult)
		.pause(Duration.ofSeconds(1))
		.clickAndHold()
		.pause(Duration.ofSeconds(1))
		.sendKeys("abc");
		
		JavascriptExecutor e;
		}
	
}
