package com.lysine.reimbursement.model;

import com.lysine.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Getter
@Setter
@Entity
@Audited
public class ReimbursementDocument extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private String label;

  private String fileUrl;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "reimbursement_id")
  private Reimbursement reimbursement;
}
