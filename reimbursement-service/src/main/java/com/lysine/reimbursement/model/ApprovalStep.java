package com.lysine.reimbursement.model;

import com.lysine.common.model.BaseEntity;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.envers.Audited;

@ToString
@Setter
@Getter
@Audited
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
