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

public class JsonDataReaderLoginDetail {
	TestSettings testSettings = new TestSettings();
	private final String LoginDetailsFilePath = testSettings.getTestDataResourcePath()  + "LoginDetails.json";
	private List<LoginDetails> loginDetailList;
	
	public JsonDataReaderLoginDetail()
	{
		loginDetailList = getLoginData();
	}
	
	private List<LoginDetails> getLoginData() 
	{
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try
		{
			bufferReader = new BufferedReader(new FileReader(LoginDetailsFilePath));
			LoginDetails[] loginInfo = gson.fromJson(bufferReader, LoginDetails[].class);
			return Arrays.asList(loginInfo);
		}
		catch(FileNotFoundException e) 
		{
			throw new RuntimeException("Json file not found at path : " + LoginDetailsFilePath);
		}
		finally
		{
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	}
		
	public final LoginDetails getLoginDetailByFullName(String FullNameValue)
	{
		 return loginDetailList.stream().filter(x -> x.FullName.equalsIgnoreCase(FullNameValue)).findAny().get();
	}

}
