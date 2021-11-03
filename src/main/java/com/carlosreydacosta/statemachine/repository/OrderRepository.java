package com.carlosreydacosta.statemachine.repository;

import com.carlosreydacosta.statemachine.repository.entity.OrderEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface OrderRepository extends ReactiveMongoRepository<OrderEntity, BigDecimal> {
}
