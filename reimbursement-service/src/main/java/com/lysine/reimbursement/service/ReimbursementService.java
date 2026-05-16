package com.lysine.reimbursement.service;

import com.lysine.common.service.ReferenceDataService;
import com.lysine.reimbursement.model.Reimbursement;
import com.lysine.reimbursement.repository.ReimbursementRepository;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReimbursementService {

  private final ReimbursementRepository reimbursementRepository;
  private final ReferenceDataService referenceDataService;

  public Reimbursement saveReimbursement(Reimbursement reimbursement) {
    /* if (!validateReimbursement(reimbursement)) {
      throw new RuntimeException("Invalid reimbursement data");
    }*/
    /* reimbursementRepository.findById(reimbursement.getId()).ifPresent(r -> {
      throw new RuntimeException("Reimbursement with id " + reimbursement.getId() + " already exists");
    });*/

    return reimbursementRepository.save(reimbursement);
  }

  private Boolean validateReimbursement(Reimbursement reimbursement) {
    // Validate reimbursement data
    if (StringUtils.isEmpty(reimbursement.getCompanyId())) {
      return false;
    }
    if (reimbursement.getReimbursementType() == null) {
      return false;
    }
    if (StringUtils.isEmpty(reimbursement.getDescription())) {
      return false;
    }

    return !StringUtils.isEmpty(reimbursement.getUserId());
  }

  public Collection<Reimbursement> getAllReimbursements() {
    return reimbursementRepository.findAll();
  }
}
