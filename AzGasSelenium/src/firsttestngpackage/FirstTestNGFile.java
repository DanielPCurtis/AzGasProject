package firsttestngpackage;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class FirstTestNGFile {
    public String baseUrl = "https:www.youtube.com/";
    String driverPath = "C://Users/dcurt/Downloads/geckodriver.exe";
    public WebDriver driver;
    public String expected="";
    public String actual="";
    
    @BeforeTest
    public void loadBrowser()	{
    	System.out.println("launching firefox browser"); 
        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.get(baseUrl);
    }
     
    @BeforeMethod
  public void verifyHomepageTitle() {
      String expectedTitle = "YouTube";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle);
  }
    @Test(priority=0)
    public void clickLibrary()	{
    	driver.findElement(By.linkText("Library")).click() ;
    	expected = "https:www.youtube.com/feed/history";
        String actual1 = driver.getCurrentUrl();
        Assert.assertEquals(actual1, expected);
    }
    
    @Test(priority=1)
    public void clickHistory()	{
    	driver.findElement(By.linkText("History")).click() ;
    	String expected2 = "https:www.youtube.com/feed/library";
        String actual2 = driver.getCurrentUrl();
        Assert.assertEquals(actual2, expected2);
    }
    @AfterMethod
    public void gohome()	{
    	driver.findElement(By.id("logo")).click() ;
    }
      
    @AfterTest
    public void closeBrowser()	{
      driver.close();
    }
}
