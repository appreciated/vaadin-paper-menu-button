package com.github.appreciated.papermenubutton;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;

@Tag("paper-menu-button")
@HtmlImport("frontend://bower_components/paper-menu-button/paper-menu-button.html")
@HtmlImport("frontend://bower_components/neon-animation/web-animations.html")
public class PaperMenuButton extends Component implements HasStyle {

    private Component content;
    private Component button;

    public PaperMenuButton(Component button, Component content) {
        setButton(button);
        setContent(content);
        setVerticalAlignment(VerticalAlignment.TOP);
        setHorizontalAlignment(HorizontalAlignment.LEFT);
        getElement().synchronizeProperty("opened", "opened-changed");
    }

    public void setContent(Component content) {
        if (this.content != null) {
            getElement().removeChild(this.content.getElement());
        }
        this.content = content;
        this.content.getElement().setAttribute("slot", "dropdown-content");
        getElement().appendChild(content.getElement());
    }

    public void setButton(Component button) {
        if (this.button != null) {
            getElement().removeChild(this.button.getElement());
        }
        this.button = button;
        this.button.getElement().setAttribute("slot", "dropdown-trigger");
        getElement().appendChild(button.getElement());
    }


    public void setVerticalAlignment(VerticalAlignment verticalAlignment) {
        getElement().setAttribute("vertical-align", verticalAlignment.getAlignment());
    }

    public void setHorizontalAlignment(HorizontalAlignment horizontalAlignment) {
        getElement().setAttribute("horizontal-align", horizontalAlignment.getAlignment());
    }

    /**
     * To allow to style the content wrapper
     *
     * @return the div containing the content
     */
    public Component getContent() {
        return content;
    }

    public boolean isOpened() {
        return getElement().getProperty("opened", false);
    }

    /**
     * To allow to style the button wrapper
     *
     * @return the div containing the "button"-wrapper
     */
    public Component getButton() {
        return button;
    }

}
