package frameworkdesign.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import SeleniumFrameworks.CartPageTest;
import SeleniumFrameworks.CheckOutPage;
import SeleniumFrameworks.ConfirmationPage;
import SeleniumFrameworks.LoginPageTest;
import SeleniumFrameworks.ProductCatalogueTest;
import frameworkdesign.testComponents.BaseTestDriverInitializer;

public class MainTest extends BaseTestDriverInitializer { 

	
	@Test(dataProvider = "getData", groups="Purchase")
	public void submitOrder(HashMap<String, String> input) throws InterruptedException {
		
		launchApplication();
		
		LoginPageTest login = new LoginPageTest(driver);
		login.loginApplication(input.get("email"), input.get("password"));
		
		ProductCatalogueTest productList = new ProductCatalogueTest(driver);
		productList.addToCart(input.get("product"));
		productList.goToCart();
		
		
		CartPageTest cartPage = new CartPageTest(driver);
		cartPage.verifyProductDisplay(input.get("product"));
		Thread.sleep(1000);
		cartPage.goToCheckOutPage();
		
		CheckOutPage checkout = new CheckOutPage(driver);
		checkout.selectCountry("india");
		checkout.placaOrder();
		
		//ConfirmationPage confirmText = new ConfirmationPage(driver);
		//confirmText.getText();
		
		
	}
	
	@DataProvider
	public Object[][] getData() throws StreamReadException, IOException, DatabindException{
		
		List<HashMap<String, String>> data = getJsonDataToMap("C://Users//Admin//eclipse-workspace//FrameworkDesign//src//test//java//frameworkdesign//data//PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
}
