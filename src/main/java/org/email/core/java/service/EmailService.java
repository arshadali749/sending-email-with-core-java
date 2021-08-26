package org.email.core.java.service;

import org.email.core.java.dto.EmailMessageRequest;

public interface EmailService {
    //use this method to send the email without any attachment.
    public void sendEmail(EmailMessageRequest emailMessageRequest);
    public void sendEmailWIthAttachment(EmailMessageRequest emailMessageRequest);

}
