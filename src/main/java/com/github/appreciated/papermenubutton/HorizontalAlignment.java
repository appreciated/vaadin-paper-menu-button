package com.github.appreciated.papermenubutton;

public enum HorizontalAlignment {
    RIGHT("right"), LEFT("left");

    private String alignment;

    HorizontalAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getAlignment() {
        return alignment;
    }
}
