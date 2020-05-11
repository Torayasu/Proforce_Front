package com.proforce.proforcefront.view;


import com.proforce.proforcefront.domain.DocumentDto;
import com.proforce.proforcefront.forms.DocumentForm;
import com.proforce.proforcefront.service.DocumentService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    private DocumentService documentService = DocumentService.getInstance();
    private Grid<DocumentDto> grid = new Grid<>(DocumentDto.class);
    private TextField filter = new TextField();
    private DocumentForm form = new DocumentForm(this);


    public MainView() {

        filter.setPlaceholder("Filter by type");
        filter.setClearButtonVisible(true);
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> update());
        grid.setColumns("id","name","manufacturer","type","expiryDate");

        HorizontalLayout mainContent = new HorizontalLayout(grid, form);

        mainContent.setSizeFull();
        grid.setSizeFull();

        add(filter, mainContent);

        setSizeFull();

        refresh();
    }

    public void refresh() {

        grid.setItems(documentService.getDocuments());

    }

    private void update() {
        grid.setItems(documentService.findDocumentByType(filter.getValue()));
    }

}
