package com.example.document.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.example.document.exception.DocumentNotFoundException;
import com.example.document.model.Document;
import com.example.document.repository.DocumentRepository;

class DocumentServiceImplTest {

    @Mock
    private DocumentRepository documentRepository;

    @InjectMocks
    private DocumentServiceImpl documentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        Document doc = new Document("Test Title", "Test Content");
        when(documentRepository.save(doc)).thenReturn(doc);

        Document result = documentService.save(doc);

        assertEquals("Test Title", result.getTitle());
        verify(documentRepository, times(1)).save(doc);
    }

    @Test
    void testFindById_Success() {
        Document doc = new Document("Found Title", "Found Content");
        doc.setId(1L);

        when(documentRepository.findById(1L)).thenReturn(Optional.of(doc));

        Optional<Document> result = documentService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals("Found Title", result.get().getTitle());
    }

    @Test
    void testFindById_NotFound() {
        when(documentRepository.findById(99L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(DocumentNotFoundException.class, () -> {
            documentService.findById(99L);
        });

        assertTrue(exception.getMessage().contains("Document not found"));
    }

    @Test
    void testFindAll() {
        List<Document> docs = Arrays.asList(
                new Document("Doc1", "Content1"),
                new Document("Doc2", "Content2")
        );
        when(documentRepository.findAll()).thenReturn(docs);

        List<Document> result = documentService.findAll();

        assertEquals(2, result.size());
        verify(documentRepository, times(1)).findAll();
    }

    @Test
    void testDeleteById() {
        doNothing().when(documentRepository).deleteById(1L);

        documentService.deleteById(1L);

        verify(documentRepository, times(1)).deleteById(1L);
    }
}
