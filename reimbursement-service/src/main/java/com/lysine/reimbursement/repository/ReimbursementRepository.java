package com.lysine.reimbursement.repository;

import com.lysine.reimbursement.model.Reimbursement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReimbursementRepository extends JpaRepository<Reimbursement, String> {}
