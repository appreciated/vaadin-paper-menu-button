package com.github.appreciated;

import com.github.appreciated.papermenubutton.HorizontalAlignment;
import com.github.appreciated.papermenubutton.PaperMenuButton;
import com.github.appreciated.papermenubutton.VerticalAlignment;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")

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
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("isOpened = " + paperMenuButton.isOpened());
            }
        }).start();
    }

    public HorizontalLayout getContentLayout() {
        Span content = new Span("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat.");
        content.setWidth("300px");
        content.setHeight("300px");
        return new HorizontalLayout(content);
    }
}
