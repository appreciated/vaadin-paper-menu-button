package com.github.appreciated.papermenubutton;

/**
 * Note that the term "alignment" might be a little misleading in this case and note that I didn't come up with this myself
 * I simply took the term from the iron-papermenubutton api itself.
 * From my perspective the "alignment" describes in fact the anchor to which the iron-papermenubutton will be bound.
 * F.e:
 * TOP - LEFT will in fact overflow to the bottom right as soon as the element is larger than the element it is bound to.
 */
public class Alignment {
    private final HorizontalAlignment horizontalAlignment;
    private final VerticalAlignment verticalAlignment;

    public Alignment(HorizontalAlignment hor, VerticalAlignment ver) {
        this.horizontalAlignment = hor;
        this.verticalAlignment = ver;
    }

    public HorizontalAlignment getHorizontalAlignment() {
        return horizontalAlignment;
    }

    public VerticalAlignment getVerticalAlignment() {
        return verticalAlignment;
    }
}
