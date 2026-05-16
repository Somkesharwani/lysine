package com.lysine.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lysine.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;

@Audited
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(
    indexes = {
      @Index(name = "idx_role_company", columnList = "role, user_group_id"),
      @Index(name = "idx_manager", columnList = "manager_id")
    })
public class Account extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(nullable = false)
  private String name;

  @Column(unique = true, nullable = false)
  private String empId;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String passwordHash;

  @Column(name = "user_group_id", nullable = false)
  private String companyId;

  // 🔥 VERY IMPORTANT
  @JsonIgnore
  @Column(name = "manager_id")
  private String managerId;

  @Column(nullable = false)
  private String role;
}
