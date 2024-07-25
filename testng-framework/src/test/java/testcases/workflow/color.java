package testcases.workflow;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;




public class color {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
    //    WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

        // Navigate to the webpage
        driver.get("https://sit-p.citplatform.com/");
        
        WebElement loginButton = driver.findElement(By.xpath("//button[.='Login']"));
        String colorPropertyValue = loginButton.getCssValue("color");
        String buttonColor = ConvertToRgb(colorPropertyValue);
        System.out.println("Color of the login button: " + buttonColor);

	}
	 public static String ConvertToRgb(String colorPropertyValue) throws Exception
	    {
	        // Example logic to convert colorPropertyValue to RGB format
	        if (colorPropertyValue.startsWith("rgb"))
	        {
	            return colorPropertyValue;
	        }
	        else if (colorPropertyValue.startsWith("#"))
	        {
	            // If already in hex format, return it as it is
	            return colorPropertyValue;
	        }
	        else
	        {
	            throw new Exception("Unsupported color format");
	        }
	    }
}
