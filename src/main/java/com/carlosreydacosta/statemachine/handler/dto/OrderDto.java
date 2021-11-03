package com.carlosreydacosta.statemachine.handler.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class OrderDto {
    private BigDecimal orderId;
    private Integer trackingStatusId;
    private OffsetDateTime changeStatusDate;
}
