package ThinkBridge.TestConfiguration;
import ThinkBridge.enums.*;


public class TestSettings extends ConfigReader {
	
	public String getDriverPath(){
		String driverPath = properties.getProperty("driverpath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
	
	public int getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitWait");
		if(implicitlyWait != null) return Integer.parseInt(implicitlyWait);
		else throw new RuntimeException("implicitWait not specified in the Configuration.properties file.");		
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public DriverType getBrowser() {
		String browser = properties.getProperty("browser");
		if(browser == null || browser.equals("chrome")) return DriverType.CHROME;
		else if(browser.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
		else if(browser.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
		else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browser);
	}
	
	public Boolean isMultiBrowserTest() {
		String multiBrowserTest = properties.getProperty("multiBrowserTest");
		if(multiBrowserTest != null) return Boolean.valueOf(multiBrowserTest);
		else throw new RuntimeException("multiBrowserTest setting is not specified in the Configuration.properties file.");
	}
	
	public String getTestType() {
		String testType = properties.getProperty("testType");
		if(testType != null) return testType;
		else throw new RuntimeException("TestType is not specified in the Configuration.properties file.");
	}
	
	public Boolean isLogEnabled() {
		String isLog = properties.getProperty("isLog");
		if(isLog != null) return Boolean.valueOf(isLog);
		else throw new RuntimeException("isLog is not specified in the Configuration.properties file.");
	}
	
	public String getLogPath() {
		String logPath = properties.getProperty("logPath");
		if(logPath != null) return logPath;
		else throw new RuntimeException("LogPath is not specified in the Configuration.properties file.");
	}
	
	public Boolean isWindowMaximized() {
		String windowMaximize = properties.getProperty("windowMaximize");
		if(windowMaximize != null) return Boolean.valueOf(windowMaximize);
		else throw new RuntimeException("windowMaximize is not specified in the Configuration.properties file.");
	}
	
	public EnvironmentType getEnvironment() {
		String environment = properties.getProperty("environment");
		if(environment == null || environment.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
		else if(environment.equals("remote")) return EnvironmentType.REMOTE;
		else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environment);
	}
	
	public String getTestDataResourcePath(){
		String testDataResourcePath = properties.getProperty("testDataResourcePath");
		if(testDataResourcePath!= null) return testDataResourcePath;
		else throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");		
	}
	
}
