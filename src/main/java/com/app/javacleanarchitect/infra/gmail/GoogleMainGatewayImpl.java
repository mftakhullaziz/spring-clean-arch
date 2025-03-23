package com.app.javacleanarchitect.infra.gmail;

import com.app.javacleanarchitect.app.property.GmailProperty;
import com.app.javacleanarchitect.app.annotation.Gateway;
import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import org.springframework.scheduling.annotation.Async;

import java.util.Properties;

@Gateway
public class GoogleMainGatewayImpl implements GoogleMailGateway {

    private final GmailProperty gmailProperty;

    public GoogleMainGatewayImpl(GmailProperty gmailProperty) {
        this.gmailProperty = gmailProperty;
    }

    @Async
    @Override
    public void sendMailActivateRegister(String email) {

    }

    @Async
    @Override
    public void sendMailNotificationPayment(String email) {

    }

    @Async
    @Override
    public void sendMailNotificationOrder(String email) {

    }

    private Session createSession() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", gmailProperty.getHost()); // Set your SMTP properties here
        properties.put("mail.smtp.port", gmailProperty.getPort());
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                    gmailProperty.getUsername(),
                    gmailProperty.getPassword());
            }};

        return Session.getInstance(properties, authenticator);
    }
}
