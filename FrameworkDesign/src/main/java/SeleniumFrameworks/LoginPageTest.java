package SeleniumFrameworks;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableComponents.AbstractComponent;

public class LoginPageTest extends AbstractComponent {
	
	WebDriver driver;
	
	public LoginPageTest(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "userEmail")
	WebElement useremail;
	
	@FindBy(id = "userPassword")
	WebElement userpassword;
	
	@FindBy(id = "login")
	WebElement submit;
	
	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
		
	}
	
	public void loginApplication(String email, String password) {
		useremail.sendKeys(email);
		userpassword.sendKeys(password);
		submit.click();
		
		
	}
	
	public String getErrorMessage() {
		
		waitForWebElementToAppear(errorMessage);
		System.out.println(errorMessage.getText());
		return errorMessage.getText();
	}
	
	
	

}
