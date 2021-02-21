package shopifyNavSuite;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class shopifyNavTest {
	public String baseUrl = "https://azalea-gas.myshopify.com/";
	public String driverPath = "C://Users/dcurt/Downloads/geckodriver.exe";
	public WebDriver driver;
	public Properties pro;
	public WebDriverWait wait;
	
	@BeforeTest
	public void setBaseURL() throws IOException	{
		File f1 = new File("C:\\Users\\dcurt\\eclipse-workspace\\AzGasSelenium\\AzGasSelenium.properties");
		FileInputStream fis = new FileInputStream(f1);
		pro = new Properties();
		pro.load(fis);
		
		System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.get(baseUrl);
	}
	
	@BeforeMethod
	public void verifyHomePage()	{
		driver.manage().timeouts( ).implicitlyWait(1,TimeUnit.SECONDS) ;
		String expectedTitle = "Welcome to Azalea Gas";
	    String actualTitle = driver.getTitle();
	    Assert.assertEquals(actualTitle, expectedTitle);
	    driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
	}
	
	///////////
	@Test
	public void clickFireplace()	{
		//Click the Fireplace Sets link in the Shopify navbar
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath(pro.getProperty("shopify.fireplace.xpath"))).click();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		
		//Verify that we are at the Fireplace Sets page
		String actual = driver.getCurrentUrl();
		String expect = "https://azaleagas.com/#fireplace";
		Assert.assertEquals(actual, expect);
	}
	///////////
	
	@AfterMethod
	public void returnToSpecial()	{
		driver.findElement(By.xpath(pro.getProperty("header.special.xpath"))).click();
    	driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
    	driver.findElement(By.xpath(pro.getProperty("shopify.logo.xpath"))).click();
    	driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
    	String actual = driver.getCurrentUrl();
		String expect = "https://azalea-gas.myshopify.com/";
		Assert.assertEquals(actual, expect);
	}
	
	@AfterTest
	public void closeBrowser()	{
		driver.quit();
	}
}
