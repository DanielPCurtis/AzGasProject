/*
 * @author Daniel Curtis
 * 
 * Test the navigation bar.  
 * 	-All links navigate to the correct area of the site.
 *  -Test History, navigates backwards to check 
 *   that the correct pages are visited
 */

package navSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class NavBarTest {
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
	@Test(priority = 0)
	public void clickSystems() {
		driver.findElement(By.cssSelector("li.page-links-link:nth-child(2) > a:nth-child(2)")).click();
		String actual = driver.getCurrentUrl();
		String expect = "https://www.azaleagas.com/#systems";
		Assert.assertEquals(actual, expect);
	}
	@Test(priority = 1)
	public void clickFireplace() {
		driver.findElement(By.cssSelector("li.page-links-link:nth-child(3) > a:nth-child(2)")).click();
		String actual = driver.getCurrentUrl();
		String expect = "https://www.azaleagas.com/#fireplace";
		Assert.assertEquals(actual, expect);
	}
	@Test(priority = 2)
	public void clickInstructions() {
		driver.findElement(By.cssSelector("li.page-links-link:nth-child(4) > a:nth-child(2)")).click();
		String actual = driver.getCurrentUrl();
		String expect = "https://www.azaleagas.com/#instruct";
		Assert.assertEquals(actual, expect);
	}
	@Test(priority = 3)
	public void clickQuestions() {
		driver.findElement(By.cssSelector("li.page-links-link:nth-child(5) > a:nth-child(2)")).click();
		String actual = driver.getCurrentUrl();
		String expect = "https://www.azaleagas.com/#questions";
		Assert.assertEquals(actual, expect);
	}
	@Test(priority = 4)
	public void backwardNav()	{
		
		driver.navigate().back();
		String actual = driver.getCurrentUrl();
		String expect = "https://www.azaleagas.com/#questions";
		Assert.assertEquals(actual, expect);
		
		driver.navigate().back();
		
		actual = driver.getCurrentUrl();
		expect = "https://www.azaleagas.com/#home";
		Assert.assertEquals(actual, expect);
		
		driver.navigate().back();
		actual = driver.getCurrentUrl();
		expect = "https://www.azaleagas.com/#instruct";
		Assert.assertEquals(actual, expect);
		
		driver.navigate().back();
		actual = driver.getCurrentUrl();
		expect = "https://www.azaleagas.com/#home";
		Assert.assertEquals(actual, expect);
		
		driver.navigate().back();
		actual = driver.getCurrentUrl();
		expect = "https://www.azaleagas.com/#fireplace";
		Assert.assertEquals(actual, expect);
		
		driver.navigate().back();
		actual = driver.getCurrentUrl();
		expect = "https://www.azaleagas.com/#home";
		Assert.assertEquals(actual, expect);
		
		driver.navigate().back();
		actual = driver.getCurrentUrl();
		expect = "https://www.azaleagas.com/#systems";
		Assert.assertEquals(actual, expect);
		
		driver.navigate().back();
		actual = driver.getCurrentUrl();
		expect = "https://www.azaleagas.com/#home";
		Assert.assertEquals(actual, expect);
	}
	
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
