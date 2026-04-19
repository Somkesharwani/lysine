package com.lysine.reimbursement.model;

import com.lysine.common.model.BaseEntity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@ToString
@Entity
@Table(
    name = "reimbursement_approval",
    indexes = {
      @Index(name = "idx_reim_step", columnList = "reimbursement_id, step_order"),
      @Index(name = "idx_approver_status", columnList = "approver_id, status")
    })
public class ReimbursementApproval extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  // 🔗 Which reimbursement this belongs to
  @Column(name = "reimbursement_id", nullable = false)
  private String reimbursementId;

  // 🔢 Step number (sequence)
  @Column(name = "step_order", nullable = false)
  private Integer stepOrder;

  // 👤 Who needs to approve
  @Column(name = "approver_id", nullable = false)
  private String approverId;

  // 📌 Current status of this approver
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Status status;

  // PENDING, APPROVED, REJECTED, SKIPPED

  // 🕒 When action happened
  private LocalDateTime actionDate;

  // 📝 Optional comments
  private String remarks;

  // ⚙️ Behavior of this step (copied from ApprovalStep)
  @Enumerated(EnumType.STRING)
  private ApprovalMode approvalMode;

  // ANY_ONE / ALL

  // 🧠 Snapshot fields (VERY IMPORTANT for audit)

  private String approverName; // store at time of creation
  private String approverRole; // e.g. FINANCE
}
