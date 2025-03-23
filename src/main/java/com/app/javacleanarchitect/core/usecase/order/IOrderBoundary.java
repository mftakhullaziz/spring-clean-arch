package com.app.javacleanarchitect.core.usecase.order;

import com.app.javacleanarchitect.domain.order.OrderRequest;

public interface IOrderBoundary {
    void executeOrder(OrderRequest orderRequest, OOrderBoundary oOrderBoundary);
}
