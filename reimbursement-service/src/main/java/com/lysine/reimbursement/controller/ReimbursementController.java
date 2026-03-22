package com.lysine.reimbursement.controller;

import com.lysine.api.ReimbursementsApi;
import com.lysine.model.ReimbursementResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class ReimbursementController implements ReimbursementsApi {

    @Override
    public ResponseEntity<ReimbursementResponse> getReimbursements() {
        ReimbursementResponse result = new ReimbursementResponse();
        result.setId("123");
        result.setAmount(BigDecimal.valueOf(100.0));
        result.setStatus("SUCCESS");
        return ResponseEntity.ok(result);
    }
}
