package com.wsousa.order.service;

import com.wsousa.dto.OrchestratorResponseDTO;
import com.wsousa.order.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrderEventUpdateService {

    @Autowired
    private PurchaseOrderRepository repository;

    @Transactional
    public void updateOrder(final OrchestratorResponseDTO responseDTO){
        this.repository
                .findById(responseDTO.getOrderId())
                .ifPresent(po -> {
                    po.setStatus(responseDTO.getStatus());
                    this.repository.save(po);
                });
    }

}
