package org.yourcompany.library.services;

import java.util.ArrayList;
import java.util.List;

import org.yourcompany.library.models.Book;

public class LibraryService {
    List<Book> bookList = new ArrayList<>();
    List<String> titleList = new ArrayList<>();
    String bookTitle;

    public void addBook(String name, String author) {
        Book newObj = new Book(name, author);
        bookList.add(newObj);
        bookTitle = newObj.getTitle();
        titleList.add(bookTitle);
        System.out.println(titleList);
    }

    public List<Book> findBook(String name) {
        List<Book> bookMatches = new ArrayList<>();
        String lowercaseName = name.toLowerCase();
        bookList.forEach(book -> {
            String lowercaseTitle = book.getTitle().toLowerCase();
            if (lowercaseTitle.contains(lowercaseName)) {
                bookMatches.add(book);
            }
        });
        return bookMatches;
    }
    public void viewCollection() {
        titleList.forEach(System.out::println);
    }

    public void checkoutBook(String name) {
        System.out.println("placeholder - checkoutBook()");
    }
}