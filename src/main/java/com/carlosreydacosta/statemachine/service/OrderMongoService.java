package com.carlosreydacosta.statemachine.service;

import com.carlosreydacosta.statemachine.handler.dto.OrderDto;
import com.carlosreydacosta.statemachine.repository.OrderRepository;
import com.carlosreydacosta.statemachine.repository.entity.PreviousStatus;
import com.carlosreydacosta.statemachine.service.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class OrderMongoService {

    private final OrderRepository orderRepository;

    public Mono<PreviousStatus> getPreviousState(final BigDecimal orderId) {
        return orderRepository.findById(orderId)
                .map(orderEntity -> Optional.ofNullable(orderEntity)
                        .map(order -> PreviousStatus.getPreviousId(order.getTrackingStatusId()))
                        .orElse(PreviousStatus.NONE));
    }

    public void saveOrder(final OrderDto orderTrackingDto) {
        orderRepository.save(OrderMapper.asOrderEntity(orderTrackingDto));
    }
}
