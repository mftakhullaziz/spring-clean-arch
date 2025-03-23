package com.app.javacleanarchitect.core.entities.payment;

import com.app.javacleanarchitect.app.annotation.EntitiesBusiness;
import com.app.javacleanarchitect.infra.midtrans.MidtransGateway;

@EntitiesBusiness
public class PaymentEntitiesImpl implements PaymentEntities {

    private final MidtransGateway midtransGateway;

    public PaymentEntitiesImpl(MidtransGateway midtransGateway) {
        this.midtransGateway = midtransGateway;
    }

    @Override
    public void createPayment(String customerId, Integer amount) {
        midtransGateway.createPayment();
    }
}
