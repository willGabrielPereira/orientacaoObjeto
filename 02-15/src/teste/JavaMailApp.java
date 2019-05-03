package teste;

import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailApp {
 
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
 
        /*Session session = Session.getInstance(props, new Authenticator() {
              protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("will.gabriel.pereira@gmail.com", "mailliw123");
              }
        });*/

       Session session = Session.getDefaultInstance(props, new Authenticator() {
           protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
               return new javax.mail.PasswordAuthentication("will.gabriel.pereira@gmail.com", "mailliw123");
          }});

        MimeMessage  message = new MimeMessage (session);
        try {
        message.setFrom(new InternetAddress("will.gabriel.pereira@gmail.com"));
        Address[] toUser = InternetAddress 
                  .parse("will.gabriel.pereira@gmail.com");  
        message.setRecipients(Message.RecipientType.TO, toUser);
        message.setSubject("Assunto");
        message.setText("Texto", "utf-8", "html");
        }catch(MessagingException e) {
        	System.out.println(e);
        }
    
        try {
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
    
    }
 
}