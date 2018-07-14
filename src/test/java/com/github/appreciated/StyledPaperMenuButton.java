package com.github.appreciated;

import com.github.appreciated.papermenubutton.PaperMenuButton;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.HtmlImport;

@HtmlImport("frontend://styles/custom-styles.html")
public class StyledPaperMenuButton extends PaperMenuButton {
    public StyledPaperMenuButton(Component button, Component content) {
        super(button, content);
        getElement().getClassList().add("styled");
    }
}
