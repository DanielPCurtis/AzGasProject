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
	
	/*	Navigate to the web address
	 * 
	 * 	@returns {void}
	 */
	@BeforeTest
	public void setBaseURL() throws IOException	{
		File f1 = new File("C:\\Users\\dcurt\\eclipse-workspace\\AzGasSelenium\\AzGasSelenium.properties");
		FileInputStream fis = new FileInputStream(f1);
		pro = new Properties();
		pro.load(fis);
		
		System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        wait = new WebDriverWait(driver, 3);
	}
	
	/*	Verify that we are at the HomePage
	 * 	of the Shopify page before each test
	 * 
	 * 	@returns {void}
	 */
	@BeforeMethod
	public void verifyHomePage()	{
		
		String expectedTitle = "Welcome to Azalea Gas";
		wait.until(ExpectedConditions.titleIs(expectedTitle));
	    String actualTitle = driver.getTitle();
	    Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	/*	Click Tank Systems in the navbar on the Shopify page
	 * 	verify that we are where we thought we were
	 * 
	 * 	@returns {void}
	 */
	@Test(priority = 0)
	public void clickSystems()	{
		//Click the Tank Systems link in the Shopify navbar
		WebElement sys = driver.findElement(By.xpath(pro.getProperty("shopify.system.xpath")));
		wait.until(ExpectedConditions.elementToBeClickable(sys));
		sys.click();
		
		//Verify that we are at the Tank Systems page
		String expect = "https://azaleagas.com/#systems";
		wait.until(ExpectedConditions.urlToBe(expect));
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expect);
	}
	
	/*	Click Fireplace in the navbar on the Shopify page
	 * 	verify that we are where we thought we were
	 * 
	 * 	@returns {void}
	 */
	@Test(priority = 1)
	public void clickFireplace()	{
		//Click the Fireplace Sets link in the Shopify navbar
		WebElement fire = driver.findElement(By.xpath(pro.getProperty("shopify.fireplace.xpath")));
		wait.until(ExpectedConditions.elementToBeClickable(fire));
		fire.click();
		
		//Verify that we are at the Fireplace Sets page
		String expect = "https://azaleagas.com/#fireplace";
		wait.until(ExpectedConditions.urlToBe(expect));
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expect);
	}
	
	/*	Click Instructions in the navbar on the Shopify page
	 * 	verify that we are where we thought we were
	 * 
	 * 	@returns {void}
	 */
	@Test(priority = 2)
	public void clickInstructions()	{
		//Click the Instructions link in the Shopify navbar
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath(pro.getProperty("shopify.instruct.xpath"))).click();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		
		//Verify that we are at the Instructions page
		String expect = "https://azaleagas.com/#instruct";
		wait.until(ExpectedConditions.urlToBe(expect));
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expect);
	}
	
	/*	Click Questions in the navbar on the Shopify page
	 * 	verify that we are where we thought we were
	 * 
	 * 	@returns {void}
	 */
	@Test(priority = 3)
	public void clickQuestions()	{
		//Click the Q & A link in the Shopify navbar
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath(pro.getProperty("shopify.question.xpath"))).click();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		
		//Verify that we are at the Questions page
		String expect = "https://azaleagas.com/#questions";
		wait.until(ExpectedConditions.urlToBe(expect));
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expect);
	}
	
	/*	Click Catalog in the navbar on the Shopify page
	 * 	verify that we are where we thought we were
	 * 
	 * 	@returns {void}
	 */
	@Test(priority = 4)
	public void clickCatalog()	{
		//Click the Catalog link in the Shopify navbar
		WebElement cat = driver.findElement(By.xpath(pro.getProperty("shopify.catalog.xpath")));
		wait.until(ExpectedConditions.elementToBeClickable(cat));
		cat.click();
		
		//Verify that we are at the Instructions page
		String expect = "https://azalea-gas.myshopify.com/collections/all";
		wait.until(ExpectedConditions.urlToBe(expect));
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expect);
		
		//Click the Q & A link in the Shopify navbar
		WebElement quest = driver.findElement(By.xpath(pro.getProperty("shopify.question.xpath")));
		wait.until(ExpectedConditions.elementToBeClickable(quest));
		quest.click();
	}
	
	@AfterMethod
	public void returnToSpecial()	{
		
		WebElement spec = driver.findElement(By.xpath(pro.getProperty("header.special.xpath")));
		wait.until(ExpectedConditions.elementToBeClickable(spec));
		spec.click();
		
    	WebElement logo = driver.findElement(By.xpath(pro.getProperty("shopify.logo.xpath")));
    	wait.until(ExpectedConditions.elementToBeClickable(logo));
		logo.click();
    	
		String expect = "https://azalea-gas.myshopify.com/";
		wait.until(ExpectedConditions.urlToBe(expect));
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expect);
	}
	
	@AfterTest
	public void closeBrowser()	{
		driver.quit();
	}
}
