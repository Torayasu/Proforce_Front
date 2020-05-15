package com.proforce.proforcefront.client;

import com.google.gson.Gson;
import com.proforce.proforcefront.domain.DocumentDto;
import com.proforce.proforcefront.domain.PdfDto;
import com.proforce.proforcefront.forms.DocumentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DocumentClientTest {

    @Autowired
    private DocumentClient documentClient;

    Gson gson = new Gson();

    @Test
    public void testGetAllDocs() {

        List<DocumentDto> result = documentClient.getAllDocuments();

        result.stream().forEach(System.out::println);

    }

    @Test
    public void testAddDoc() {

        DocumentDto docToBeAdded = new DocumentDto("CuTR012","Cortem",DocumentType.COCCUTR,"2022-11-22", new PdfDto("http://test.com"));

        DocumentDto addedDoc = documentClient.addDocument(docToBeAdded);

        assertEquals("CuTR012", addedDoc.getName());
        assertNotNull(addedDoc.getId());
    }

}
