package com.app.javacleanarchitect.infra.gmail;

public interface GoogleMailGateway {
    void sendMailActivateRegister(String email);
    void sendMailNotificationPayment(String email);
    void sendMailNotificationOrder(String email);
}
