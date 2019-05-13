package licenta.service;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface SendEmail {

	String generateAndSendEmail(String sender,String message) throws AddressException, MessagingException;
}
