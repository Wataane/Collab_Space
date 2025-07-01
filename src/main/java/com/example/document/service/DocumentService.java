package com.example.document.service;

import java.util.List;
import java.util.Optional;

import com.example.document.model.Document;

public interface DocumentService {
    Document save(Document document);
    Optional<Document> findById(Long id);
    List<Document> findAll();
    void deleteById(Long id);
}
