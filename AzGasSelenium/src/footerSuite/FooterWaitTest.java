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

public class FooterWaitTest {
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
	
	///////////////////
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
		
		WebElement phone = driver.findElement(By.xpath(pro.getProperty("footer.phone.xpath")));
		wait.until(ExpectedConditions.visibilityOf(phone));
		//verify the correct phone number is displayed for the business
		String actual = phone.getText();
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
		
		WebElement addOne = driver.findElement(By.xpath(pro.getProperty("footer.addressOne.xpath")));
		WebElement addTwo = driver.findElement(By.xpath(pro.getProperty("footer.addressTwo.xpath")));
		wait.until(ExpectedConditions.visibilityOf(addOne));
		wait.until(ExpectedConditions.visibilityOf(addTwo));
		
		//verify that the address is displayed correctly in the footer
		String actual1 = addOne.getText();
		String actual2 = addTwo.getText();
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
		
		WebElement lic = driver.findElement(By.xpath(pro.getProperty("footer.license.xpath")));
		wait.until(ExpectedConditions.visibilityOf(lic));
		
		//verify the text matches what should be displayed
		String actual = lic.getText();
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
		
		WebElement sys = driver.findElement(By.xpath(pro.getProperty("footer.system.xpath")));
		wait.until(ExpectedConditions.elementToBeClickable(sys));
		sys.click();
	
		//verify we are at the Tank Systems page
		String expect = "https://www.azaleagas.com/#systems";
		wait.until(ExpectedConditions.urlToBe(expect));
		String actual = driver.getCurrentUrl();
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
		WebElement fire = driver.findElement(By.xpath(pro.getProperty("footer.fireplace.xpath")));
		wait.until(ExpectedConditions.elementToBeClickable(fire));
		fire.click();
		
		//verify we are at the Fireplace Sets page
		String expect = "https://www.azaleagas.com/#fireplace";
		wait.until(ExpectedConditions.urlToBe(expect));
		String actual = driver.getCurrentUrl();
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
		
		//Click the Instructions Link
		WebElement inst = driver.findElement(By.xpath(pro.getProperty("footer.instruct.xpath")));
		wait.until(ExpectedConditions.elementToBeClickable(inst));
		inst.click();
		
		//verify we are at the Instructions page
		String expect = "https://www.azaleagas.com/#instruct";
		wait.until(ExpectedConditions.urlToBe(expect));
		String actual = driver.getCurrentUrl();
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
		WebElement quest = driver.findElement(By.xpath(pro.getProperty("footer.question.xpath")));
		wait.until(ExpectedConditions.elementToBeClickable(quest));
		quest.click();
		
		//verify we are at the Q & A page
		String expect = "https://www.azaleagas.com/#questions";
		wait.until(ExpectedConditions.urlToBe(expect));
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expect);
	}
	
	/*	Scroll down to the footer, click the directions link
	 * 	verify we are where we thought we were
	 * 
	 * 	@returns {void}
	 */
	@Test(priority = 7)
	public void clickDirections()	{
		
		//Scroll to the footer links
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.END).perform();
		
		//click the Directions link
		WebElement dir = driver.findElement(By.xpath(pro.getProperty("footer.direction.xpath")));
		wait.until(ExpectedConditions.elementToBeClickable(dir));
		dir.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sb_cb50\"]")));
		
		//verify that the correct Googlemaps page has loaded		
		String expect = "https://www.google.co.in/maps?q=2417+Wrightsville+Ave,+Wilmington,+NC+28403";
		wait.until(ExpectedConditions.urlToBe(expect));
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expect);
		
		driver.navigate().back();
		
		actions = new Actions(driver);
		actions.sendKeys(Keys.HOME).perform();
	}
	 
	
	/*	Scroll down to the address element in the footer and click
	 * 	verify that we are where we thought we were
	 * 
	 * 	@returns {void}
	 */
	@Test(priority = 8)
	public void footerMapClickTest()	{

		String og = driver.getWindowHandle();
		//Check we don't have other windows open already
		assert driver.getWindowHandles().size() == 1;
		
		//Scroll to the footer links
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.END).perform();
		
		//Click the first address link     
		WebElement addyClick = driver.findElement(By.xpath(pro.getProperty("footer.addressClick.xpath")));
		//Comment the line below and re-comment the line above if you want to test the bottom span to verify element can be clicked
		//WebElement addyClick = driver.findElement(By.xpath(pro.getProperty("footer.addressOne.xpath")));
		wait.until(ExpectedConditions.elementToBeClickable(addyClick));
		addyClick.click();

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
	/////////////////////
	
	/*	Returns to the home page after every test
	 * 
	 * 	@returns {void}
	 */
	@AfterMethod
    public void returnToHome()	{
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
