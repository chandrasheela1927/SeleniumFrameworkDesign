package frameworkdesign.test;

import org.testng.Assert;

import SeleniumFrameworks.LoginPageTest;
import frameworkdesign.testComponents.BaseTestDriverInitializer;

public class ErrorValidationTest extends BaseTestDriverInitializer {
	
	public void loginErrorValidation() {
		
		LoginPageTest loginpage = new LoginPageTest(driver);
		loginpage.loginApplication("ingaleshwarsharan412@gmail.com", "Rudrakshi1927");
		Assert.assertEquals("Incorrect email or password.", loginpage.getErrorMessage());
		
	}

}
