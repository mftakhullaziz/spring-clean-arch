package com.app.javacleanarchitect.core.usecase.order;

import com.app.javacleanarchitect.domain.order.OrderResponse;

public interface OOrderBoundary {
    void presenter(OrderResponse orderResponse);
}
