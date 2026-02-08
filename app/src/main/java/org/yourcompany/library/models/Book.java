package org.yourcompany.library.models;

public class Book {
    String title;
    String author;
    boolean isCheckedOut = false;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public String getTitle() {
        return this.title;
    }
    public String getAuthor() {
        return this.author;
    }
    public boolean getIsCheckedOut() {
        return this.isCheckedOut;
    }
    public void checkOut() {
        this.isCheckedOut = true;
    }
    public void returnBook() {
        this.isCheckedOut = false;
    }
}

