/*
 * @author Daniel Curtis
 * 
 * Test the footer links
 * -Should be able to view/click the links on any page of the site
 * 
 */

package footerSuite;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class FooterTest {
	public String baseUrl = "https://www.azaleagas.com";
	public String driverPath = "C://Users/dcurt/Downloads/geckodriver.exe";
	public WebDriver driver;
	
	@BeforeTest
	public void setBaseUrl() {
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
	
	@Test
	public void footerPhoneTest() {
		//Scroll to the footer links
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.END).perform();
		
		String actual = driver.findElement(By.xpath("//*[@id=\"content\"]/div[9]/div[3]/ul/li[1]/a")).getText();
		String expected = "(910) 350-1111";
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void footerMapTest()	{
		//Scroll to the footer links
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.END).perform();
		
		String actual1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[9]/div[3]/ul/li[2]/a/span[2]")).getText();
		String actual2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[9]/div[3]/ul/li[2]/a/span[3]")).getText();
		String expected1 = "2417 Wrightsville Ave,";
		String expected2 = "Wilmington, NC 28403";
		Assert.assertEquals(actual1, expected1);
		Assert.assertEquals(actual2, expected2);
	}
	/////////////
	/////////////
	
	@AfterMethod
    public void returnToHome()	{
    	driver.findElement(By.cssSelector("li.page-links-link:nth-child(1) > a:nth-child(2)")).click();
    	String actual = driver.getCurrentUrl();
		String expect = "https://www.azaleagas.com/#home";
		Assert.assertEquals(actual, expect);
    } 
    @AfterTest
    public void closeBrowser()	{
      driver.close();
    }
}
