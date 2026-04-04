package com.lysine.reimbursement.model;

import com.lysine.common.model.BaseEntity;
import jakarta.persistence.*;
import org.hibernate.envers.Audited;

@Entity
@Audited
public class Approver extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(nullable = false)
  private String userId;

  @Column(nullable = false)
  private String userGroupId;
}
