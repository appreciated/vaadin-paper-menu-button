package com.github.appreciated.papermenubutton;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.html.Div;

@Tag("paper-menu-button")
@NpmPackage(value = "@polymer/paper-menu-button", version = "3.0.1")
@JavaScript("https://cdnjs.cloudflare.com/ajax/libs/web-animations/2.3.2/web-animations-next-lite.min.js")
@JsModule("@polymer/paper-menu-button/paper-menu-button.js")
public class PaperMenuButton extends Component implements HasStyle {

    private Div contentHolder;
    private Component triggerComponent;
    private Component contentComponent;

    public PaperMenuButton(Component triggerComponent, Component contentComponent) {
        setTriggerComponent(triggerComponent);
        setContentComponent(contentComponent);
        setVerticalAlignment(VerticalAlignment.TOP);
        setHorizontalAlignment(HorizontalAlignment.LEFT);
        getElement().synchronizeProperty("opened", "opened-changed");
    }

    public Component getContentComponent() {
        return contentComponent;
    }

    public void setContentComponent(Component content) {
        this.contentComponent = content;
        if (this.contentHolder == null) {
            contentHolder = new Div();
            this.contentHolder.getElement().setAttribute("slot", "dropdown-content");
            getElement().appendChild(contentHolder.getElement());
        }
        contentHolder.removeAll();
        contentHolder.add(contentComponent);
    }

    public Component getTriggerComponent() {
        return triggerComponent;
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
        getElement().callJsFunction("open");
    }

    /**
     * Hides the dropdown content.
     */
    public void close() {
        getElement().callJsFunction("close");
    }

    /**
     * True if the content is currently displayed.
     *
     * @return
     */
    public boolean isOpened() {
        return getElement().getProperty("opened", false);
    }

    public void setTriggerComponent(Component triggerComponent) {
        if (this.triggerComponent != null) {
            getElement().removeChild(this.triggerComponent.getElement());
        }
        this.triggerComponent = triggerComponent;
        this.triggerComponent.getElement().setAttribute("slot", "dropdown-trigger");
        getElement().appendChild(triggerComponent.getElement());
    }

}
