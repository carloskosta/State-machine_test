package com.carlosreydacosta.statemachine.handler;

import com.carlosreydacosta.statemachine.handler.dto.OrderDto;
import com.carlosreydacosta.statemachine.handler.dto.OrderResultDto;
import com.carlosreydacosta.statemachine.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class OrderHandler {

    private final OrderService orderService;

    public Mono<ServerResponse> processOrder(final ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(orderService.processOrder(request.bodyToFlux(OrderDto.class)),
                        OrderResultDto.class));
    }

}
