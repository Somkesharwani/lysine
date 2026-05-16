package com.lysine.reimbursement.controller;

import com.lysine.api.ReimbursementApiDelegate;
import com.lysine.model.*;
import com.lysine.reimbursement.mapper.ReimbursementMapper;
import com.lysine.reimbursement.service.ReimbursementService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReimbursementController implements ReimbursementApiDelegate {

  private final ReimbursementMapper reimbursementMapper;
  private final ReimbursementService reimbursementService;

  @Override
  public ResponseEntity<ReimbursementResponseDto> submitReimbursement(
      SubmitReimbursementRequest submitReimbursementRequest) {
    var entity = reimbursementMapper.toEntity(submitReimbursementRequest.getReimbursement());
    reimbursementService.saveReimbursement(entity);
    return ResponseEntity.ok(reimbursementMapper.toDtoWithDocuments(entity));
  }

  @Override
  public ResponseEntity<List<ReimbursementDto>> getReimbursement() {
    return ResponseEntity.ok(
        reimbursementService.getAllReimbursements().stream()
            .map(reimbursementMapper::toDto)
            .collect(java.util.stream.Collectors.toList()));
  }
}
