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

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_group_id", nullable = false)
  private UserGroup company;

  // 🔥 VERY IMPORTANT
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "manager_id")
  private Account manager;
}
