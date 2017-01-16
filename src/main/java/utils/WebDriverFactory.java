package utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.google.common.base.Function;

import pages.HomePage;

public class WebDriverFactory {
	
	private static WebDriver driver = null;
	private static final String URL = "https://www.hotels.com/";
	public static final String USERNAME = "technosoft";
	public static final String ACCESS_KEY = "269969d4-632a-4e8f-a1e4-c924430aa4fe";
    public static final String SLURL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
    private final static String CHECK_OS = System.getProperty("os.name");
    private static String CURRENT_OS = null;

	public static WebDriver getDriver() {
		return driver;
	}
	
   
    private String getOperatingSystem(){
    	if((CHECK_OS.toLowerCase().indexOf("win") >= 0)){
    		return CURRENT_OS = "windows";
    	}else if(CHECK_OS.toLowerCase().indexOf("mac") >= 0){
    		return CURRENT_OS = "mac";
    	}else{
    		return "OS IS NOT SUPPORTED";
    	}
    }
    
    private void chooseBrowser(String browserName){
    	getOperatingSystem();
    	switch(browserName){
    		case "firefox":
    			if(CURRENT_OS.equalsIgnoreCase("mac")){
    				System.setProperty("webdriver.gecko.driver", "Resources/WebDrivers/geckodriver");
					driver = new FirefoxDriver();
    			}else if(CURRENT_OS.equalsIgnoreCase("windows")){
    				System.setProperty("webdriver.gecko.driver", "Resources/WebDrivers/geckodriver.exe");
    				driver = new FirefoxDriver();
    			}break;
    		case "chrome":
    			if(CURRENT_OS.equalsIgnoreCase("mac")){
    				System.setProperty("webdriver.chrome.driver", "Resources/WebDrivers/chromedriver");
					driver = new ChromeDriver();
    			}else if(CURRENT_OS.equalsIgnoreCase("windows")){
    				System.setProperty("webdriver.chrome.driver", "Resources/WebDrivers/chromedriver.exe");
    				driver = new ChromeDriver();
    			}break;
    		case "IE":
    				System.setProperty("webdriver.edge.driver", "Resources/WebDrivers/MicrosoftWebDriver.exe");
    				driver = new EdgeDriver();
    				break;
    		case "saucelabs":
    			try {
					DesiredCapabilities caps = DesiredCapabilities.chrome();
					    caps.setCapability("platform", "Windows 10");
					    caps.setCapability("version", "43.0");
					    driver = new RemoteWebDriver(new URL(SLURL), caps);
				} catch (MalformedURLException e) {
					e.printStackTrace();
					}
    			break;
    			}
    	}	
    
    public static void WaitImplicit(int milliseconds){
		driver.manage().timeouts().implicitlyWait(milliseconds, TimeUnit.MILLISECONDS);
	}
	
	public static void WaitUntilVisible(By locater){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(locater));
	}
	
	public static WebElement webDriverFluentWait(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
				.withTimeout(15, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementNotVisibleException.class)
				.withMessage(
						"Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");
				
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
		return element;
	}
	

	@BeforeTest(alwaysRun = true)
	@Parameters("browserName")
	public void setBrowser(String browserName){
		chooseBrowser(browserName);
		driver.navigate().to(URL);
		driver.manage().window().maximize();
		}
	
	@AfterTest(alwaysRun = true)
	public void tearDown() {
		if (driver != null);
		driver.manage().deleteAllCookies();
		driver.quit();
	}
		
	@AfterMethod
		public void NavigateToHomePage(){
		driver.manage().deleteAllCookies();
		driver.navigate().to(URL);
	}

}
