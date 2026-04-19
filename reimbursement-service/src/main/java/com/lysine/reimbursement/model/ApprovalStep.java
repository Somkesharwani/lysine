package com.lysine.reimbursement.model;

import com.lysine.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

@ToString
@Setter
@Getter
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"workflow_id", "step_order"})})
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

  private String role;

  // 🔥 FIXED
  @Column(name = "user_id")
  private String userId;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private ApprovalMode approvalMode;

  private Boolean isMandatory = true;

  // future-ready
  private Integer hierarchyLevel;
}
