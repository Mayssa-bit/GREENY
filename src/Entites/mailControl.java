/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import java.util.*;
import java.util.Date;
import java.util.Properties;
import javax.mail.internet.MimeMessage;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author HP
 */
public class mailControl {
     public static void Send(String receiver)
    {
        try{
            String host ="smtp.gmail.com" ;
            String user = "benjemaa.malek@gmail.com"; 
            String pass = "tounsi94"; 
            String to = receiver;
            String from = "benjemaa.malek@gmail.com"; 
            String subject = "Welcome To Greeny";
            String messageText = "compte ajouté";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            MimeMessage msg = new MimeMessage(mailSession) ;
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(MimeMessage.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
        }catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
}


