package com.carlosreydacosta.statemachine.config;

import com.carlosreydacosta.statemachine.handler.OrderHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@RequiredArgsConstructor
public class OrderHandlerConfig {

    private final OrderHandler orderHandler;

    @Bean
    public RouterFunction<ServerResponse> nodeGET(final OrderHandler orderHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/order/tracking"), orderHandler::processOrder);

    }
}
