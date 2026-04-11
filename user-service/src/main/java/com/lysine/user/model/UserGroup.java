package com.lysine.user.model;

import com.lysine.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;

@Audited
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class UserGroup extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String OrgId;

  @Column(nullable = false)
  private String organisationName;
}
