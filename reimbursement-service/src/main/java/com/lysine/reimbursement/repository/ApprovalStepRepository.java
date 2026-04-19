package com.lysine.reimbursement.repository;

import com.lysine.reimbursement.model.ApprovalStep;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovalStepRepository extends JpaRepository<ApprovalStep, String> {

  List<ApprovalStep> findByWorkflowIdOrderByStepOrderAsc(String workflowId);
}
