package com.lysine.reimbursement.repository;

import com.lysine.reimbursement.model.ApprovalWorkflow;
import com.lysine.reimbursement.model.ReimbursementType;
import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovalWorkflowRepository extends JpaRepository<ApprovalWorkflow, String> {

  Optional<ApprovalWorkflow>
      findFirstByCompanyIdAndReimbursementTypeAndIsActiveTrueAndMinAmountLessThanEqualAndMaxAmountGreaterThanEqual(
          String companyId, ReimbursementType type, BigDecimal amount1, BigDecimal amount2);
}
