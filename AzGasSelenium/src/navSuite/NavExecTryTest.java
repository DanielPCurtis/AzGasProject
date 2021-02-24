/*
 * @author Daniel Curtis
 * 
 * Test the navigation bar.  
 * 	-All links navigate to the correct area of the site.
 *  -Test History, navigates backwards to check 
 *   that the correct pages are visited
 */

package navSuite;

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

public class NavExecTryTest {
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
	
	/*	Click Tank Systems link, verify we are where we thought we were
	 * 
	 * 	@returns {void}
	 */
	@Test(priority = 0)
	public void clickSystems() {
		wait = new WebDriverWait(driver, 3);
		WebElement sys = driver.findElement(By.cssSelector(pro.getProperty("header.system.selector")));
		//Click the Tank Systems link in the nav bar
		wait.until(ExpectedConditions.visibilityOf(sys));
		sys.click();
		
		//Verify that we are at the Tank Systems page
		String expect = "https://www.azaleagas.com/#systems";
		wait.until(ExpectedConditions.urlToBe(expect));
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expect);
	}
	
	/*	Click the Fireplace Sets link,
	 * 	verify we are where we thought we were
	 * 
	 * 	@returns {void}
	 */
	@Test(priority = 1)
	public void clickFireplace() {
		wait = new WebDriverWait(driver, 3);
		//Click the Fireplace Sets link in the navbar
		WebElement fire = driver.findElement(By.cssSelector(pro.getProperty("header.fireplace.selector")));
		wait.until(ExpectedConditions.visibilityOf(fire));
		fire.click();
		
		//Verify that we are at the Fireplace Sets page
		String expect = "https://www.azaleagas.com/#fireplace";
		wait.until(ExpectedConditions.urlToBe(expect));
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expect);
	}
	
	/*	Click the Instructions link,
	 * 	verify we are where we thought we were
	 * 
	 * 	@returns {void}
	 */
	@Test(priority = 2)
	public void clickInstructions() {
		//Click the Instructions link in the navbar
		wait = new WebDriverWait(driver, 3);
		WebElement inst = driver.findElement(By.cssSelector(pro.getProperty("header.instruct.selector")));
		wait.until(ExpectedConditions.visibilityOf(inst));
		inst.click();
		
		//Verify that we are at the Instructions page
		String expect = "https://www.azaleagas.com/#instruct";
		wait.until(ExpectedConditions.urlToBe(expect));
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expect);
	}
	
	/*	Click the Q & A link,
	 * 	verify that we are where we thought we were
	 * 
	 * 	@returns {void}
	 */
	@Test(priority = 3)
	public void clickQuestions() {
		
		//Click the Questions and Answer link in the navbar
		wait = new WebDriverWait(driver, 3);
		WebElement quest = driver.findElement(By.cssSelector(pro.getProperty("header.question.selector")));
		wait.until(ExpectedConditions.visibilityOf(quest));
		quest.click();
		
		//verify that we are at the Questions and Answers page
		String expect = "https://www.azaleagas.com/#questions";
		wait.until(ExpectedConditions.urlToBe(expect));
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expect);
	}

	/*	Verify that backwards navigation is working as intended
	 * 
	 * 	@returns {void}
	 */
	@Test(priority = 4)
	public void backwardNav()	{
		
		//Navigate backwards
		driver.navigate().back();
		
		//Verify
		String expect = "https://www.azaleagas.com/#questions";
		wait.until(ExpectedConditions.urlToBe(expect));
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expect);
		
		//navigate backwards
		driver.navigate().back();
		
		//verify
		expect = "https://www.azaleagas.com/#home";
		wait.until(ExpectedConditions.urlToBe(expect));
		actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expect);
		
		//navigate backwards		
		driver.navigate().back();
		
		//verify
		expect = "https://www.azaleagas.com/#instruct";
		wait.until(ExpectedConditions.urlToBe(expect));
		actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expect);
		
		//navigate backwards
		driver.navigate().back();
		
		//verify
		expect = "https://www.azaleagas.com/#home";
		wait.until(ExpectedConditions.urlToBe(expect));
		actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expect);
		
		//navigate backwards
		driver.navigate().back();
		
		//verify
		expect = "https://www.azaleagas.com/#fireplace";
		wait.until(ExpectedConditions.urlToBe(expect));
		actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expect);
		
		//navigate backwards
		driver.navigate().back();
		
		//verify
		expect = "https://www.azaleagas.com/#home";
		wait.until(ExpectedConditions.urlToBe(expect));
		actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expect);
		
		//navigate backwards
		driver.navigate().back();
		
		//verify
		expect = "https://www.azaleagas.com/#systems";
		wait.until(ExpectedConditions.urlToBe(expect));
		actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expect);
		
		//navigate backwards
		driver.navigate().back();
		
		//verify
		expect = "https://www.azaleagas.com/#home";
		wait.until(ExpectedConditions.urlToBe(expect));
		actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expect);
	}
	
	/*	Verify that the phone element
	 * 	displays the correct phone number
	 * 
	 * 	@returns {void}
	 */
	@Test(priority = 5)
	public void phoneHeaderTest()	{
		wait = new WebDriverWait(driver, 3); //here, wait time is 3seconds
		//Verify correct phone number is displayed
		WebElement phone = driver.findElement(By.xpath(pro.getProperty("header.phone.xpath")));
		wait.until(ExpectedConditions.visibilityOf(phone));
		String actual = phone.getText();
		String expected = "(910) 350-1111";
		Assert.assertEquals(actual, expected);
	}
	
	/*	Click the address element
	 * 	verify we are where we thought we were
	 * 
	 * 	@returns {void}
	 */
	@Test(priority = 6)
	public void addressHeaderTest()	{
		wait = new WebDriverWait(driver, 3); //here, wait time is 3seconds
		//Verify that the GoogleMaps Directions link is labeled correctly
		WebElement addy = driver.findElement(By.xpath(pro.getProperty("header.address.xpath")));
		wait.until(ExpectedConditions.visibilityOf(addy));
		String actual = addy.getText();
		String expect = "2417 Wrightsville Ave, Wilmington, NC 28403";
		Assert.assertEquals(actual, expect);
	}
	
	/*	Click the address link in the header
	 * 	verify we are where we thought we were
	 * 	close the new tab opened
	 * 
	 * 	@returns {void}
	 */
	@Test(priority = 7)
	public void addressClickTest()	{
		
		wait = new WebDriverWait(driver, 10);
		String og = driver.getWindowHandle();
		//Check we don't have other windows open already
		assert driver.getWindowHandles().size() == 1;
		
		//Click the first address link     
		WebElement addy = driver.findElement(By.xpath(pro.getProperty("header.address.xpath")));
		wait.until(ExpectedConditions.visibilityOf(addy));
		addy.click();

		//Loop through until we find a new window handle
		for (String windowHandle : driver.getWindowHandles()) {
		    if(!og.contentEquals(windowHandle)) {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}
		
		//verify we have been taken to the correct googlemaps directions link.
		String expected = "https://www.google.co.in/maps?q=2417+Wrightsville+Ave,+Wilmington,+NC+28403";
		wait.until(ExpectedConditions.urlToBe(expected));
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
		
		//Close the tab or window
		driver.close();

		//Switch back to the old tab or window
		driver.switchTo().window(og);
		
	}
	
	/*	Click the Specials link,
	 * 	verify that we are where we thought we were
	 * 
	 * 	@returns {void}
	 
	@Test(priority = 8)
	public void clickSpecials()	{
		
		//Click the Specials link in the navbar
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		driver.findElement(By.cssSelector(pro.getProperty("header.special.selector"))).click();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		
		//verify that we are at the Questions and Answers page
		String actual = driver.getCurrentUrl();
		String expect = "https://azalea-gas.myshopify.com/collections/all";
		Assert.assertEquals(actual, expect);
		
		//Go to Fireplace page for now cuz i can't figure out a better way.
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath(pro.getProperty("shopify.fireplace.xpath"))).click();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		driver.navigate().back();
		
		//verify
		actual = driver.getCurrentUrl();
		expect = "https://www.azaleagas.com/#fireplace";
		Assert.assertEquals(actual, expect);
	}*/
	
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

