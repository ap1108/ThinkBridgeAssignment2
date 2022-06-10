package ThinkBridge.Managers;

import ThinkBridge.PageObjects.*;
import ThinkBridge.Assignment.*;

public class PageObjectManager extends BasePage
{

	private LoginPage loginPage;
	
	

/*	public PageObjectManager(WebDriver driver) 
	{
		BasePage.driver = driver;
	}*/


	public LoginPage getLoginPage()
	{
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}
}
