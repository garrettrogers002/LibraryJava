package org.yourcompany.library.models;

public class Book {
    private final String title;
    private final String author;
    private boolean isCheckedOut = false;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public boolean getIsCheckedOut() {
        return isCheckedOut;
    }
    public void checkOut() {
        this.isCheckedOut = true;
    }
    public void returnBook() {
        this.isCheckedOut = false;
    }
}

