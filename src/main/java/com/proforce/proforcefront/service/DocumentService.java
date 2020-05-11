package com.proforce.proforcefront.service;

import com.proforce.proforcefront.domain.DocumentDto;
import com.proforce.proforcefront.forms.DocumentType;

import javax.print.Doc;
import javax.swing.text.Document;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DocumentService {

    private Set<DocumentDto> documents;
    private static DocumentService documentService;


    private DocumentService() {

        this.documents = exampleData();

    }

    public DocumentService(Set<DocumentDto> documents) {
        this.documents = documents;
    }

    public static DocumentService getInstance(){

        if (documentService == null) {
            documentService = new DocumentService();
        }
        return documentService;
    }

    public Set<DocumentDto> getDocuments() {
        return documents;
    }

    public void save(DocumentDto document) {
        documents.add(document);
    }

    public void delete(DocumentDto document) {
        documents.remove(document);
    }

    public Set<DocumentDto> findDocumentByType(String type) {

        return documents.stream()
                .filter(documentDto -> documentDto.getType().toString().contains(type.toString()))
                .collect(Collectors.toSet());

    }

    public Set<DocumentDto> exampleData() {

        Set<DocumentDto> documents = new HashSet<>();
        documents.add(new DocumentDto("1","ATEX","P+F",DocumentType.COC, "2022"));
        documents.add(new DocumentDto("2","PED","HYDAC",DocumentType.COC, "2022"));
        documents.add(new DocumentDto("3","EMC","Phoenix Contacts",DocumentType.DOC, "2023"));
        documents.add(new DocumentDto("4","CuTR","Cortem",DocumentType.DOC, "2034"));
        documents.add(new DocumentDto("5","EPA","Durag",DocumentType.LOECUTR, "2021"));
        documents.add(new DocumentDto("6","IES","ABB",DocumentType.LOECUTR, "2020"));
        documents.add(new DocumentDto("7","ISO","Emerson",DocumentType.COC, "2020"));
        return documents;

    }
}
