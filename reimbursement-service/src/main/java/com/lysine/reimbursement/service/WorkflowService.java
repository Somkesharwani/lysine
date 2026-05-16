package com.lysine.reimbursement.service;

import com.lysine.reimbursement.model.ApprovalStep;
import com.lysine.reimbursement.model.ApprovalWorkflow;
import com.lysine.reimbursement.model.ReimbursementType;
import com.lysine.reimbursement.repository.ApprovalStepRepository;
import com.lysine.reimbursement.repository.ApprovalWorkflowRepository;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class WorkflowService {

  private final ApprovalWorkflowRepository workflowRepo;
  private final ApprovalStepRepository stepRepo;

  public ApprovalWorkflow resolveWorkflow(
      String companyId, ReimbursementType type, BigDecimal amount) {

    return workflowRepo
        .findFirstByOrgIdAndReimbursementTypeAndIsActiveTrueAndMinAmountLessThanEqualAndMaxAmountGreaterThanEqual(
            companyId, type, amount, amount)
        .orElseThrow(() -> new RuntimeException("No workflow found"));
  }

  public List<ApprovalWorkflow> resolveWorkflow(String companyId, ReimbursementType type) {

    return workflowRepo.findFirstByOrgIdAndReimbursementTypeAndIsActiveTrue(companyId, type);
  }

  public List<ApprovalStep> getSteps(String workflowId) {
    return stepRepo.findByWorkflowIdOrderByStepOrderAsc(workflowId);
  }

  public ApprovalWorkflow createWorkflow(ApprovalWorkflow workflow) {
    return workflowRepo.save(workflow);
  }
}
