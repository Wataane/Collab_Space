package com.example.document.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.document.model.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    // You can add custom queries here if needed
}
