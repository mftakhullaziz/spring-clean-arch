package com.app.javacleanarchitect.infra.mysql.gateway;

public interface PromoJpaGateway {
    boolean checkPromoIsExist(String promoCode);
    void applyPromo(String promoCode);
}
