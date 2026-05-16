package com.lysine.reimbursement.model;

import com.lysine.common.model.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.Audited;

@ToString
@Setter
@Getter
@Audited
@Entity
public class ApprovalWorkflow extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @NotNull private String orgId;

  @Column(nullable = false)
  private String name;

  @NotNull
  @Enumerated(EnumType.STRING)
  private ReimbursementType reimbursementType;

  @NotNull private BigDecimal minAmount;

  @NotNull private BigDecimal maxAmount;

  @NotNull private Boolean isActive = true;
}
