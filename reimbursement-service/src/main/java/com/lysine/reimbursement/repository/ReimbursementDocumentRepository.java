package com.lysine.reimbursement.repository;

import com.lysine.reimbursement.model.ReimbursementDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReimbursementDocumentRepository
    extends JpaRepository<ReimbursementDocument, String> {}
