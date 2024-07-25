package utils;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import base.TestBase;

public class webdriverEvents extends TestBase implements WebDriverListener {

	public void beforeAnyWebDriverCall​(WebDriver driver) {
		System.out.println("Calling Driver");
	}

	public void beforeGetCurrentUrl(WebDriver driver) {
		System.out.println("Getting Current URL");
	}

	public void afterGetCurrentUrl(String result, WebDriver driver) {
		System.out.println("Current URL is: " + result);

	}

	public void afterAnyWebDriverCall​(WebDriver driver) {
		System.out.println("Webdriver Called");
	}

	public void beforeSendKeys​(WebElement element) {
		System.out.println("sending keys to" + element);
	}

	public void beforeClick(WebElement element) {
		System.out.println("Attempting to click webemelent");
	}

	public void beforeFindElement(WebDriver driver, By locator) {
		System.out.println("Finding " + locator);
	}

	public void afterFindElement(WebDriver driver, By locator, WebElement result) {
		System.out.println("Found " + locator);
	}

	public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
		System.out.println("Entering details");
	}

	public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
		System.out.println("Entered details ");
	}
}
