package SeleniumFrameworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
	

	WebDriver driver;
	
	@FindBy(css="[class='hero-primary']")
	WebElement text;
	
	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void getText() {
		
		System.out.println(text.getText());
	}

}
