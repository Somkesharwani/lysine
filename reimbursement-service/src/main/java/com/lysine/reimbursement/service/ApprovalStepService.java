package com.lysine.reimbursement.service;

import com.lysine.reimbursement.model.ApprovalStep;
import com.lysine.reimbursement.repository.ApprovalStepRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApprovalStepService {

  private final ApprovalStepRepository approvalStepRepository;

  public void deleteStepsByWorkflowId(String workflowId) {
    var steps = approvalStepRepository.findByWorkflowIdOrderByStepOrderAsc(workflowId);
    approvalStepRepository.deleteAll(steps);
  }

  public ApprovalStep saveStep(ApprovalStep step) {
    if (!validator(step)) {
      throw new RuntimeException("Invalid step data");
    }
    return approvalStepRepository.save(step);
  }

  public ApprovalStep updateStep(ApprovalStep step) {
    if (!validator(step)) {
      throw new RuntimeException("Invalid step data");
    }
    return approvalStepRepository.save(step);
  }

  public ApprovalStep getStep(String stepId) {
    return approvalStepRepository
        .findById(stepId)
        .orElseThrow(() -> new RuntimeException("Step not found"));
  }

  private boolean validator(ApprovalStep step) {
    if (ObjectUtils.isNotEmpty(step.getStepOrder()) && step.getStepOrder() < 1) {
      return false;
    }
    return step.getApprovalMode() != null;
  }
}
