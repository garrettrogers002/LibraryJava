package org.yourcompany.library.services;

import java.util.ArrayList;

import org.yourcompany.library.models.Book;

public class LibraryService {
    static ArrayList<Book> bookList = new ArrayList<>();
    static ArrayList<String> titleList = new ArrayList<>();
    static String bookTitle;

    public static void addBook(String name, String author) {
        Book newObj = new Book(name, author);
        bookList.add(newObj);
        bookTitle = newObj.getTitle();
        // System.out.println(bookTitle);
        titleList.add(bookTitle);
        System.out.println(titleList);
    }

    public static void findBook(String name) {
        bookList.forEach(book -> {
            if (book.getTitle().equals(name)) {
                String bookName = book.getTitle();
                String bookAuthor = book.getAuthor();
                System.out.println(bookName+ " written by "+bookAuthor);
            }
        });
    }
    public static void viewCollection() {
        System.out.println(bookList);
    }

    public static void checkoutBook(String name) {
        System.out.println("placeholder - checkoutBook()");
    }
}
