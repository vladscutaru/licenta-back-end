package licenta.service;

import org.springframework.stereotype.Service;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 

@Service
public class SendEmailImp implements SendEmail{


	  public String generateAndSendEmail(String receiver,String message) throws AddressException, MessagingException {
 
		// Step1
		 Properties mailServerProperties;
		 Session getMailSession;
		 MimeMessage generateMailMessage;
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");
 
		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("todireanu_laura@yahoo.com"));
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));

		//generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("test2@crunchify.com"));
		generateMailMessage.setSubject("News from BorrowIT");
		String emailBody = "News from BorrowIT application. You should log in to see.<br>  " + message+"<br><br><br><br>  Regards, <br>BorrowIT Team";
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully..");
 
		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
 
		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", "borrowitapp@gmail.com", "borrower");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
		return "Message sent with SUCCESS !";
	}

}
