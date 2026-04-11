package com.lysine.reimbursement.model;

import com.lysine.common.model.BaseEntity;
import com.lysine.user.model.Account;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

@ToString
@Setter
@Getter
@SuperBuilder
@Entity
public class ApprovalStep extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "workflow_id", nullable = false)
  private ApprovalWorkflow workflow;

  @Column(nullable = false)
  private Integer stepOrder;

  @Enumerated(EnumType.STRING)
  private ApproverType approverType;

  // MANAGER, ROLE, USER

  private String role; // optional (e.g. FINANCE)

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private Account user; // for fixed approver

  @Enumerated(EnumType.STRING)
  private ApprovalMode approvalMode;

  // ANY_ONE, ALL

  private Boolean isMandatory = true;
}
