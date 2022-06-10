package ThinkBridge.Assignment;

import org.openqa.selenium.WebDriver;

public abstract class BasePage extends BaseTest
{
	
    public static WebDriver driver;
   
    public BasePage()
	{
    	BasePage.driver=BaseTest.driver;
	}
    
}
    
