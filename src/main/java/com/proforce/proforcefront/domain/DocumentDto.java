package com.proforce.proforcefront.domain;

import com.proforce.proforcefront.forms.DocumentType;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Getter
public class DocumentDto {

    private String id;
    private String name;
    private String manufacturer;
    private DocumentType type;
    private String expiryDate;


    public DocumentDto() {
    }

    public DocumentDto(String id, String name, String manufacturer, DocumentType type, String expiryDate) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.type = type;
        this.expiryDate = expiryDate;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentDto that = (DocumentDto) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(manufacturer, that.manufacturer) &&
                Objects.equals(type, that.type) &&
                Objects.equals(expiryDate, that.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, manufacturer, type, expiryDate);
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
}
