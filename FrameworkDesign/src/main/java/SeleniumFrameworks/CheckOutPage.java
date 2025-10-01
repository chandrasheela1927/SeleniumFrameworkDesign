package SeleniumFrameworks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
	
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "a[class*='action__submit']")
	WebElement placeOrder;
	
	By countryNames = By.cssSelector(".ta-results");
	
	public List<WebElement> selectCountry(String countryName) {
		
		WebElement selectCountry = driver.findElement(By.cssSelector("input[placeholder='Select Country']"));
		selectCountry.sendKeys(countryName);
		waitForElementToAppear(countryNames);
		
		List<WebElement> result = driver.findElements(By.cssSelector("section button span"));
		
		for(int i=0; i<result.size(); i++) {
			String country = result.get(i).getText();
			if(country.equalsIgnoreCase(countryName)) {
				
				result.get(i).click();
			}
		}
		
		return result;
	}
	
	public void placaOrder() {
		placeOrder.click();
		
	}
	
	
	

}
