package com.gla.encapsulation;

public abstract class LibraryItem {
    protected int itemId;
    protected String title;

    public LibraryItem(int id, String title) {
        itemId = id;
        this.title = title;
    }

    public abstract int getLoanDuration();

    public void getItemDetails() {
        System.out.println("Title: " + title);
    }
}