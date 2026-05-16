package com.lysine.reimbursement.repository;

import com.lysine.reimbursement.model.ApprovalWorkflow;
import com.lysine.reimbursement.model.ReimbursementType;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovalWorkflowRepository
    extends JpaRepository<ApprovalWorkflow, String>,
        RevisionRepository<ApprovalWorkflow, String, Integer> {

  Optional<ApprovalWorkflow>
      findFirstByOrgIdAndReimbursementTypeAndIsActiveTrueAndMinAmountLessThanEqualAndMaxAmountGreaterThanEqual(
          String companyId, ReimbursementType type, BigDecimal amount1, BigDecimal amount2);

  List<ApprovalWorkflow> findFirstByOrgIdAndReimbursementTypeAndIsActiveTrue(
      String companyId, ReimbursementType type);
}
