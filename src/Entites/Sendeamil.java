package Entites;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Sendeamil {
     //public static void main(String[] args){
   public static void Send(String recepient) throws Exception
    {
        System.out.println("preparing to send email");
        Properties properties =new Properties();
        
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
         String myAccountEmail= "firas.rejeb@esprit.tn";
         String password = "183JMT2524";
         
           Session session = Session.getInstance(properties, new Authenticator() {
         
         @Override
                   protected PasswordAuthentication getPasswordAuthentication() {
                       return new PasswordAuthentication(myAccountEmail, password);
                   }
           });
           Message message = prepareMessage(session,myAccountEmail,recepient );
           Transport.send(message);
         System.out.println("messsage send successfully");   
    }
           private static Message prepareMessage(Session session, String myAccountEmail, String recepient){
       try {
           Message message = new MimeMessage(session);
           message.setFrom(new InternetAddress(myAccountEmail));
           message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
           message.setSubject("admin <3");
           message.setText("categorie ajouter");
           
           MimeBodyPart messageBodyPart = new MimeBodyPart();
           Multipart multipart  =new MimeMultipart();
           String file = "C:\\Users\\HP\\Desktop";
           String fileName = "liste des categories";
           messageBodyPart = new MimeBodyPart();
           DataSource source = new FileDataSource(file);
           messageBodyPart.setDataHandler(new DataHandler(source));
           messageBodyPart.setFileName(fileName);
           multipart.addBodyPart(messageBodyPart);
           message.setContent(multipart);
           
           return message ;
       } catch ( Exception ex) {
           Logger.getLogger(Sendeamil.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
           
           }
           
}
        
        