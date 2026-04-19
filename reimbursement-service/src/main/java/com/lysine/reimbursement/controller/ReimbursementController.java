package com.lysine.reimbursement.controller;

import com.lysine.api.ReimbursementApi;
import com.lysine.model.*;
import com.lysine.reimbursement.mapper.ReimbursementMapper;
import com.lysine.reimbursement.service.ReimbursementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReimbursementController implements ReimbursementApi {

  private ReimbursementMapper reimbursementMapper;
  private ReimbursementService reimbursementService;

  @Override
  public ResponseEntity<ReimbursementDto> submitReimbursement(ReimbursementDto reimbursement) {
    var entity = reimbursementMapper.toEntity(reimbursement);
    return ResponseEntity.ok(
        reimbursementMapper.toDto(reimbursementService.saveReimbursement(entity)));
  }
}
