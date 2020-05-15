package com.proforce.proforcefront.client;

import com.proforce.proforcefront.domain.DocumentDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;


public class DocumentClient {

    private static final String API_ENDPOINT = "https://proforce-core.herokuapp.com/v1/doc";

    private RestTemplate restTemplate = new RestTemplate();

    public List<DocumentDto> getAllDocuments() {

        URI url = UriComponentsBuilder.fromHttpUrl(API_ENDPOINT).encode().build().toUri();

        DocumentDto[] resultAsArray = restTemplate.getForObject(url, DocumentDto[].class);

        return Arrays.asList(resultAsArray);

    }
    public List<DocumentDto> getAllDocumentsByType(String type) {

        URI url = UriComponentsBuilder.fromHttpUrl(API_ENDPOINT+"/"+type).encode().build().toUri();

        return Arrays.asList(restTemplate.getForObject(url, DocumentDto[].class));

    }


    public DocumentDto addDocument(DocumentDto documentDto) {

        URI url = UriComponentsBuilder.fromHttpUrl(API_ENDPOINT).encode().build().toUri();

        HttpEntity<DocumentDto> entity = new HttpEntity<>(documentDto);

        ResponseEntity<DocumentDto> result = restTemplate.postForEntity(url, entity, DocumentDto.class);

        return result.getBody();
    }

    public void deleteDocument(String id) {

        URI url = UriComponentsBuilder.fromHttpUrl(API_ENDPOINT+"/"+id).encode().build().toUri();

        restTemplate.delete(url);

    }

}
