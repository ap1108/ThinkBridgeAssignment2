package ThinkBridge.TestConfiguration;

import ThinkBridge.DataProvider.*;

public class JSONReader 
{
	private static JsonDataReaderLoginDetail jsonDataReader_LD;
	private static JsonDataReaderEmailCreds jsonDataReader_EC;
	
	public JsonDataReaderLoginDetail getJsonReaderLD(){
		 return (jsonDataReader_LD == null) ? new JsonDataReaderLoginDetail() : jsonDataReader_LD;
	}
	
	public JsonDataReaderEmailCreds getJsonReaderEC(){
		 return (jsonDataReader_EC == null) ? new JsonDataReaderEmailCreds() : jsonDataReader_EC;
	}
}
    
