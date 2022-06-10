package ThinkBridge.Assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
	
	protected static WebDriverWait Wait;
    public static WebDriver driver;
    public static boolean classInitCalled = false;
   
    public BaseTest()
	{
    	BrowserFactory.GetBrowser();
	}
    
    public static void Close()
	{
    	driver.close();
		driver.quit();
	}

}
