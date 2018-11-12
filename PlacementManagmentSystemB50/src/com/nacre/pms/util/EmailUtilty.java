/**
 * 
 */
package com.nacre.pms.util;

import java.io.IOException;

import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

/**
 * @author Chandu
 * @version 10.0. 2018
 * @author Nacre Java B50 This class is used to sending mail and Receiving Mail
 */

public class EmailUtilty {
	private static Properties mailServerProperties;
	private static Session getMailSession;
	private static MimeMessage generateMailMessage;
	private static String fromEmail = null;
	private static String password = null;
	static {
		InputStream inStream = EmailUtilty.class.getClassLoader().getResourceAsStream("gmail.properties");
		mailServerProperties = new Properties();
		try {
			mailServerProperties.load(inStream);
fromEmail=mailServerProperties.getProperty("emailID");


	password=	mailServerProperties.getProperty("password");
		
		getMailSession= Session.getDefaultInstance(mailServerProperties,new javax.mail.Authenticator()
		{
		protected PasswordAuthentication getPasswordAuthentication() 
		{
		return new PasswordAuthentication(fromEmail,password);
		}
		});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static boolean sendEmail(String toAddress, String subject, String messageContent) {
		Properties props = new Properties();
/*
props.put("mail.smtp.host", "smtp.gmail.com"); //below mentioned
		 // mail.smtp.port is optional
		  props.put("mail.smtp.port", "587");
		  props.put("mail.smtp.auth", "true"); props.put("mail.smtp.starttls.enable", "true");
		 
	props.put("mail.smtp.host", "smtp.gmail.com");
		//below mentioned mail.smtp.port is optional
		props.put("mail.smtp.port", "587");		
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
*/	/*	Properties p=System.getProperties();
		
	    p.put("mail.smtp.port",587 );
	    
	
	p.put("mail.smtp.host", "smtp.gmail.com");
	//change accordingly  
	p.put("mail.smtp.auth", "true");  
	 p.put("mail.smtp.starttls.enable", "true");
	    p.put("mail.smtp.ssl.trust","smtp.gmail.com");

*/
	
		 

		try {

			MimeMessage message = new MimeMessage(getMailSession);
			message.setFrom(new InternetAddress(fromEmail));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));

			MimeBodyPart messageBodyPart = new MimeBodyPart();
			// String content="CHECK CONTENT";
			// Fill the message

			messageBodyPart.setText(messageContent, "UTF-8", "text/html");
			message.setSubject(subject);
			message.setText(messageContent);

			/* Transport class is used to deliver the message to the recipients */
			Transport.send(message);

			System.out.println("SENT SUCCESS");
			return true;
		} catch (Exception e) {

			System.err.println("EMAIL NOT SEND");
			e.printStackTrace();
			return false;
		}
	}

}
