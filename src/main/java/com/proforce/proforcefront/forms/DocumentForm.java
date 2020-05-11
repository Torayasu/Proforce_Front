package com.proforce.proforcefront.forms;

import com.proforce.proforcefront.domain.DocumentDto;
import com.proforce.proforcefront.service.DocumentService;
import com.proforce.proforcefront.view.MainView;
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
    private TextField manfacturer = new TextField();
    private ComboBox<DocumentType> type = new ComboBox<>();
    private TextField expiryDate = new TextField();

    private Button save = new Button("Save");
    private Button delete = new Button("Delete");

    private Binder<DocumentDto> binder = new Binder<>(DocumentDto.class);

    private DocumentService service = DocumentService.getInstance();

    private MainView mainView;

    public DocumentForm(MainView mainView) {

        type.setItems(DocumentType.values());
        HorizontalLayout buttons = new HorizontalLayout(save, delete);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(id, name, manfacturer, type, expiryDate, buttons);
        binder.bindInstanceFields(this);

        save.addClickListener(event -> save());
        delete.addClickListener(event -> delete());

        this.mainView = mainView;

    }

    public void save() {

        DocumentDto document = binder.getBean();
        service.save(document);
        mainView.refresh();

    }

    public void delete() {

        DocumentDto document = binder.getBean();
        service.delete(document);
        mainView.refresh();
    }
}
