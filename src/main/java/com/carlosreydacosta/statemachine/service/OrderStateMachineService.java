package com.carlosreydacosta.statemachine.service;

import com.carlosreydacosta.statemachine.repository.entity.PreviousStatus;
import org.springframework.stereotype.Service;

@Service
class OrderStateMachineService {
    public boolean isValidModification(final PreviousStatus previousStatus, final int currentStatus) {
        switch (previousStatus) {
            case NONE:
                return currentStatus == 1;
            case RECOGIDA_ALMACEN:
                return currentStatus > 0 && currentStatus < 5;
            case EN_REPARTO:
            case INCIDENCIA_EN_ENTREGA:
                return currentStatus > 1 && currentStatus < 5;
            default:
                return false;
        }
    }
}
