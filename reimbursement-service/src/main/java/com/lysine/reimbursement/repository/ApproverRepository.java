package com.lysine.reimbursement.repository;

import com.lysine.reimbursement.model.Approver;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApproverRepository extends JpaRepository<Approver, String> {

  Optional<Approver> findByUserId(String userId);

  List<Approver> findByUserGroupId(String userGroupId);

  List<Approver> findByUserIdAndUserGroupId(String userId, String userGroupId);

  boolean existsByUserId(String userId);
}
