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

  @Column(name = "lable", nullable = false)
  private String label;

  @Column(nullable = false)
  private String filePath;

  @ManyToOne
  @JoinColumn(name = "reimbursement_id", nullable = false)
  private Reimbursement reimbursement;
}
