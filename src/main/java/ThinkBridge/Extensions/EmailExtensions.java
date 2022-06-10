package ThinkBridge.Extensions;

import java.util.Properties;
import javax.mail.*;


import ThinkBridge.testDataTypes.EmailCreds;

public class EmailExtensions 
{
	 
	public static boolean isMailReceived(EmailCreds emailCred) throws Exception 
	{
		 boolean emailReceived = false;
		 Folder folder;
         Properties pop3Props = System.getProperties();
         String host = "pop3.live.com";
         String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		         
         pop3Props.setProperty("mail.pop3s.port", "995");
         pop3Props.setProperty("mail.pop3.ssl.enable", "true");
         pop3Props.setProperty("mail.pop3s.socketFactory.class", SSL_FACTORY);
         pop3Props.setProperty("mail.pop3s.socketFactory.fallback", "false");
         pop3Props.setProperty("mail.pop3s.port", "995");
         pop3Props.setProperty("mail.pop3s.socketFactory.port", "995");
			
		 Session session = Session.getDefaultInstance(pop3Props,null);
		 Store store = session.getStore("pop3s");
		 try
		 {
			store.connect(host,995,emailCred.UserName, emailCred.Password);
		
			folder = store.getFolder(emailCred.MailBoxName);
			folder.open(Folder.READ_ONLY);
								    		
			Message[] messages = folder.getMessages();
			for (int i = 0, n = messages.length; i < n; i++) 
			{
		         Message message = messages[i];
		        
		         if(message.getSubject().contains(emailCred.SubjectName))
		         {
		        	 emailReceived = true;
		        	 break;
		         }

		      }
	   	}
		finally
		{
			if (store != null) 
			{
		        store.close();
		    }
		 }
		    return emailReceived;
	 }
}


