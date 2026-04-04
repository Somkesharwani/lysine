package com.lysine.reimbursement.service;

import com.lysine.reimbursement.model.Reimbursement;
import com.lysine.reimbursement.repository.ReimbursementRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReimbursementService {

  @Autowired private ReimbursementRepository reimbursementRepository;

  public Reimbursement saveReimbursement(Reimbursement reimbursement) {
    return reimbursementRepository.save(reimbursement);
  }
}
