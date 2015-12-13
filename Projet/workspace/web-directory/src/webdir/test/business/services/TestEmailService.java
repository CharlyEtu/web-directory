package webdir.test.business.services;

import javax.mail.MessagingException;

import org.junit.Test;

import webdir.main.business.services.imp.EmailService;

public class TestEmailService {
	
	EmailService emailService = new EmailService();

	@Test
	public void testSendEmail() throws MessagingException {
		
		String recipient = "mdjassiri.amirdine@yahoo.fr";
		String subject   = "Récupération de mot de passe";
		String content   = "Bonjour, \n Votre mot de passe est ******* . \n\n "
				         + "L'Équipe Secu Webdirectory. \n";
		
		emailService.sendEmail(recipient, subject, content);	
	}

}
