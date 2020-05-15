package com.proforce.proforcefront.view;

import com.proforce.proforcefront.client.DocumentClient;
import com.proforce.proforcefront.domain.DocumentDto;
import com.proforce.proforcefront.forms.DocumentForm;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class DocumentView extends VerticalLayout {

    private Grid<DocumentDto> grid = new Grid<>(DocumentDto.class);
    private DocumentClient documentClient = new DocumentClient();
    private DocumentForm form = new DocumentForm(this, documentClient);
    private Button addNewDocument = new Button("Add New Document");

    private Button navButtonDoc = new Button("Documents");
    private Label welcomeBar = new Label("ProForce v1 Beta");
    private Label warningBar = new Label("Due to this app being a beta version, not everything might work. For more details, visit projects Github Page");
    private Label footerUpperText = new Label("https://github.com/Torayasu/Proforce_Front");
    private Label footerBottomText = new Label("Copyrighted @2020 Berserk Software");



    public DocumentView() {

        grid.setColumns("id","name","manufacturer","type","expiryDate");

        grid.asSingleSelect().addValueChangeListener(event ->
                form.setBinderDocument(grid.asSingleSelect().getValue()));

        addNewDocument.addClickListener(e -> {
            grid.asSingleSelect().clear();
            form.setBinderDocument(new DocumentDto());
        });

        grid.setSizeFull();
        grid.setVisible(true);

        warningBar.getStyle().set("color", "red");

        VerticalLayout topBar = new VerticalLayout(welcomeBar, warningBar);
        topBar.setAlignItems(Alignment.CENTER);
        HorizontalLayout navBar = new HorizontalLayout(navButtonDoc);
        VerticalLayout footer = new VerticalLayout(footerUpperText, footerBottomText);
        footer.setAlignItems(Alignment.END);
        HorizontalLayout toolbar = new HorizontalLayout(addNewDocument);
        HorizontalLayout mainContent = new HorizontalLayout(grid, form);

        add(topBar, navBar, toolbar, mainContent, footer);
        setSizeFull();

        refresh();

    }

    public void refresh() {
        grid.setItems(documentClient.getAllDocuments());
    }

}
