package org.email.core.java;

import org.email.core.java.dto.EmailMessageRequest;
import org.email.core.java.serviceImpl.EmailServiceImp;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        EmailServiceImp emailSender = new EmailServiceImp();
        EmailMessageRequest emailMessageRequest = new EmailMessageRequest();
        emailMessageRequest.setFrom("aliarshad.memon749@gmail.com");
        emailMessageRequest.setTo("rajamaneshkumar5@gmail.com");
        emailMessageRequest.setMessage("Hi Raja ,how r u ?");
        emailMessageRequest.setSubject("Just Greeting..");
        //   emailSender.sendEmail(emailMessageRequest); //call this method to send only the text message body
        emailSender.sendEmailWIthAttachment(emailMessageRequest); //calling this method will send the email with the attachment.
    }


}
