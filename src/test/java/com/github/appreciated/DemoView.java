package com.github.appreciated;

import com.github.appreciated.papermenubutton.HorizontalAlignment;
import com.github.appreciated.papermenubutton.PaperMenuButton;
import com.github.appreciated.papermenubutton.VerticalAlignment;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.Route;

@Route("")
@Push
public class DemoView extends Div {

    private final PaperMenuButton paperMenuButton;
    private final StyledPaperMenuButton styledPaperMenuButton;


    public DemoView() {
        paperMenuButton = new PaperMenuButton(
                new Button("Open"),
                getContentLayout()
        );

        styledPaperMenuButton = new StyledPaperMenuButton(
                new Button("Open"),
                getContentLayout()
        );

        paperMenuButton.setVerticalAlignment(VerticalAlignment.TOP);
        paperMenuButton.setHorizontalAlignment(HorizontalAlignment.RIGHT);

        styledPaperMenuButton.setVerticalAlignment(VerticalAlignment.TOP);
        styledPaperMenuButton.setHorizontalAlignment(HorizontalAlignment.RIGHT);

        VerticalLayout contentHolder = new VerticalLayout(paperMenuButton, styledPaperMenuButton);
        contentHolder.setSizeFull();
        contentHolder.setAlignItems(FlexComponent.Alignment.CENTER);
        contentHolder.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        add(contentHolder);
        setSizeFull();

        new Thread(() -> {
            //while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("isOpened = " + styledPaperMenuButton.isOpened());
            DemoView.this.getUI().ifPresent(ui -> ui.access(() -> {
                styledPaperMenuButton.setContentComponent(new VerticalLayout(getContent(), getContent()));
            }));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("isOpened = " + styledPaperMenuButton.isOpened());
            DemoView.this.getUI().ifPresent(ui -> ui.access(() -> {
                styledPaperMenuButton.setContentComponent(new VerticalLayout(getContent(), getContent(), getContent()));
            }));
        });//.start();
    }

    public VerticalLayout getContentLayout() {
        return new VerticalLayout(getContent());
    }

    Component getContent() {
        /*Span content = new Span("Lorem ipsum dolor sit amet, consetetur sadipscing elitr sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat.");
        content.setWidth("300px");
        content.setHeight("100px");*/
        VerticalLayout d = new VerticalLayout();
        for (int i = 0; i < 20; i++) {
            d.add(new Button("Test1234"));
        }
        return d;
    }
}
