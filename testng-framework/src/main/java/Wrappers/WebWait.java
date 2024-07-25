package Wrappers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebWait {

	
	public static void explicitWait(WebDriver driver, WebElement element, Duration timeout) {
		  WebDriverWait wait = new WebDriverWait(driver,timeout);
		  wait.until(ExpectedConditions.visibilityOf(element));
		 }
	
	
	
}
