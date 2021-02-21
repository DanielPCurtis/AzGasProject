/*
 * @author Daniel Curtis
 */
package logoSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LogoTest {

	public String baseUrl = "https://azaleagas.com/";
	public String driverPath = "C://Users/dcurt/Downloads/geckodriver.exe";
	public WebDriver driver;
	public Properties pro;
	
	/*	Navigate to the website
	 * 
	 * 	@returns {void}
	 */
	@BeforeTest
	public void setBaseUrl() throws IOException	{
		File f1 = new File("C:\\Users\\dcurt\\eclipse-workspace\\AzGasSelenium\\AzGasSelenium.properties");
		FileInputStream fis = new FileInputStream(f1);
		pro = new Properties();
		pro.load(fis);
		
		System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.get(baseUrl);
	}
	
	/*	Verify that we are starting at the homepage before each test
	 * 
	 * 	@returns {void}
	 */
	@BeforeMethod
	public void verifyHomePage()	{
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		String expectedTitle = "Azalea Gas: Home";
	    String actualTitle = driver.getTitle();
	    Assert.assertEquals(actualTitle, expectedTitle);
	    driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
	}
	
	/*	Navigate to the Systems Tab, click on the logo
	 * 	verify that we are where we thought we were
	 * 
	 * 	@returns {void}
	 */
	@Test(priority = 0)
	public void systemLogoNavTest()	{
		
		//Click on the Systems Link in the nav bar
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
		driver.findElement(By.cssSelector(pro.getProperty("header.system.selector"))).click();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		
		//click on the logo
		driver.findElement(By.xpath(pro.getProperty("logo.xpath"))).click();
		
		//verify that we are back at the home page
		String expectedTitle = "Azalea Gas: Home";
	    String actualTitle = driver.getTitle();
	    Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	/*	Navigate to Fireplace Sets, click on the logo
	 * 	verify that we are where we thought we were
	 * 
	 * 	@returns {void}
	 */
	@Test(priority = 1)
	public void fireplaceLogoNavTest()	{
		
		//Click on the Fireplace Sets link in the nav bar
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
		driver.findElement(By.cssSelector(pro.getProperty("header.fireplace.selector"))).click();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		
		//click on the logo
		driver.findElement(By.xpath(pro.getProperty("logo.xpath"))).click();
		
		//verify that we have gone to the Home Page
		String expectedTitle = "Azalea Gas: Home";
	    String actualTitle = driver.getTitle();
	    Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	/*	Navigate to Instructions, click on the logo
	 * 	verify that we are where we thought we are
	 * 
	 * 	@returns {void}
	 */
	@Test(priority = 2)
	public void instructLogoNavTest()	{
		
		//Click on the Instructions link in the nav bar
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
		driver.findElement(By.cssSelector(pro.getProperty("header.instruct.selector"))).click();
		
		//Click on the logo
		driver.findElement(By.xpath(pro.getProperty("logo.xpath"))).click();
		
		//verify that we have gone to the Home Page
		String expectedTitle = "Azalea Gas: Home";
	    String actualTitle = driver.getTitle();
	    Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	/*	Navigate to Questions, click on the logo
	 * 	verify that we are where we thought we were
	 * 
	 * 	@returns {void}
	 */
	@Test(priority = 3)
	public void questionLogoNavTest()	{
		//Click on Q & A in the nav bar
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
		driver.findElement(By.cssSelector(pro.getProperty("header.question.selector"))).click();
		
		//Click on the logo
		driver.findElement(By.xpath(pro.getProperty("logo.xpath"))).click();
		
		//verify that we have gone to the Home Page
		String expectedTitle = "Azalea Gas: Home";
	    String actualTitle = driver.getTitle();
	    Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	/*	Close the browser after all tests have run
	 * 
	 * 	@returns {void}
	 */
	@AfterTest
	public void closeBrowser()	{
		driver.quit();
	}
}
