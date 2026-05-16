package com.lysine.reimbursement.model;

import com.lysine.common.model.BaseEntity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Getter
@Setter
@Audited
@Entity
public class Reimbursement extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(name = "user_id", nullable = false)
  private String userId;

  @Column(name = "company_id", nullable = false)
  private String companyId;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Status status;

  @Enumerated(EnumType.STRING)
  private ReimbursementType reimbursementType;

  private BigDecimal amount;

  private LocalDate expenseDate;

  private String description;

  private LocalDateTime submittedAt;

  private String approvedBy;
  private LocalDateTime approvedAt;
  private String rejectionReason;

  @Column(name = "workflow_id")
  private String workflowId;
}
