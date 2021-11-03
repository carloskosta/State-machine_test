package com.carlosreydacosta.statemachine.handler.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OrderResultDto {
    private BigDecimal orderId;
    private Boolean isCorrect;

}
