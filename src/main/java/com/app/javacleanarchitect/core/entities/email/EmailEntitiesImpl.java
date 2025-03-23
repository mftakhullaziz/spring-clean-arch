package com.app.javacleanarchitect.core.entities.email;

import com.app.javacleanarchitect.app.annotation.EntitiesBusiness;
import com.app.javacleanarchitect.infra.gmail.GoogleMailGateway;

@EntitiesBusiness
public class EmailEntitiesImpl implements EmailEntities {

    private final GoogleMailGateway googleMailGateway;

    public EmailEntitiesImpl(GoogleMailGateway googleMailGateway) {
        this.googleMailGateway = googleMailGateway;
    }

    @Override
    public void sendEmailActivation(String to) {
        // build logic set email
        // build logic set subject
        // build logic to sed message body
        googleMailGateway.sendMailActivateRegister(to);
    }

}
