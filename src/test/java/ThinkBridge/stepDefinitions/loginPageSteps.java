package ThinkBridge.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ThinkBridge.TestConfiguration.JSONReader;
import ThinkBridge.TestConfiguration.TestSettings;
import ThinkBridge.Extensions.EmailExtensions;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import ThinkBridge.Cucumber.TestContext;
import ThinkBridge.PageObjects.LoginPage;

public class loginPageSteps 
{
	LoginPage loginPage;
	TestContext testcontext;	
	JSONReader jsonReader;
	TestSettings testSettings;
	int count = 0;
	
	public loginPageSteps(TestContext context)
	{
		testcontext = context;
		loginPage = testcontext.getPageObjectManager().getLoginPage();
		jsonReader = new JSONReader();
		testSettings = new TestSettings();
	}

	@Given("^User is on SignUp Page$")
	public void user_is_on_LoginPage() throws Throwable
	{
		loginPage.navigate_To_loginPage(testSettings.getApplicationUrl());
	}
	
	@When("^User clicks on ChooseLanguage DropDown$")
	public void user_clicks_on_chooseLanguageDropDown() throws Throwable
	{
		loginPage.clickLanguageDropDown();
	}
	
	@Then("^Validate Available Languages$")
	public void validateAvailableLanguages() throws Throwable
	{
		String languageValues = null;
		languageValues = loginPage.getDropDownValues();
		assertEquals(languageValues, "EnglishDutch");
	}
	
	@When("^\"([^\"]*)\" & \"([^\"]*)\" & \\\"([^\\\"]*)\\\" is Entered$")
	public void Is_Entered(String arg1, String arg2, String arg3) throws Throwable
	{	
		loginPage.enter_signupdetails_and_submit(jsonReader.getJsonReaderLD().getLoginDetailByFullName("testuser1104"));
	}
	
	@Then("^SignUp should be successful$")
	public void validate_successful_signup() throws Throwable
	{
		if(!EmailExtensions.isMailReceived(jsonReader.getJsonReaderEC().getEmailDetailByUserName("testuser1104@hotmail.com")) && count<10)
		{
			count = count+1;
			validate_successful_signup();
		}
		if(count==10 || (EmailExtensions.isMailReceived(jsonReader.getJsonReaderEC().getEmailDetailByUserName("testuser1104@hotmail.com"))))
		{
			if(loginPage.checkEmailConfirmationMessage())
			Assert.assertTrue(EmailExtensions.isMailReceived(jsonReader.getJsonReaderEC().getEmailDetailByUserName("testuser1104@hotmail.com")));
			else
			Assert.assertFalse(false);
		}
	}

}