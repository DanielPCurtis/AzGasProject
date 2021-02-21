/*
 * @author Daniel Curtis
 * 
 * Test the footer links
 * -Should be able to view/click the links on any page of the site
 * 
 */

package footerSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class FooterTest {
	public String baseUrl = "https://www.azaleagas.com";
	public String driverPath = "C://Users/dcurt/Downloads/geckodriver.exe";
	public WebDriver driver;
	public Properties pro;
	public WebDriverWait wait; 
	
	@BeforeTest
	public void setBaseUrl() throws IOException {
		
		
		File f1 = new File("C:\\Users\\dcurt\\eclipse-workspace\\AzGasSelenium\\AzGasSelenium.properties");
		FileInputStream fis = new FileInputStream(f1);
		pro = new Properties();
		pro.load(fis);
		
		System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.get(baseUrl);
	}
	@BeforeMethod
	public void verifyHomepage()	{
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		String expectedTitle = "Azalea Gas: Home";
	    String actualTitle = driver.getTitle();
	    Assert.assertEquals(actualTitle, expectedTitle);
	    driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
	}
	
	/* 	Scroll down to the phone number element
	 * 	verify that the correct number is displayed 
	 * 
	 * 	@returns {void}
	 */
	@Test(priority = 0)
	public void footerPhoneTest() {
		//Scroll to the footer links
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.END).perform();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		
		//verify the correct phone number is displayed for the business
		String actual = driver.findElement(By.xpath(pro.getProperty("footer.phone.xpath"))).getText();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		String expected = "(910) 350-1111";
		Assert.assertEquals(actual, expected);
	}
	
	/*	Scroll down to the address element in the footer
	 * 	verify that the correct address is displayed
	 * 
	 * 	@returns {void}
	 */
	@Test(priority = 1)
	public void footerMapTest()	{
		//Scroll to the footer links
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.END).perform();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		
		//verify that the address is displayed correctly in the footer
		String actual1 = driver.findElement(By.xpath(pro.getProperty("footer.addressOne.xpath"))).getText();
		String actual2 = driver.findElement(By.xpath(pro.getProperty("footer.addressTwo.xpath"))).getText();
		String expected1 = "2417 Wrightsville Ave,";
		String expected2 = "Wilmington, NC 28403";
		Assert.assertEquals(actual1, expected1);
		Assert.assertEquals(actual2, expected2);
	}
	
	/*	Scroll down to the footer
	 * 	verify the license element has the correct text displayed 
	 * 
	 * 	@returns {void}
	 */
	@Test(priority = 2)
	public void licenseTest()	{
		//Scroll to the footer links
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.END).perform();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		
		//verify the text matches what should be displayed
		String actual = driver.findElement(By.xpath(pro.getProperty("footer.license.xpath"))).getText();
		String expected = "Licensed and Insured";
		Assert.assertEquals(actual, expected);
	}
	
	/*	Scroll down to the footer, click Tank Systems link
	 * 	verify we are where we thought we were
	 * 
	 * 	@returns {void}
	 */
	@Test(priority = 3)
	public void clickSystems() {
		//Scroll to the footer links
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.END).perform();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		
		//click the Tank Systems link
		driver.findElement(By.xpath(pro.getProperty("footer.system.xpath"))).click();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		
		//verify we are at the Tank Systems page
		String actual = driver.getCurrentUrl();
		String expect = "https://www.azaleagas.com/#systems";
		Assert.assertEquals(actual, expect);
	}
	
	/*	Scroll down to the footer, click the Fireplace Sets link
	 * 	verify we are where we thought we were
	 * 
	 * 	@returns {void}
	 */
	@Test(priority = 4)
	public void clickFireplace() {
		//Scroll to the footer links
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.END).perform();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		
		//click the Fireplace Sets link
		driver.findElement(By.xpath(pro.getProperty("footer.fireplace.xpath"))).click();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		
		//verify we are at the Fireplace Sets page
		String actual = driver.getCurrentUrl();
		String expect = "https://www.azaleagas.com/#fireplace";
		Assert.assertEquals(actual, expect);
	}
	
	/*	Scroll down to the footer, click the Instructions link
	 * 	verify that we are where we thought we were
	 * 
	 * 	@returns {void}
	 */
	@Test(priority = 5)
	public void clickInstructions() {
		//Scroll to the footer links
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.END).perform();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		
		//Click the Instructions Link
		driver.findElement(By.xpath(pro.getProperty("footer.instruct.xpath"))).click();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		
		//verify we are at the Instructions page
		String actual = driver.getCurrentUrl();
		String expect = "https://www.azaleagas.com/#instruct";
		Assert.assertEquals(actual, expect);
	}
	
	/*	Scroll down to the footer, click the Q & A link
	 * 	verify we are where we thought we were
	 * 
	 * 	@returns {void}
	 */
	@Test(priority = 6)
	public void clickQuestions() {
		//Scroll to the footer links
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.END).perform();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		
		//Click the Questions and Answers link
		driver.findElement(By.xpath(pro.getProperty("footer.question.xpath"))).click();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		
		//verify we are at the Q & A page
		String actual = driver.getCurrentUrl();
		String expect = "https://www.azaleagas.com/#questions";
		Assert.assertEquals(actual, expect);
	}
	
	/*	Scroll down to the footer, click the directions link
	 * 	verify we are where we thought we were
	 * 
	 * 	@returns {void}
	 
	@Test(priority = 7)
	public void clickDirections()	{
	
		wait = new WebDriverWait(driver, 10);
		String og = driver.getWindowHandle();
		//Check we don't have other windows open already
		assert driver.getWindowHandles().size() == 1;
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		//Scroll to the footer links
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.END).perform();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		
		//click the Directions link
		driver.findElement(By.xpath(pro.getProperty("footer.direction.xpath"))).click();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		
		/*Loop through until we find a new window handle
		for (String windowHandle : driver.getWindowHandles()) {
		    if(!og.contentEquals(windowHandle)) {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sb_cb50\"]")));
		
		//verify that the correct Googlemaps page has loaded
		String actual = driver.getCurrentUrl();
		String expect = "https://www.google.co.in/maps?q=2417+Wrightsville+Ave,+Wilmington,+NC+28403";
		Assert.assertEquals(actual, expect);
		
		driver.navigate().back();
		
		actions = new Actions(driver);
		actions.sendKeys(Keys.END).perform();
		
		//Close the tab or window
		//driver.close();

		//Switch back to the old tab or window
		//driver.switchTo().window(og);
	}
	 */
	
	/*	Scroll down to the address element in the footer and click
	 * 	verify that we are where we thought we were
	 * 
	 * 	@returns {void}
	 */
	@Test(priority = 8)
	public void footerMapClickTest()	{
		wait = new WebDriverWait(driver, 10);
		String og = driver.getWindowHandle();
		//Check we don't have other windows open already
		assert driver.getWindowHandles().size() == 1;
		
		//Scroll to the footer links
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.END).perform();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		
		//Click the first address link     
		driver.findElement(By.xpath(pro.getProperty("footer.addressClick.xpath"))).click();
		//Comment the line below and re-comment the line above if you want to test the bottom span to verify element can be clicked
		//driver.findElement(By.xpath(pro.getProperty("footer.addressOne.xpath"))).click();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;

		//Loop through until we find a new window handle
		for (String windowHandle : driver.getWindowHandles()) {
		    if(!og.contentEquals(windowHandle)) {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sb_cb50\"]")));
		
		//verify we have been taken to the correct googlemaps directions link.
		String expected = "https://www.google.co.in/maps?q=2417+Wrightsville+Ave,+Wilmington,+NC+28403";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
		
		//Close the tab or window
		driver.close();

		//Switch back to the old tab or window
		driver.switchTo().window(og);
	}
	
	/*	Returns to the Home Page after every test
	 * 
	 *	@returns {void} 
	 */
	@AfterMethod
    public void returnToHome()	{
    	driver.findElement(By.xpath(pro.getProperty("footer.welcome.xpath"))).click();
    	String actual = driver.getCurrentUrl();
		String expect = "https://www.azaleagas.com/#home";
		Assert.assertEquals(actual, expect);
    } 
	
	/*	Closing Time, the browser might not have to go home but it can't stay here
	 * 
	 * 	@returns {void}
	 */
    @AfterTest
    public void closeBrowser()	{
      driver.quit();
    }
}
