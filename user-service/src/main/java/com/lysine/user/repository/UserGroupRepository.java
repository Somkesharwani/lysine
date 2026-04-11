package com.lysine.user.repository;

import com.lysine.user.model.UserGroup;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroupRepository
    extends JpaRepository<UserGroup, String>, RevisionRepository<UserGroup, String, Integer> {

  /** Find user groups by organization ID */
  List<UserGroup> findByOrgId(String orgId);

  /** Find user groups by organization name */
  List<UserGroup> findByOrganisationName(String organisationName);

  /** Find user group by name and organization ID */
  UserGroup findByNameAndOrgId(String name, String orgId);
}
