 package Wrappers;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import base.TestBase;


public class BrowserFactory extends TestBase{
	
	public static WebDriver driver;
	
	public static WebDriver setBrowser(String browserName) throws IOException {
		
		switch (browserName) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "IE":
			driver = new InternetExplorerDriver();
			break;

		}
		return driver;
	}
	
}


