package ThinkBridge.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ThinkBridge.Assignment.BaseTest;
import ThinkBridge.Extensions.WaitExtensions;
import ThinkBridge.testDataTypes.*;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@id='language']/div/span/i")
	private WebElement languageDropDown;
	@FindBy(xpath="//input[@id='name']")
    private WebElement fullName;
    @FindBy(xpath="//input[@id='orgName']")
    private WebElement organizationName;
    @FindBy(xpath="//input[@id='singUpEmail']")
    private WebElement emailID;
    @FindBy(xpath="//input[@type='checkbox']/../span")
    private WebElement chkbxTC;
    @FindBy(xpath="//button[@type='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-custom']")
    private WebElement emailSendConfirmation;
    private List<WebElement> languageDropDownValues; 

    public String getDropDownValues() throws InterruptedException
    {
    	String languageAvailable = "";
    	try
    	{
    		languageDropDown.click();
    	}
    	catch (Exception ex)
    	{
    		
    	}
    	WaitExtensions.ExplicitWaitForElementVisible(BaseTest.driver, 10, By.xpath("//ul[@class='ui-select-choices ui-select-choices-content ui-select-dropdown dropdown-menu ng-scope']/li//a[@class='ui-select-choices-row-inner']/div"));
    	languageDropDownValues = BaseTest.driver.findElements(By.xpath("//ul[@class='ui-select-choices ui-select-choices-content ui-select-dropdown dropdown-menu ng-scope']/li//a[@class='ui-select-choices-row-inner']/div"));
    	for(WebElement elm : languageDropDownValues)
    	{
    		languageAvailable=languageAvailable+elm.getText();
    	}
    	for(WebElement elm : languageDropDownValues)
    	{
    		elm.click();
    		break;
    	}
    	return languageAvailable;
    }

    public void provideFullName(String name)
    {
        fullName.sendKeys(name);
    }
    
    public void provideOrganizationName(String orgName)
    {
       organizationName.sendKeys(orgName);
    }
    public void provideEmailAddress(String emailAddress)
    {
       emailID.sendKeys(emailAddress);
    }

    public void clickSubmitButton()
    {
       submitButton.click();
    }
    
    public void clickLanguageDropDown()
    {
    	languageDropDown.click();
    }
    
    public void navigate_To_loginPage(String url)
    {
    	driver.get(url);
    }

    public void checkTCCheckbox()
    {
    	WaitExtensions.IgnoreExceptionElementNotInteractable(driver, 100);
    	chkbxTC.click();
    }
    
    public void enter_signupdetails_and_submit(LoginDetails logindetail)
    {
    	provideFullName(logindetail.FullName);
        provideOrganizationName(logindetail.OrganizationName);
        provideEmailAddress(logindetail.EmailID);
        checkTCCheckbox();
        clickSubmitButton();
    }
    
    public boolean checkEmailConfirmationMessage()
    {
    	try
    	{
    		WaitExtensions.ExplicitWaitForElementPresence(driver, 0, emailSendConfirmation);
    	}
    	catch(Exception ex)
    	{
    		
    	}
    	return(emailSendConfirmation.isDisplayed());
    }

}

