package com.lysine.user.model;

import com.lysine.common.model.BaseEntity;
import jakarta.persistence.*;

@Entity
public class UserGroup extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String organisationName;
}
