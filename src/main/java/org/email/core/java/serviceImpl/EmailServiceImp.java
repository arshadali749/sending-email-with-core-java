package org.email.core.java.serviceImpl;

import org.email.core.java.dto.EmailMessageRequest;
import org.email.core.java.service.EmailService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

public class EmailServiceImp implements EmailService {
    @Override
    public void sendEmail(EmailMessageRequest emailMessageRequest) {
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        System.out.println("SYSTEM PROPERTIES :" + properties);
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");


        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("aliarshad.memon749@gmail.com", "heuutzadadketxyy");
            }
        });
        session.setDebug(true);
        //Step 2 compose email ;

        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.setFrom(emailMessageRequest.getFrom());
            //adding receipent to whome the message need to send
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailMessageRequest.getTo()));
            //adding subject to message...
            mimeMessage.setSubject(emailMessageRequest.getSubject());
            //setting the message
            mimeMessage.setText(emailMessageRequest.getMessage());
            //sending message using Transport class
            Transport.send(mimeMessage);
            System.out.println("Email send successfully ....");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void sendEmailWIthAttachment(EmailMessageRequest emailMessageRequest) {
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        System.out.println("SYSTEM PROPERTIES :" + properties);
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");


        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("aliarshad.memon749@gmail.com", "heuutzadadketxyy");
                /*
                note:
                 1) here the gamil is the email from which the mail will be sent
                 2 )  second parameter is the app password which can be generated through the email provided here by following the steps below:
                  Log in to your Google account
                  Go to My Account > Sign-in & Security > App Passwords (Sign in again to confirm it's you)
                  Scroll down to Select App (in the Password & sign-in method box)
                  and choose Other (custom name) Give this app password a name,
                  e.g. "nodemailer" Choose Generate Copy the long generated password and
                   paste it into your Node.js script instead of your actual Gmail password.
                */

            }
        });
        session.setDebug(true);
        //Step 2 compose email ;

        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.setFrom(emailMessageRequest.getFrom());
            //adding receipent to whome the message need to send
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailMessageRequest.getTo()));
            //adding subject to message...
            mimeMessage.setSubject(emailMessageRequest.getSubject());
            //setting the message
            mimeMessage.setText(emailMessageRequest.getMessage());
            MimeMultipart mimeMultipart = new MimeMultipart();
            MimeBodyPart tesxMessageBody = new MimeBodyPart();
            MimeBodyPart attachmentBody = new MimeBodyPart();

            try {
                File file = new File("/home/bahl/Pictures/test.png");
                attachmentBody.attachFile(file);
                tesxMessageBody.setText(emailMessageRequest.getMessage());  //setting the text message
                mimeMultipart.addBodyPart(tesxMessageBody);                 //setting text message body
                mimeMultipart.addBodyPart(attachmentBody);                  //setting attachment
                mimeMessage.setContent(mimeMultipart);                      //setting message+attahment
                Transport.send(mimeMessage);                                //sending message
                System.out.println("Email send successfully ....");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
