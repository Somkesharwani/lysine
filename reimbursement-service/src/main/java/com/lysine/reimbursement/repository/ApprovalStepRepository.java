package com.lysine.reimbursement.repository;

import com.lysine.reimbursement.model.ApprovalStep;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface ApprovalStepRepository
    extends JpaRepository<ApprovalStep, String>, RevisionRepository<ApprovalStep, String, Integer> {

  List<ApprovalStep> findByWorkflowIdOrderByStepOrderAsc(String workflowId);
}
