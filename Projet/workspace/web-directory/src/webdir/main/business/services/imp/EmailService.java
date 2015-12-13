package webdir.main.business.services.imp;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import webdir.main.business.services.IEmailService;

public class EmailService implements IEmailService {
	
	
   /**
	* Permet d'envoyer un e-mail.
	* @param recipient adresse e-mail du destinatire.
	* @param subject sujet de l'e-mail.
	* @param content contenu de l'e-mail (Texte).
	*/
	public void sendEmail(String recipient, String subject, String content) throws MessagingException{
		
		/* Paramètre de configuration Gmail */
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		/* Session et authentification */
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("xxxxxxxx@gmail.com", "*********");
			}
		  });
 
		/* Envoie du mail au destinataire */
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("xxxxxxxx@gmail.com"));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
		message.setSubject(subject);
		message.setText(content);

		Transport.send(message);	
	}
		
}