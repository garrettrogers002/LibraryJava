package org.yourcompany.library.services;

import java.util.ArrayList;

import org.yourcompany.library.models.Book;

public class LibraryService {
    static ArrayList<Book> bookList = new ArrayList<>();
    static ArrayList<String> titleList = new ArrayList<>();
    static String bookTitle;
    static int counter = 0;
    static int indexer = 0;
    static Book daBook;

    public static void addBook(String name, String author) {
        Book newObj = new Book(name, author);
        bookList.add(newObj);
        bookTitle = newObj.getTitle();
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
        counter = 0;
        return arr;
    }
    public static void viewCollection() {
        titleList.forEach(System.out::println);
    }

    public static void checkoutBook(String name) {
        System.out.println("placeholder - checkoutBook()"); // i forgot why i have this  here
    }
    public static Book selectBook(String trueBookTitle) {
        
        System.out.println("Selected "+trueBookTitle+"\n\n");
        
        bookList.forEach(book -> { // probably more efficient to use indexing or something
            if (trueBookTitle.equals(book.getTitle())) {
                String statement = (book.getIsCheckedOut()) ? " is checked out" : " is in stock";
                System.out.println(book.getTitle()+statement);
                daBook = bookList.get(indexer);
            }
            indexer++;
        });
        return daBook;
    }
}