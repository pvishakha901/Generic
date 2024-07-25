package base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import Wrappers.BrowserFactory;
import utils.FilePath;
import utils.webdriverEvents;

public class TestBase {

	public static WebDriver driver;
	public static webdriverEvents eventListener;
	public static ExtentReports report;
	public static ExtentTest logger;
	public static WebDriver e_driver;
	public static EnvironmentSetup env;

	public ExtentReports getReport() {
		ExtentSparkReporter report = new ExtentSparkReporter(FilePath.extentReportPath);
		report.config().setReportName("EQ2 Automation Result");
		report.config().setDocumentTitle("EQ2 Automation");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "QA Users");
		return extent;
	}

	public String takeScreenShots(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//screenshots//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//screenshots//" + testCaseName + ".png";

	}

	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setdriver() throws IOException {
		env = ConfigFactory.create(EnvironmentSetup.class);

		driver = BrowserFactory.setBrowser(env.browser());
		WebDriverListener listener = new webdriverEvents();
		e_driver = new EventFiringDecorator(listener).decorate(driver);

		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public void navigateTo(String portal) throws IOException {
		if (portal.equalsIgnoreCase("adminURL")) {
			driver.get(env.adminurl());
		}

		else {
			driver.get(portal);
		}

	}

}
