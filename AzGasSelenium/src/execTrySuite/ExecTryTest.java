package execTrySuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


public class ExecTryTest {

	public String baseUrl = "https://www.azaleagas.com/";
	public String driverPath = "C://Users/dcurt/Downloads/geckodriver.exe";
	public WebDriver driver;
	public Properties pro;
	public JavascriptExecutor js;
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
        js = (JavascriptExecutor) driver;
	}
	
	/*	Verify that we are starting at the homepage before each test
	 * 
	 * 	@returns {void}
	 */
	@BeforeMethod
	public void verifyHomePage()	{
		String expectedTitle = "Azalea Gas: Home";
	    String actualTitle = driver.getTitle();
	    Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	//////////
	@Test
	public void something()	{
		
		wait = new WebDriverWait(driver, 3); //here, wait time is 3seconds
		WebElement sys = driver.findElement(By.cssSelector(pro.getProperty("header.system.selector")));
		wait.until(ExpectedConditions.visibilityOf(sys)); //this will wait for elememt to be visible for 3 seconds
		sys.click(); //now it clicks on element		
		
		String actual = driver.getCurrentUrl();
		String expect = "https://www.azaleagas.com/#systems";
		Assert.assertEquals(actual, expect);
	}
	//////////
	
	/*	Returns to the home page after every test
	 * 
	 * 	@returns {void}
	 */
	@AfterMethod
    public void returnToHome()	{
		WebElement home = driver.findElement(By.cssSelector(pro.getProperty("header.welcome.selector")));
    	js.executeScript("arguments[0].click()", home);
    	String actual = driver.getCurrentUrl();
		String expect = "https://www.azaleagas.com/#home";
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
