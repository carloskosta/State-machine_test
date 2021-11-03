package com.carlosreydacosta.statemachine.service;

import com.carlosreydacosta.statemachine.handler.dto.OrderDto;
import com.carlosreydacosta.statemachine.handler.dto.OrderResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OrderServiceFacade implements OrderService {
    private final OrderMongoService orderMongoService;
    private final OrderStateMachineService orderStateMachineService;


    @Override
    public Flux<OrderResultDto> processOrder(final Flux<OrderDto> orderTrackingDtoCollection) {
        return orderTrackingDtoCollection.flatMap(this::processOrder);
    }

    Mono<OrderResultDto> processOrder(final OrderDto orderDto) {
        return orderMongoService.getPreviousState(orderDto.getOrderId())
                .flatMap(previousStatus -> {
                    boolean validModification = orderStateMachineService.isValidModification(previousStatus,
                            orderDto.getTrackingStatusId());
                    if (validModification) {
                        orderMongoService.saveOrder(orderDto);
                    }
                    return Mono.just(OrderResultDto.builder()
                            .orderId(orderDto.getOrderId())
                            .isCorrect(validModification).build());
                });
    }
}
