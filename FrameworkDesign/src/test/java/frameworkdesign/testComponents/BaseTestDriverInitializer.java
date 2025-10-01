package frameworkdesign.testComponents;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import SeleniumFrameworks.LoginPageTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestDriverInitializer {
	
        public WebDriver driver;
        
        
        public WebDriver initializeDriver() {
        	
        	WebDriverManager.chromedriver().setup();
        	driver = new ChromeDriver();
        	return driver;
        }
        
        @BeforeMethod(alwaysRun=true)
        public LoginPageTest launchApplication() {
        	
        	driver = initializeDriver();
        	LoginPageTest loginpagetest = new LoginPageTest(driver);
        	loginpagetest.goTo();
        	
        	return loginpagetest;
        	
        }
        
        public List<HashMap<String,String>> getJsonDataToMap(String filePath) throws IOException {
        	
        	String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
        	
        	ObjectMapper mapper = new ObjectMapper();
        	
        	List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
        		
        	});
        	return data;
        	
        }
        
        @AfterMethod(alwaysRun = true)
        public void quit() {
        	driver.close();
        	driver.quit();
        }
        
        public String getScreenShot(String testCaseName) throws IOException {
        	
        	TakesScreenshot ts = (TakesScreenshot)driver;
        	File source = ts.getScreenshotAs(OutputType.FILE);
        	File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
        	FileUtils.copyFile(source, file);
        	return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
        	
        }
        
        
	
}
