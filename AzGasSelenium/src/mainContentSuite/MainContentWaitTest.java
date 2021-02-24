package mainContentSuite;

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

public class MainContentWaitTest {
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
        wait = new WebDriverWait(driver, 3);
	}
	
	/*	Verify that we are starting at the homepage before each test
	 * 
	 * 	@returns {void}
	 */
	@BeforeMethod
	public void verifyHomepage()	{
		String expectedTitle = "Azalea Gas: Home";
		wait.until(ExpectedConditions.titleIs(expectedTitle));
	    String actualTitle = driver.getTitle();
	    Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	/*	Navigate to Systems, scroll to the bottom of the page
	 * 	click on Instructions, verify we are where we thought we were
	 * 
	 * 	@returns {void}
	 */
	@Test
	public void systemsLinkTest()	{
		//Click on Systems link in the nav bar
		WebElement sys = driver.findElement(By.cssSelector(pro.getProperty("header.system.selector")));
		wait.until(ExpectedConditions.elementToBeClickable(sys));
		sys.click();
		
		//Scroll to the bottom of the page
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.END);
		actions.perform();
		
		//Click on the Instructions link
		WebElement inst = driver.findElement(By.cssSelector(pro.getProperty("instruct.system.selector")));
		wait.until(ExpectedConditions.elementToBeClickable(inst));
		inst.click();
		
		//Verify that we have gone to Instructions
		String expect = "https://www.azaleagas.com/#instruct";
		wait.until(ExpectedConditions.urlToBe(expect));
		String actual = driver.getCurrentUrl();
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
		WebElement quest = driver.findElement(By.cssSelector(pro.getProperty("header.question.selector")));
		wait.until(ExpectedConditions.elementToBeClickable(quest));
		quest.click();
		
		//Click on the Instructions link
		WebElement inst = driver.findElement(By.xpath(pro.getProperty("instruct.questOne.xpath")));
		wait.until(ExpectedConditions.elementToBeClickable(inst));
		inst.click();
		
		//verify that we gone to Instructions
		String expect = "https://www.azaleagas.com/#instruct";
		wait.until(ExpectedConditions.urlToBe(expect));
		String actual = driver.getCurrentUrl();
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
		WebElement quest = driver.findElement(By.cssSelector(pro.getProperty("header.question.selector")));
		wait.until(ExpectedConditions.elementToBeClickable(quest));
		quest.click();
	
		//Scroll to the 2nd Instructions Link
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(pro.getProperty("instruct.questTwo.xpath")));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		
		//Click on the Instructions link
		WebElement inst = driver.findElement(By.xpath(pro.getProperty("instruct.questTwo.xpath")));
		wait.until(ExpectedConditions.elementToBeClickable(inst));
		inst.click();
		
		//Verify that we have gone to Instructions
		String expect = "https://www.azaleagas.com/#instruct";
		wait.until(ExpectedConditions.urlToBe(expect));
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expect);
	}
	
	/*	Navigate back to the HomePage after each test
	 * 
	 * 	@returns	{void}
	 */
	@AfterMethod
    public void returnToHome()	{
		WebElement home = driver.findElement(By.xpath(pro.getProperty("footer.welcome.xpath")));
		wait.until(ExpectedConditions.elementToBeClickable(home));
		home.click();
    	
		String expect = "https://www.azaleagas.com/#home";
		wait.until(ExpectedConditions.urlToBe(expect));
		String actual = driver.getCurrentUrl();
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
