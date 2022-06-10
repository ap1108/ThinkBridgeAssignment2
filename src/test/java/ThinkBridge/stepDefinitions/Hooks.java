package ThinkBridge.stepDefinitions;

import ThinkBridge.Cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import ThinkBridge.Assignment.*;

public class Hooks {

	TestContext testContext;

	public Hooks(TestContext context) 
	{
		testContext = context;
	}

	@Before
	public void BeforeSteps() 
	{
	
	}

	@After
	public void AfterSteps() 
	{
		BaseTest.Close();
	}

}
