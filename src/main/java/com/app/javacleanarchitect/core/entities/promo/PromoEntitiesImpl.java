package com.app.javacleanarchitect.core.entities.promo;

import com.app.javacleanarchitect.app.annotation.EntitiesBusiness;
import com.app.javacleanarchitect.infra.mysql.gateway.PromoJpaGateway;

@EntitiesBusiness
public class PromoEntitiesImpl implements PromoEntities {

    private final PromoJpaGateway promoJpaGateway;

    public PromoEntitiesImpl(PromoJpaGateway promoJpaGateway) {
        this.promoJpaGateway = promoJpaGateway;
    }

    @Override
    public void applyPromoByCode(String promoCode) {
        if (promoJpaGateway.checkPromoIsExist(promoCode)) {
            promoJpaGateway.applyPromo(promoCode);
        }
    }
}
