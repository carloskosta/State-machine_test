package com.carlosreydacosta.statemachine.service;

import com.carlosreydacosta.statemachine.handler.dto.OrderDto;
import com.carlosreydacosta.statemachine.handler.dto.OrderResultDto;
import reactor.core.publisher.Flux;

public interface OrderService {
    Flux<OrderResultDto> processOrder(final Flux<OrderDto> orderTrackingDtoCollection);
}
