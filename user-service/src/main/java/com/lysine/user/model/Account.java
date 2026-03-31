package com.lysine.user.model;

import com.lysine.common.model.BaseEntity;
import jakarta.persistence.*;

@Entity
public class Account extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(nullable = false)
  private String name;

  private String companyName;

  @Column(unique = true, nullable = false)
  private String EmpId;

  @Column(nullable = false)
  private boolean isPartnerAccount;

  @Column(nullable = false)
  @ManyToOne
  @JoinColumn(name = "user_group_id", nullable = false)
  private String userGroupId;

  @Column(nullable = false)
  private String password;
}
