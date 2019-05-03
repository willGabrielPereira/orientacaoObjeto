/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package referenciaBanco;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author willg
 * 
 * ######## DESABILITAR QUALQUER TIPO DE ANTIVÍRUS CASO O PROGRAMA NÃO ENVIE ###########
 */
public class Email {
    
    private String assunto;
    private String texto;
    private String destinatario;
    
    private Properties props;
    private Session session;
    
    public Email(String assunto, String texto, String destinatario){
        this.assunto = assunto;
        this.texto = texto;
        this.destinatario = destinatario;
        
        setProps();
        setSession(false);
    }
    
    public void setProps(){
        props = new Properties();
        props.put(
                "mail.smtp.host", "smtp.gmail.com");
        props.put(
                "mail.smtp.socketFactory.port", "465");
        props.put(
                "mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put(
                "mail.smtp.auth", "true");
        props.put(
                "mail.smtp.port", "465");
    }
    
    public void setSession(boolean debug){
        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("pearproduc@gmail.com", "mailliw123");
            }
        });
        
        // FAZ O DEBUG DO ENVIO
        session.setDebug(debug);
    }
    
    public void enviaEmail(){
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("pearproduc@gmail.com")); //Remetente

            Address[] toUser = InternetAddress //Destinatário(s)
                    .parse(destinatario);

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(assunto);//Assunto
            message.setText(texto);
            /**
             * Método para enviar a mensagem criada
             */
            Transport.send(message);


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
}
