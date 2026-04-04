package com.lysine.reimbursement.model;

import com.lysine.common.model.BaseEntity;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

@Getter
@Setter
@Audited
@Entity
public class Reimbursement extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(nullable = false)
  private Status status;

  @Column(nullable = false)
  private ReimbursementType reimbursementType;

  @Column(nullable = false)
  private String userId;

  @Column(nullable = false)
  private String description;

  @Audited(targetAuditMode = RelationTargetAuditMode.AUDITED)
  @OneToMany(
      mappedBy = "reimbursement",
      cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  private List<ReimbursementDocument> documents = new ArrayList<>();
}
