package ThinkBridge.DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import ThinkBridge.TestConfiguration.*;
import gherkin.deps.com.google.gson.Gson;
import ThinkBridge.testDataTypes.*;

public class JsonDataReaderEmailCreds {
	TestSettings testSettings = new TestSettings();
	private final String EmailCredsFilePath = testSettings.getTestDataResourcePath()  + "EmailCreds.json";
	private List<EmailCreds> emailCredList;
	
	public JsonDataReaderEmailCreds()
	{
		emailCredList = getEmailData();
	}
	
	private List<EmailCreds> getEmailData() 
	{
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try
		{
			bufferReader = new BufferedReader(new FileReader(EmailCredsFilePath));
			EmailCreds[] emailInfo = gson.fromJson(bufferReader, EmailCreds[].class);
			return Arrays.asList(emailInfo);
		}
		catch(FileNotFoundException e) 
		{
			throw new RuntimeException("Json file not found at path : " + EmailCredsFilePath);
		}
		finally
		{
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	}
		
	public final EmailCreds getEmailDetailByUserName(String UserName)
	{
		 return emailCredList.stream().filter(x -> x.UserName.equalsIgnoreCase(UserName)).findAny().get();
	}

}
