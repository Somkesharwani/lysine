package com.lysine.reimbursement.model;

import com.lysine.common.model.BaseEntity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.Id;

@ToString
@Setter
@Getter
@Audited
@Entity
public class ApprovalWorkflow extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(name = "company_id", nullable = false)
  private String companyId;

  @Column(nullable = false)
  private String name;

  @Enumerated(EnumType.STRING)
  private ReimbursementType reimbursementType;

  private BigDecimal minAmount;
  private BigDecimal maxAmount;

  private Boolean isActive = true;
}
