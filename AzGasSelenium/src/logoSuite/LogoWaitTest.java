package logoSuite;


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

public class LogoWaitTest {

	public String baseUrl = "https://www.azaleagas.com";
	public String driverPath = "C://Users/dcurt/Downloads/geckodriver.exe";
	public WebDriver driver;
	public Properties pro;
	public WebDriverWait wait;
	
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
	public void verifyHomepage()	{
		wait = new WebDriverWait(driver, 3);
		String expectedTitle = "Azalea Gas: Home";
		wait.until(ExpectedConditions.titleIs(expectedTitle));
	    String actualTitle = driver.getTitle();
	    Assert.assertEquals(actualTitle, expectedTitle);
	    
	}
	/////////
	/*	Navigate to the Systems Tab, click on the logo
	 * 	verify that we are where we thought we were
	 * 
	 * 	@returns {void}
	 */
	@Test(priority = 0)
	public void systemLogoNavTest()	{
		//Click on the Systems Link in the nav bar
		wait = new WebDriverWait(driver, 3);
		WebElement sys = driver.findElement(By.cssSelector(pro.getProperty("header.system.selector")));
		wait.until(ExpectedConditions.visibilityOf(sys));
		sys.click();
		
		//click on the logo
		WebElement logo = driver.findElement(By.xpath(pro.getProperty("logo.xpath")));
		wait.until(ExpectedConditions.elementToBeClickable(logo));
		logo.click();
		
		//verify that we are back at the home page
		String expectedTitle = "Azalea Gas: Home";
		wait.until(ExpectedConditions.titleIs(expectedTitle));
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
		wait = new WebDriverWait(driver, 3);
		WebElement fire = driver.findElement(By.cssSelector(pro.getProperty("header.fireplace.selector")));
		wait.until(ExpectedConditions.visibilityOf(fire));
		fire.click();
		
		//click on the logo
		WebElement logo = driver.findElement(By.xpath(pro.getProperty("logo.xpath")));
		wait.until(ExpectedConditions.elementToBeClickable(logo));
		logo.click();
		
		//verify that we have gone to the Home Page
		String expectedTitle = "Azalea Gas: Home";
		wait.until(ExpectedConditions.titleIs(expectedTitle));
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
		wait = new WebDriverWait(driver, 3);
		WebElement inst = driver.findElement(By.cssSelector(pro.getProperty("header.instruct.selector")));
		wait.until(ExpectedConditions.visibilityOf(inst));
		inst.click();
		
		//click on the logo
		WebElement logo = driver.findElement(By.xpath(pro.getProperty("logo.xpath")));
		wait.until(ExpectedConditions.elementToBeClickable(logo));
		logo.click();
		
		//verify that we have gone to the Home Page
		String expectedTitle = "Azalea Gas: Home";
		wait.until(ExpectedConditions.titleIs(expectedTitle));
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
		wait = new WebDriverWait(driver, 3);
		WebElement quest = driver.findElement(By.cssSelector(pro.getProperty("header.question.selector")));
		wait.until(ExpectedConditions.elementToBeClickable(quest));
		quest.click();
		
		//Click on the logo
		WebElement logo = driver.findElement(By.xpath(pro.getProperty("logo.xpath")));
		wait.until(ExpectedConditions.elementToBeClickable(logo));
		logo.click();
		
		//verify that we have gone to the Home Page
		String expectedTitle = "Azalea Gas: Home";
		wait.until(ExpectedConditions.titleIs(expectedTitle));
	    String actualTitle = driver.getTitle();
	    Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	/*	Returns to the home page after every test
	 * 
	 * 	@returns {void}
	 */
	@AfterMethod
    public void returnToHome()	{
		wait = new WebDriverWait(driver, 3);
    	WebElement home = driver.findElement(By.cssSelector(pro.getProperty("header.welcome.selector")));
    	wait.until(ExpectedConditions.visibilityOf(home));
    	home.click();
    	
		String expect = "https://www.azaleagas.com/#home";
		wait.until(ExpectedConditions.urlToBe(expect));
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expect);
    }
	
	/*	Shuts down the browser, nothing more to see here
	 * 
	 * @returns {void}
	 */
    @AfterTest
    public void closeBrowser()	{
      driver.quit();
    }
}
