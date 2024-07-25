package testcases.workflow;

import java.io.IOException;

import org.testng.annotations.Test;

import base.TestBase;
import locators.login.LoginPage;

public class Login extends TestBase {

	@Test
	public void navigateToRegisterPage() throws IOException, InterruptedException {
		LoginPage login = new LoginPage(driver, env);
		navigateTo("adminURL");
		login.logonUser();
	}
}
