package com.github.appreciated.papermenubutton;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;

@Tag("paper-menu-button")
@HtmlImport("frontend://bower_components/paper-menu-button/paper-menu-button.html")
@HtmlImport("frontend://bower_components/neon-animation/web-animations.html")
/**
 */
public class PaperMenuButton extends Component implements HasStyle {

    private Div contentHolder;
    private Component button;

    public PaperMenuButton(Component button, Component content) {
        setButton(button);
        setContent(content);
        setVerticalAlignment(VerticalAlignment.TOP);
        setHorizontalAlignment(HorizontalAlignment.LEFT);
        getElement().synchronizeProperty("opened", "opened-changed");
    }

    public void setContent(Component content) {
        if (this.contentHolder == null) {
            contentHolder = new Div();
            this.contentHolder.getElement().setAttribute("slot", "dropdown-content");
            getElement().appendChild(contentHolder.getElement());
        }
        contentHolder.removeAll();
        contentHolder.add(content);
    }

    public void setButton(Component button) {
        if (this.button != null) {
            getElement().removeChild(this.button.getElement());
        }
        this.button = button;
        this.button.getElement().setAttribute("slot", "dropdown-trigger");
        getElement().appendChild(button.getElement());
    }

    /**
     * @param verticalAlignment
     */
    public void setVerticalAlignment(VerticalAlignment verticalAlignment) {
        getElement().setAttribute("vertical-align", verticalAlignment.getAlignment());
    }

    /**
     * @param horizontalAlignment
     */
    public void setHorizontalAlignment(HorizontalAlignment horizontalAlignment) {
        getElement().setAttribute("horizontal-align", horizontalAlignment.getAlignment());
    }

    /**
     * @param dynamicAlign
     */
    public void setDynamicAlign(boolean dynamicAlign) {
        getElement().setProperty("dynamicAlign", dynamicAlign);
    }

    /**
     * @param overlap
     */
    public void setNoOverlap(boolean overlap) {
        getElement().setProperty("noOverlap", overlap);
    }

    /**
     * @param ignoreSelect
     */
    public void setIgnoreSelect(boolean ignoreSelect) {
        getElement().setProperty("ignoreSelect", ignoreSelect);
    }

    /**
     * @param restoreFocusOnClose
     */
    public void setRestoreFocusOnClose(boolean restoreFocusOnClose) {
        getElement().setProperty("restoreFocusOnClose", restoreFocusOnClose);
    }

    /**
     * @param allowOutsideScroll
     */
    public void setAllowOutsideScroll(boolean allowOutsideScroll) {
        getElement().setProperty("allowOutsideScroll", allowOutsideScroll);
    }

    /**
     * @param closeOnActivate
     */
    public void setCloseOnActivate(boolean closeOnActivate) {
        getElement().setProperty("closeOnActivate", closeOnActivate);
    }

    /**
     * @param verticalOffset
     */
    public void setVerticalOffset(int verticalOffset) {
        getElement().setProperty("verticalOffset", verticalOffset);
    }

    /**
     * @param horizontalOffset
     */
    public void setHorizontalOffset(int horizontalOffset) {
        getElement().setProperty("horizontalOffset", horizontalOffset);
    }

    /**
     * @param noAnimations
     */
    public void setNoAnimations(boolean noAnimations) {
        getElement().setProperty("noAnimations", noAnimations);
    }

    /**
     * Shows the dropdown content.
     */
    public void open() {
        getElement().callFunction("open");
    }

    /**
     * Hides the dropdown content.
     */
    public void close() {
        getElement().callFunction("close");
    }

    /**
     * True if the content is currently displayed.
     *
     * @return
     */
    public boolean isOpened() {
        return getElement().getProperty("opened", false);
    }

    public Component getButton() {
        return button;
    }

}
