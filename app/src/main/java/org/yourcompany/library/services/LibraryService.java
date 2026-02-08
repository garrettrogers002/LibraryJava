package org.yourcompany.library.services;

import java.util.ArrayList;

import org.yourcompany.library.models.Book;

public class LibraryService {
    static ArrayList<Book> bookList = new ArrayList<>();
    static ArrayList<String> titleList = new ArrayList<>();
    static String bookTitle;
    static int counter = 0;

    public static void addBook(String name, String author) {
        Book newObj = new Book(name, author);
        bookList.add(newObj);
        bookTitle = newObj.getTitle();
        // System.out.println(bookTitle);
        titleList.add(bookTitle);
        System.out.println(titleList);
    }

    public static String[] findBook(String name) {
        ArrayList<String> titleMatches = new ArrayList<>();
        String lowercaseName = name.toLowerCase();
        bookList.forEach(book -> {
            String lowercaseTitle = book.getTitle().toLowerCase();
            if (lowercaseTitle.contains(lowercaseName)) {
                String bookName = book.getTitle();
                String bookAuthor = book.getAuthor();
                String catString = bookName+ " written by "+bookAuthor; // read below comment
                titleMatches.add(catString); // this was a waste, but it was in an effort to make the return type work
            }
        });

        int arraySize = titleMatches.size();
        String[] arr = new String[arraySize];
        titleMatches.forEach(title -> {
            arr[counter] = title;
            counter++;
        });
        counter = 1;
        return arr;
        

        // System.out.println("\n\ntotal matches: "+ titleMatches.size()+"\n");
        // titleMatches.forEach(title -> {
        //     System.out.println(counter+". "+title);
        //     counter++;
        // });
        // System.out.println("\n\n\n");
        // counter = 1;
    }
    public static void viewCollection() {
        titleList.forEach(System.out::println);
    }

    public static void checkoutBook(String name) {
        System.out.println("placeholder - checkoutBook()");
    }
}
