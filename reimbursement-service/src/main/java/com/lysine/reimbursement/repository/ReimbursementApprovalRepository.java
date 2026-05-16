package com.lysine.reimbursement.repository;

import com.lysine.reimbursement.model.ReimbursementApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReimbursementApprovalRepository
    extends JpaRepository<ReimbursementApproval, String>,
        RevisionRepository<ReimbursementApproval, String, Integer> {}
