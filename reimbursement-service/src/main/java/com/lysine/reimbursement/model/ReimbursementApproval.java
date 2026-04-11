package com.lysine.reimbursement.model;

import com.lysine.common.model.BaseEntity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.Id;

@ToString
@Setter
@Getter
@SuperBuilder
@Audited
@Entity
public class ReimbursementApproval extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "reimbursement_id", nullable = false)
  private Reimbursement reimbursement;

  @Column(nullable = false)
  private Integer stepOrder;

  @Column(name = "approver_id", nullable = false)
  private String approver;

  @Enumerated(EnumType.STRING)
  private Status status; // PENDING, APPROVED, REJECTED

  private LocalDateTime actionDate;

  private String remarks;
}
