package SeleniumFrameworks;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPageTest {
	
	WebDriver driver;
	
	public CartPageTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "li div h3")
	List<WebElement> cartProducts;
	
	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkout;
	
	public boolean verifyProductDisplay(String productnames) {
		
		boolean match = cartProducts.stream().anyMatch(name->name.getText().equalsIgnoreCase(productnames.toString()));
		return match;
	}
	
	public void goToCheckOutPage() {
		checkout.click();
		
	}
	
	
	

}
