/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;


import Gui.UserHomeController;
import Services.Impl.UserService;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
   
                  

   public  final String eml ="benjemaa.malek@gmail.com";
     //public static void main(String[] args){
   public  void Send(String recepient) throws Exception
    {
        System.out.println("preparing to send email");
        Properties properties =new Properties();
        
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
         String myAccountEmail= "greenypi100@gmail.com";
         String password = "Greeny123";
         
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
           message.setSubject("Reclamation traité");
           message.setText("Votre reclamation est bine traité");
           return message ;
       } catch ( Exception ex) {
           Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
           
           }
}



