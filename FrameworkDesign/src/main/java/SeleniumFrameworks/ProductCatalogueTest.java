package SeleniumFrameworks;

import java.time.Duration;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductCatalogueTest {
	
WebDriver driver;
	
	public ProductCatalogueTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="h5 b")
	List<WebElement> products;
	
	By productBy = By.cssSelector(".mb-3");
	
	public List<WebElement> getProductList() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productBy));
		
		return products;
		
	}
	
	public void addToCart(String productNames) throws InterruptedException {
		
		for(int i=0; i<getProductList().size(); i++) {
			
			String name = getProductList().get(i).getText();
			List<String> items = Arrays.asList(productNames);
			
			if(items.contains(name)) {
				
				driver.findElements(By.xpath("//button[text() = ' Add To Cart']")).get(i).click();
				Thread.sleep(5000);
			}
		}
		
	}
	
	public void goToCart() {
		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
	}

}
