package com.proforce.proforcefront.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.proforce.proforcefront.forms.DocumentType;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("manufacturer")
    private String manufacturer;

    @JsonProperty("type")
    private DocumentType type;

    @JsonProperty("expiryDate")
    private String expiryDate;

    @JsonProperty("pdf")
    private PdfDto pdf;


    public DocumentDto() {
    }

    public DocumentDto(String name, String manufacturer, DocumentType type, String expiryDate) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.type = type;
        this.expiryDate = expiryDate;
    }


    public DocumentDto(String id, String name, String manufacturer, DocumentType type, String expiryDate) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.type = type;
        this.expiryDate = expiryDate;
    }
    public DocumentDto(String name, String manufacturer, DocumentType type, String expiryDate, PdfDto pdf) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.type = type;
        this.expiryDate = expiryDate;
        this.pdf = pdf;
    }





    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setType(DocumentType type) {
        this.type = type;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setPdf(PdfDto pdf) {
        this.pdf = pdf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentDto that = (DocumentDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(manufacturer, that.manufacturer) &&
                type == that.type &&
                Objects.equals(expiryDate, that.expiryDate) &&
                Objects.equals(pdf, that.pdf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, manufacturer, type, expiryDate, pdf);
    }

    @Override
    public String toString() {
        return "DocumentDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", type=" + type +
                ", expiryDate='" + expiryDate + '\'' +
                ", pdf=" + pdf +
                '}';
    }
}


