package ThinkBridge.Assignment;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import ThinkBridge.Extensions.WaitExtensions;
import ThinkBridge.TestConfiguration.TestSettings;
import ThinkBridge.enums.DriverType;

public class BrowserFactory 
{
	
	static TestSettings testSettings;
	private static DriverType driverType;
	//private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    
	public BrowserFactory() 
	{
		
	//	environmentType = testSettings.getEnvironment();
	}
	
    public static void GetBrowser()
    {
    	testSettings = new TestSettings();
		driverType = testSettings.getBrowser();
    	switch(driverType)
    	{
    	case FIREFOX : BaseTest.driver = new FirefoxDriver();
    	break;
    	case CHROME : 
    	System.setProperty(CHROME_DRIVER_PROPERTY, testSettings.getDriverPath());
    	BaseTest.driver = new ChromeDriver();
		break;
    	case INTERNETEXPLORER : BaseTest.driver = new InternetExplorerDriver();
		break;
    	}
    	if(testSettings.isWindowMaximized())
    	{
    		BaseTest.driver.manage().window().maximize();
    	}
    	WaitExtensions.ImplicitWait(BaseTest.driver, testSettings.getImplicitlyWait());
     }
    
}

