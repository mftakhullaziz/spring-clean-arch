package com.app.javacleanarchitect.infra.mysql.gateway.impl;

import com.app.javacleanarchitect.app.annotation.Gateway;
import com.app.javacleanarchitect.infra.mysql.gateway.PromoJpaGateway;
import com.app.javacleanarchitect.infra.mysql.repository.PromoRepository;

@Gateway
public class PromoJpaGatewayImpl implements PromoJpaGateway {

    private final PromoRepository promoRepository;

    public PromoJpaGatewayImpl(PromoRepository promoRepository) {
        this.promoRepository = promoRepository;
    }

    @Override
    public boolean checkPromoIsExist(String promoCode) {
        return false;
    }

    @Override
    public void applyPromo(String promoCode) {

    }
}
