package mainContentSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.JavascriptExecutor;

public class MainContentTest {
	
	public String baseUrl = "https://www.azaleagas.com/";
	public String driverPath = "C://Users/dcurt/Downloads/geckodriver.exe";
	public WebDriver driver;
	public Properties pro;
	
	/*	Navigate to the website
	 * 
	 * 	@returns {void}
	 */
	@BeforeTest
	public void setBaseUrl() throws IOException {
		File f1 = new File("C:\\Users\\dcurt\\eclipse-workspace\\AzGasSelenium\\AzGasSelenium.properties");
		FileInputStream fis = new FileInputStream(f1);
		pro = new Properties();
		pro.load(fis);
		
		System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        //navigate to website
        driver.get(baseUrl);
	}
	/*	Verify that we are starting at the homepage before each test
	 * 
	 * 	@returns {void}
	 */
	@BeforeMethod
	public void verifyHomepage()	{
		
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		String expectedTitle = "Azalea Gas: Home";
		//
	    String actualTitle = driver.getTitle();
	    Assert.assertEquals(actualTitle, expectedTitle);
	    driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
	}
	
	/*	Navigate to Systems, scroll to the bottom of the page
	 * 	click on Instructions, verify we are where we thought we were
	 * 
	 * 	@returns {void}
	 */
	@Test
	public void systemsLinkTest()	{
		//Click on Systems link in the nav bar
		driver.findElement(By.cssSelector(pro.getProperty("header.system.selector"))).click();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		
		//Scroll to the bottom of the page
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.END);
		actions.perform();
		
		//Click on the Instructions link
		driver.findElement(By.cssSelector(pro.getProperty("instruct.system.selector"))).click();
		
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		
		//Verify that we have gone to Instructions
		String actual = driver.getCurrentUrl();
		String expect = "https://www.azaleagas.com/#instruct";
		Assert.assertEquals(actual, expect);
	}
	
	/*	Navigate to Q & A, click on the 1st Instructions link
	 * 	verify that we are where we thought we were 
	 * 
	 * 	@returns {void}
	 */
	@Test
	public void questionsLinkTestOne()	{
		//Click on Q & A link in the nav bar
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		driver.findElement(By.cssSelector(pro.getProperty("header.question.selector"))).click();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		
		//Click on the Instructions link
		driver.findElement(By.xpath(pro.getProperty("instruct.questOne.xpath"))).click();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		
		//verify that we gone to Instructions
		String actual = driver.getCurrentUrl();
		String expect = "https://www.azaleagas.com/#instruct";
		Assert.assertEquals(actual, expect);
	}
	
	/*	Navigate to Q & A, scroll to the 2nd Instructions link and click
	 * 	verify that we are where we thought we were
	 * 
	 * 	@returns {void}
	 */
	@Test
	public void questionsLinkTestTwo()	{
		//Click on Q & A link in the nav bar
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		driver.findElement(By.cssSelector(pro.getProperty("header.question.selector"))).click();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		
		//Scroll to the 2nd Instructions Link
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(pro.getProperty("instruct.questTwo.xpath")));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		
		//Click on the Instructions link
		driver.findElement(By.xpath(pro.getProperty("instruct.questTwo.xpath"))).click();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		
		//Verify that we have gone to Instructions
		String actual = driver.getCurrentUrl();
		String expect = "https://www.azaleagas.com/#instruct";
		Assert.assertEquals(actual, expect);
	}
	
	/*	Navigate back to the HomePage after each test
	 * 
	 * 	@returns	{void}
	 */
	@AfterMethod
    public void returnToHome()	{
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
    	driver.findElement(By.xpath(pro.getProperty("footer.welcome.xpath"))).click();
    	driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
    	String actual = driver.getCurrentUrl();
		String expect = "https://www.azaleagas.com/#home";
		Assert.assertEquals(actual, expect);
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
