package com.lysine.reimbursement.repository;

import com.lysine.reimbursement.model.ReimbursementDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReimbursementDocumentRepository
    extends JpaRepository<ReimbursementDocument, String> {}
