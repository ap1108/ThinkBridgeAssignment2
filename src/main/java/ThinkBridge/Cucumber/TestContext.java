package ThinkBridge.Cucumber;

import ThinkBridge.Managers.*;

public class TestContext 
{
	private PageObjectManager pageObjectManager;
	
	public TestContext()
	{
		pageObjectManager = new PageObjectManager();
	}
	
	public PageObjectManager getPageObjectManager() 
	{
		return pageObjectManager;
	}

}
