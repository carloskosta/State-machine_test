package com.carlosreydacosta.statemachine.service.mapper;

import com.carlosreydacosta.statemachine.handler.dto.OrderDto;
import com.carlosreydacosta.statemachine.repository.entity.OrderEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderMapper {

    public static OrderEntity asOrderEntity(final OrderDto orderDto) {
        return OrderEntity.builder()
                .orderId(orderDto.getOrderId())
                .trackingStatusId(orderDto.getTrackingStatusId())
                .changeStatusDate(orderDto.getChangeStatusDate().toInstant())
                .savedDate(Instant.now())
                .build();
    }
}
