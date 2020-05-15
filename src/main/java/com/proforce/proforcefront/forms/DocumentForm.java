package com.proforce.proforcefront.forms;

import com.proforce.proforcefront.client.DocumentClient;
import com.proforce.proforcefront.domain.DocumentDto;
import com.proforce.proforcefront.domain.PdfDto;
import com.proforce.proforcefront.view.DocumentView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class DocumentForm extends FormLayout {


    private TextField id = new TextField();
    private TextField name = new TextField();
    private TextField manufacturer = new TextField();
    private ComboBox<DocumentType> type = new ComboBox<>();
    private TextField expiryDate = new TextField();
    private Button save = new Button("Save");
    private Button delete = new Button("Delete");

    private Binder<DocumentDto> binder = new Binder<>(DocumentDto.class);

    private DocumentView documentView;

    private DocumentClient documentClient;

    public DocumentForm(DocumentView documentView, DocumentClient documentClient) {

        id.setPlaceholder("id");
        name.setPlaceholder("name");
        manufacturer.setPlaceholder("manufacturer");
        expiryDate.setPlaceholder("expiryDate");
        type.setItems(DocumentType.values());
        HorizontalLayout buttons = new HorizontalLayout(save, delete);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(id, name, manufacturer, type, expiryDate, buttons);
        binder.bindInstanceFields(this);
        setVisible(true);

        save.addClickListener(event -> save());
        delete.addClickListener(event -> delete());

        this.documentView = documentView;
        this.documentClient = documentClient;

    }

    public void save() {

        DocumentDto document = binder.getBean();
        document.setPdf(new PdfDto(""));
        documentClient.addDocument(document);
        documentView.refresh();
        setBinderDocument(null);

    }

    public void delete() {

        DocumentDto document = binder.getBean();
        documentClient.deleteDocument(document.getId());
        documentView.refresh();
        setBinderDocument(null);

    }

    public void setBinderDocument(DocumentDto documentDto) {

        binder.setBean(documentDto);

    }

}
