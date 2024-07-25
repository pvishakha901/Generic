package locators.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Wrappers.Button;
import Wrappers.TextBox;
import base.EnvironmentSetup;
import base.TestBase;

public class LoginPage {

	WebDriver driver;
	EnvironmentSetup env;
	public LoginPage(WebDriver driver, EnvironmentSetup env) {
		this.driver = driver;
		this.env = env;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user-name")
	WebElement txtUsername;

	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@value='LOGINa']")
	WebElement loginBtn;

	public void setAccountRef(String userName) {
		TextBox.sendInput(txtUsername, userName);
	}

	public void setPassword(String password) {
		TextBox.sendInput(txtPassword, password);
	}

	public void clickLogin() {
		Button.clickButton(loginBtn);
	}

	public void logonUser() {
		setAccountRef(env.adminUsername());
		setPassword(env.adminPassword());
		clickLogin();

	}

}
