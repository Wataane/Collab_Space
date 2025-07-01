package com.example.document.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.document.exception.DocumentNotFoundException;
import com.example.document.model.Document;
import com.example.document.repository.DocumentRepository;

@Service
public class DocumentServiceImpl implements DocumentService {

    private static final Logger logger = LoggerFactory.getLogger(DocumentServiceImpl.class);
    private final DocumentRepository documentRepository;

    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public Document save(Document document) {
        Document saved = documentRepository.save(document);
        logger.info("Saved document with ID: {}", saved.getId());
        return saved;
    }

    @Override
    public Optional<Document> findById(Long id) {
        Optional<Document> document = documentRepository.findById(id);
        if (document.isEmpty()) {
            logger.warn("Document not found with ID: {}", id);
            throw new DocumentNotFoundException(id);
        }
        logger.info("Fetched document with ID: {}", id);
        return document;
    }

    @Override
    public List<Document> findAll() {
        List<Document> documents = documentRepository.findAll();
        logger.info("Fetched {} documents from DB", documents.size());
        return documents;
    }

    @Override
    public void deleteById(Long id) {
        logger.info("Deleting document with ID: {}", id);
        documentRepository.deleteById(id);
    }
}
