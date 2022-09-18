package misc;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class MyFirstTestNGTest {
	WebDriver driver;

	
//	@Test
	public void google_search_test() throws InterruptedException {
		driver.get("https://www.panamacompra.gob.pa/Inicio/#/");
	
		try {
		driver.findElement(By.xpath("//button[text()=\" Iniciar sesión\"]")).click();
		} catch (ElementNotInteractableException e) {
			driver.findElement(By.xpath("//button[text()=\" Iniciar sesión\"]")).click();
		}
		Thread.sleep(5000);
	}
	
	public String generateString(int length) {
	    char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	    StringBuilder sb = new StringBuilder();
	    Random rand = null;
	    try {
	        rand = SecureRandom.getInstanceStrong();
	    } catch (NoSuchAlgorithmException e) {
	        throw new RuntimeException(e);
	    }
	    for (int i = 1; i <= length; i++) {
	        char c = chars[rand.nextInt(chars.length)];
	        sb.append(c);
	    }
	    String first = sb.toString();	  
	    return first;
	}
	
	@Test
	public void testGenerateString() {
		driver.get("https://www.google.com");
		System.out.println("Generated String - "+ generateString(4067));
		driver.findElement(By.name("q")).sendKeys(generateString(4067));
		WebDriverWait wait = (new WebDriverWait(driver, 120));
		
	}

//	@Test
	public void soverf() {
		driver.get("https://juliemr.github.io/protractor-demo/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//WebElement body = driver.findElement(By.xpath("/html/body"));		
		//js.executeScript("var injector = window.angular.element(arguments[0]).injector(); var $http = injector.get('$http'); return ($http.pendingRequests.length === 0);",body);
      String angularReady = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";

	  boolean isAngularReady = (boolean)js.executeScript(angularReady);
	  System.out.println("Angular is Ready? " + isAngularReady);
	}
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\chromedriver.exe");
	driver = new ChromeDriver();

	}

	@AfterClass
	public void afterClass() {
	//	driver.quit();
	}

}
